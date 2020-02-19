package model;

import java.util.Date;

public class Matricula {
    private int idMatricula;
    private int turmaId;
    private int alunoId;
    private Date date;
    private double nota;

    public Matricula(int id) {
        this.idMatricula = id;
    }

    public Matricula(int idMatricula, int turmaId, int alunoId, Date date, double nota) {
        this.idMatricula = idMatricula;
        this.turmaId = turmaId;
        this.alunoId = alunoId;
        this.date = date;
        this.nota = nota;
    }

    public int getId() {
        return idMatricula;
    }

    public void setId(int id) {
        this.idMatricula = id;
    }

    public int getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(int turmaId) {
        this.turmaId = turmaId;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
