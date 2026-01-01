package crud.javanauta.cadastro_usuario.util;

public class ValidaCpfCnpj {
    public static void main(String[] args) {
        boolean isCPF = ValidaCPF.isCPF("151.160.087-04");
        System.out.println("Cpf válido: " + isCPF);

        boolean isCNPJ = ValidaCNPJ.isCNPJ("78.100.337/0001-68");


        System.out.println("CNPJ válido: "+ isCNPJ);


    }
}
