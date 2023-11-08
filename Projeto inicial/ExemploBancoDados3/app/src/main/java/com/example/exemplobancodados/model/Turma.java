package com.example.exemplobancodados.model;

public class Turma {
    private int IDTURMA;
    private String CURSO;
    private int ANOINICIO;
    private int ANOFIM;

    public Turma(int IDTURMA, String CURSO, int ANOINICIO, int ANOFIM) {
        this.IDTURMA = IDTURMA;
        this.CURSO = CURSO;
        this.ANOINICIO = ANOINICIO;
        this.ANOFIM = ANOFIM;
    }

    public Turma() {
    }

    public int getIDTURMA() {
        return IDTURMA;
    }

    public void setIDTURMA(int IDTURMA) {
        this.IDTURMA = IDTURMA;
    }

    public String getCURSO() {
        return CURSO;
    }

    public void setCURSO(String CURSO) {
        this.CURSO = CURSO;
    }

    public int getANOINICIO() {
        return ANOINICIO;
    }

    public void setANOINICIO(int ANOINICIO) {
        this.ANOINICIO = ANOINICIO;
    }

    public int getANOFIM() {
        return ANOFIM;
    }

    public void setANOFIM(int ANOFIM) {
        this.ANOFIM = ANOFIM;
    }
}
