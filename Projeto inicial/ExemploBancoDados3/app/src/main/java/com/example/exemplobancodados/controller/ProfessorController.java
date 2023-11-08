package com.example.exemplobancodados.controller;

import android.content.Context;

import com.example.exemplobancodados.dao.AlunoDao;
import com.example.exemplobancodados.dao.ProfessorDao;
import com.example.exemplobancodados.model.Aluno;
import com.example.exemplobancodados.model.Professor;

import java.util.ArrayList;

public class ProfessorController {
    private Context context;

    public ProfessorController(Context context) {
        this.context = context;
    }

    public String salvarProfessor(String Nome_Prof, int Matricula, int IDprofessor){
        try{
            if(Nome_Prof.equals("") || Nome_Prof.isEmpty()){
                return "Informe o nome do Professor!";
            }
           if(Matricula == 0){
               return "A Matricula do professor não pode ser 0";
           }

            Professor prof = ProfessorDao.getInstancia(context).getById(IDprofessor);
            if(prof != null){
                return "A matricula ("+ prof.getMatricula()+") já está cadastrada!";
            }else{
                prof = new Professor();
                prof.setIDprofessor(IDprofessor);
                prof.setNome_Prof(Nome_Prof);
                prof.setMatricula(Matricula);

                ProfessorDao.getInstancia(context).insert(prof);
            }

        }catch (Exception ex){
            return "Erro ao Gravar Aluno.";
        }
        return null;
    }

    public ArrayList<Professor> retornarTodosOsProfessores()
    {
        return  ProfessorDao.getInstancia(context).getAll();
    }
}
