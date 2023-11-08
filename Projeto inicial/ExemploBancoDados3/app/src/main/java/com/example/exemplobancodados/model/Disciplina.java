package com.example.exemplobancodados.model;

public class Disciplina {

    private int IIDDISCIPLINA;
    private String DESCRICAO;
    private  int PERIODO;
    private double CARGAHORARIA;
    private int IDPROFESSOR;

    public Disciplina(int IIDDISCIPLINA, String DESCRICAO, int PERIODO, double CARGAHORARIA, int IDPROFESSOR) {
        this.IIDDISCIPLINA = IIDDISCIPLINA;
        this.DESCRICAO = DESCRICAO;
        this.PERIODO = PERIODO;
        this.CARGAHORARIA = CARGAHORARIA;
        this.IDPROFESSOR = IDPROFESSOR;
    }
    public Disciplina(){

    }
    public int getIIDDISCIPLINA() {
        return IIDDISCIPLINA;
    }

    public void setIIDDISCIPLINA(int IIDDISCIPLINA) {
        this.IIDDISCIPLINA = IIDDISCIPLINA;
    }

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    public int getPERIODO() {
        return PERIODO;
    }

    public void setPERIODO(int PERIODO) {
        this.PERIODO = PERIODO;
    }

    public double getCARGAHORARIA() {
        return CARGAHORARIA;
    }

    public void setCARGAHORARIA(double CARGAHORARIA) {
        this.CARGAHORARIA = CARGAHORARIA;
    }

    public int getIDPROFESSOR() {
        return IDPROFESSOR;
    }

    public void setIDPROFESSOR(int IDPROFESSOR) {
        this.IDPROFESSOR = IDPROFESSOR;
    }
}
