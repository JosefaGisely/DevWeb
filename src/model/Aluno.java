package model;

public class Aluno {

    private int idAluno;
    private int cpf;
    private String nomeCompleto;
    private String email;
    private int celular;
    private String login;
    private String senha;
    private String endereco;
    private String cidade;
    private String bairro;
    private int cep;
    private String comentario;
    private String aprovado;

    // Construtores
    public Aluno() {}


    public Aluno(int cpf, String nomeCompleto, String email, int celular, String login, String senha,
                 String endereco, String cidade, String bairro, int cep, String comentario, String aprovado){

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

    public Aluno(int idAluno, int cpf, String nomeCompleto, String email, int celular, String login, String senha,
                 String endereco, String cidade, String bairro, int cep, String comentario, String aprovado) {
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

    public Aluno(String nomeCompleto, String apelido, String email, String senha) {

    }

    // metodos get e set para IdAluno, NomeCompleto, CPF, Email, Celular, Login, Senha, Endereco,
    // Cidade, Bairro, Cep, Comentario e aprovado.


    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int ididAluno) {
        this.idAluno = ididAluno;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
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

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
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

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
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
}