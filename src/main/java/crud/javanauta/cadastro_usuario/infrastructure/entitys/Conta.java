package crud.javanauta.cadastro_usuario.infrastructure.entitys;



public interface Conta {

    public String getAgencia();

    public String getConta();

    public default String getBeneficios(){

        return "Eu sou a interface da Conta";
    }


}
