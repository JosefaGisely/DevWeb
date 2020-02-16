package model;

import java.util.Date;

public class Turmas {

    private int idTurmas;
    private String idInstrutores;
    private String idCursos;
    private Date data_inicial;
    private Date data_final;
    private Date carga_horaria;

    // Construtores
    public Turmas(){
        super();

    }

    public Turmas(int idTurmas, String idInstrutores, String idCursos, Date data_inicial, Date data_final, Date carga_horaria) {
        this.idTurmas = idTurmas;
        this.idInstrutores = idInstrutores;
        this.idCursos = idCursos;
        this.data_inicial = data_inicial;
        this.data_final = data_final;
        this.carga_horaria = carga_horaria;
    }

    public Turmas(String idInstrutores, String idCursos, Date data_inicial, Date data_final, Date carga_horaria) {
        this.idInstrutores = idInstrutores;
        this.idCursos = idCursos;
        this.data_inicial = data_inicial;
        this.data_final = data_final;
        this.carga_horaria = carga_horaria;
    }

    // metodos get e set
    public int getIdTurmas() {
        return idTurmas;
    }

    public void setIdTurmas(int idTurmas) {
        this.idTurmas = idTurmas;
    }

    public String getIdInstrutores() {
        return idInstrutores;
    }

    public void setIdInstrutores(String idInstrutores) {
        this.idInstrutores = idInstrutores;
    }

    public String getIdCursos() {
        return idCursos;
    }

    public void setIdCursos(String idCursos) {
        this.idCursos = idCursos;
    }

    public Date getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(Date data_inicial) {
        this.data_inicial = data_inicial;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }

    public Date getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(Date carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

}
