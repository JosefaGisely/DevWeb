package model;

public class Administrador {
    private int idAdministrador;
    private String nomeCompleto;
    private String login;
    private String senha;

    // Construtores
    public Administrador(){
        super();
    }

    public Administrador(int idAdministrador, String nomeCompleto, String login, String senha) {
        this.idAdministrador = idAdministrador;
        this.nomeCompleto = nomeCompleto;
        this.login = login;
        this.senha = senha;
    }

    public Administrador(String nomeCompleto, String login, String senha) {
        this.nomeCompleto = nomeCompleto;
        this.login = login;
        this.senha = senha;
    }

    // metodos get e set para IdAdministrador, NomeCompleto, Login, Senha
    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
