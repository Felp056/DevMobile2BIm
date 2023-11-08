package com.example.exemplobancodados.controller;

import android.content.Context;

import com.example.exemplobancodados.dao.AlunoDao;
import com.example.exemplobancodados.dao.DisciplinaDao;
import com.example.exemplobancodados.dao.ProfessorDao;
import com.example.exemplobancodados.model.Aluno;
import com.example.exemplobancodados.model.Disciplina;
import com.example.exemplobancodados.model.Professor;

import java.util.ArrayList;

public class DisciplinaControler {
    private Context context;

    public DisciplinaControler(Context context) {
        this.context = context;
    }
    public String salvarDisciplina(int IDDISCIPLINA, String DESCRICAO, int PERIODO, double CARGAHORARIA, int IDPROFESSOR){
        try{
           if(IDDISCIPLINA == 0){
               return "Id da disciplina não pode ser 0!";
           }
           if (DESCRICAO == "" || DESCRICAO.isEmpty()){
               return "Não é permitido deixar a descrição vazia";
           }
           if(PERIODO == 0){
               return "Não existe periodo 0";
           }
            if(CARGAHORARIA == 0){
                return "A carga horaria não pode ser 0";
            }
            if (IDPROFESSOR == 0) {
                return "Deve ter algum professor viculado a matéria diferente de 0";
            }
            Disciplina disc = DisciplinaDao.getInstancia(context).getById(IDDISCIPLINA);
            if(disc != null){
                return "A disciplina ("+ disc.getIIDDISCIPLINA()+") já está cadastrada!";
            }else{
                disc = new Disciplina();
                disc.setIIDDISCIPLINA(IDDISCIPLINA);
                disc.setPERIODO(PERIODO);
                disc.setIDPROFESSOR(IDPROFESSOR);
                disc.setDESCRICAO(DESCRICAO);
                disc.setCARGAHORARIA(CARGAHORARIA);

                DisciplinaDao.getInstancia(context).insert(disc);
            }

        }catch (Exception ex){
            return "Erro ao Gravar Aluno.";
        }
        return null;
    }

    public ArrayList<Disciplina> retornarTodasAsDisciplinas()
    {
        return  DisciplinaDao.getInstancia(context).getAll();
    }
}
