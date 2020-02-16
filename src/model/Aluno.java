package model;

public class Aluno {

    private int idAluno;
    private String cpf;
    private String nomeCompleto;
    private String email;
    private String celular;
    private String login;
    private String senha;
    private String endereco;
    private String cidade;
    private String bairro;
    private String cep;
    private String comentario;
    private String aprovado;

    // Construtores
    public Aluno(int idAluno, String cpf, String nomeCompleto, String email, String celular, String login, String senha, String endereco, String cidade, String bairro, String cep){
        super();

    }

    public Aluno(int idAluno, String cpf, String nomeCompleto, String email, String celular, String login, String senha, String endereco, String cidade, String bairro, String cep, String comentario, String aprovado) {
        this.idAluno = idAluno;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.celular = celular;
        this.login = login;
        this.senha = senha;
        this.endereco = endereco;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.comentario = comentario;
        this.aprovado = aprovado;
    }

    public Aluno(String nomeCompleto, String login, String email, String senha) {
        this.cpf = cpf;
        this.nomeCompleto = this.nomeCompleto;
        this.email = this.email;
        this.celular = celular;
        this.login = this.login;
        this.senha = this.senha;
        this.endereco = endereco;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.comentario = comentario;
        this.aprovado = aprovado;
    }

    public Aluno() {

    }

    // metodos get e set
    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getAprovado() {
        return aprovado;
    }

    public void setAprovado(String aprovado) {
        this.aprovado = aprovado;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "idAluno=" + idAluno +
                ", cpf='" + cpf + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", comentario='" + comentario + '\'' +
                ", aprovado='" + aprovado + '\'' +
                '}';
    }
}