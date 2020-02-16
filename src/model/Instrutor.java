package model;

public class Instrutor extends Aluno {

    private int idInstrutor;
    private String nomeCompleto;
    private String email;
    private int valor_hora;
    private String login;
    private String senha;
    private String experiencia;


    // Construtores
    public Instrutor(){
        super(request.getParameter("nomeCompleto"), request.getParameter("login"), request.getParameter("email"), request.getParameter("senha"));

    }

    public Instrutor(int idInstrutor, String nomeCompleto, String email, int valor_hora, String login, String senha, String experiencia) {
        super(request.getParameter("nomeCompleto"), request.getParameter("login"), request.getParameter("email"), request.getParameter("senha"));
        this.idInstrutor = idInstrutor;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.valor_hora = valor_hora;
        this.login = login;
        this.senha = senha;
        this.experiencia = experiencia;
    }

    public Instrutor(String nomeCompleto, String email, int valor_hora, String login, String senha, String experiencia) {
        super(request.getParameter("nomeCompleto"), request.getParameter("login"), request.getParameter("email"), request.getParameter("senha"));
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.valor_hora = valor_hora;
        this.login = login;
        this.senha = senha;
        this.experiencia = experiencia;
    }

    // metodos get e set
    public int getIdInstrutor() {
        return idInstrutor;
    }

    public void setIdInstrutor(int idInstrutor) {
        this.idInstrutor = idInstrutor;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(int valor_hora) {
        this.valor_hora = valor_hora;
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

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

}


