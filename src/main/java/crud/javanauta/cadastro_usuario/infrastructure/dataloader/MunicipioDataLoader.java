package crud.javanauta.cadastro_usuario.infrastructure.dataloader;

import crud.javanauta.cadastro_usuario.infrastructure.entitys.Municipio;
import crud.javanauta.cadastro_usuario.infrastructure.entitys.UF;
import crud.javanauta.cadastro_usuario.infrastructure.repository.MunicipioRepository;
import crud.javanauta.cadastro_usuario.infrastructure.repository.UFRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
@Profile("postgres")
@RequiredArgsConstructor
public class MunicipioDataLoader implements CommandLineRunner {

    private final MunicipioRepository municipioRepository;
    private final UFRepository ufRepository;

    @Override
    public void run(String... args) throws Exception{

        if (municipioRepository.count() > 0){
            log.info("Municipios já carregados.");
            return;
        }
        var inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream("data/municipios.csv");

        if (inputStream == null){
            throw new RuntimeException("Arquivo não encontrado.");
        }
        try (BufferedReader reader =
                new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) !=null){
                if (line.isBlank()){
                    continue;
                }
                if (firstLine){
                    firstLine = false;
                    continue;
                }

                String[] columns = line.split(";");

                if (columns.length < 5){
                    log.warn("Linha ignorada(colunas insuficientes: {}", line);
                    continue;
                }

                String codigoMunicipio = columns[1].trim(); //IBGE
                String nomeMunicipio = columns[3].trim(); // nome IBGE
                String uFSigla = columns[4].trim(); //UF

                if (codigoMunicipio.isEmpty() || nomeMunicipio.isEmpty() || uFSigla.isEmpty()){
                    log.warn("Linha Ignorada(dados vazios): {}", line);
                    continue;
                }
                //UF
                UF uf = ufRepository.findById(uFSigla).orElseGet(()->{
                    UF novaUf = new UF();
                    novaUf.setSigla(uFSigla);
                    novaUf.setNome(uFSigla);
                    return ufRepository.save(novaUf);
                });

                // Municipio
                if (!municipioRepository.existsById(codigoMunicipio)){
                    Municipio municipio = new Municipio();
                    municipio.setCodigo(codigoMunicipio);
                    municipio.setNome(nomeMunicipio);
                    municipio.setUf(uf);
                    municipioRepository.save(municipio);
                }

            }
        }
        log.info("Carga incial de municipios finalizadas com sucesso");
    }
}
