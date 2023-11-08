package com.example.exemplobancodados.model;

public class Professor {
    private int IDprofessor;
    private  int Matricula;
    private String Nome_Prof;
    public Professor(int IDprofessor, int matricula, String nome_Prof) {
        this.IDprofessor = IDprofessor;
        Matricula = matricula;
        Nome_Prof = nome_Prof;
    }
    public Professor(){

    }

    public int getIDprofessor() {
        return IDprofessor;
    }

    public void setIDprofessor(int IDprofessor) {
        this.IDprofessor = IDprofessor;
    }

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int matricula) {
        Matricula = matricula;
    }

    public String getNome_Prof() {
        return Nome_Prof;
    }

    public void setNome_Prof(String nome_Prof) {
        Nome_Prof = nome_Prof;
    }
}
