package model;

public class Comentario {

    private int idComentario;
    private String texto;
    private long dataComentario;
    private Aluno autor;

    //Construtores
    public Comentario() {
        super();
    }

    public Comentario(int idComentario, String texto, long dataComentario, Aluno autor) {
        this.idComentario = idComentario;
        this.texto = texto;
        this.dataComentario = dataComentario;
        this.autor = autor;
    }

    public Comentario(String texto, long dataComentario, Aluno autor) {
        this.texto = texto;
        this.dataComentario = dataComentario;
        this.autor = autor;
    }

    // metodos get e set para IdComentario, Texto, DataComentario e Autor.

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public long getDataComentario() {
        return dataComentario;
    }

    public void setDataComentario(long dataComentario) {
        this.dataComentario = dataComentario;
    }

    public Aluno getAutor() {
        return autor;
    }

    public void setAutor(Aluno autor) {
        this.autor = autor;
    }


}



