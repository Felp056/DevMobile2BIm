package com.example.exemplobancodados.controller;

import android.content.Context;

import com.example.exemplobancodados.dao.ProfessorDao;
import com.example.exemplobancodados.dao.TurmaDao;
import com.example.exemplobancodados.model.Professor;
import com.example.exemplobancodados.model.Turma;

import java.util.ArrayList;

public class TurmaController {
    private Context context;

    public TurmaController(Context context) {
        this.context = context;
    }
//("CREATE TABLE TURMA( IDTURMA INTEGER, CURSO VARCHAR(100), ANOINICIO INTEGER, ANOFIM INTEGER)");
    public String salvarTurma(int IDTURMA, String CURSO, int ANOINICIO, int ANOFIM){
        try{
            if(IDTURMA == 0){
                return "O id da turma deve ser diferente de 0";
            }
            if(CURSO == "" || CURSO.isEmpty()){
                return "O curso não pode estar em branco";
            }
            if (ANOFIM == 0){
                return "O curso deve conter um ano de termino";
            }
            if(ANOINICIO == 0){
                return "O curso deve ter um ano de inicio";
            }

            Turma turma = TurmaDao.getInstancia(context).getById(IDTURMA);
            if(turma != null){
                return "A turma ("+ turma.getIDTURMA()+") já está cadastrada!";
            }else{
                turma = new Turma();
                turma.setIDTURMA(IDTURMA);
                turma.setCURSO(CURSO);
                turma.setANOINICIO(ANOINICIO);
                turma.setANOFIM(ANOFIM);

                TurmaDao.getInstancia(context).insert(turma);
            }

        }catch (Exception ex){
            return "Erro ao Gravar Turma.";
        }
        return null;
    }

    public ArrayList<Turma> retornarTodasTurmas()
    {
        return  TurmaDao.getInstancia(context).getAll();
    }
}
