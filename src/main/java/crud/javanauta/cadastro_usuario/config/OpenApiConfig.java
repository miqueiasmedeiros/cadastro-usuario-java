package crud.javanauta.cadastro_usuario.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API Cadastro de Usuários",
                version = "1.0.0",
                description = "API para cadastro de Pessoa Física e Jurídica",
                contact = @Contact(
                        name = "Miquéias Medeiros",
                        email = "miqueiascompany@gmail.com"
                )
        )
)
public class OpenApiConfig {
}
