package model;

import java.util.Date;

public class Cursos {
    private int idCursos;
    private String nomeCompleto;;
    private String requisito;
    private String ementa;
    private Date carga_horaria;
    private double preco;

    // Construtores
    public Cursos(){
    }

    public Cursos(int idCursos, String nomeCompleto, String requisito, String ementa, Date carga_horaria, double preco) {
        this.idCursos = idCursos;
        this.nomeCompleto = nomeCompleto;
        this.requisito = requisito;
        this.ementa = ementa;
        this.carga_horaria = carga_horaria;
        this.preco = preco;
    }


    // metodos get e set

    public int getIdCursos() {
        return idCursos;
    }

    public void setIdCursos(int idCursos) {
        this.idCursos = idCursos;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public Date getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(Date carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
