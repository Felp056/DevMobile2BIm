package com.example.exemplobancodados.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.exemplobancodados.helper.SQLiteDataHelper;
import com.example.exemplobancodados.model.Aluno;
import com.example.exemplobancodados.model.Professor;

import java.util.ArrayList;

public class ProfessorDao implements IGenericDao<Professor>{

    private SQLiteOpenHelper openHelper;

    //Base de Dados
    private SQLiteDatabase baseDados;

    //nome das colunas da tabela;
    private String[]colunas = {"IDPROFESSOR", "MATRICULA", "NOME_PROF"};

    //nome da tabela
    private String tabela = "PROFESSOR";

    //Contexto (view)
    private Context context;

    private static ProfessorDao instancia;

    public static ProfessorDao getInstancia(Context context){
        if(instancia == null){
            return instancia = new ProfessorDao(context);
        }else{
            return instancia;
        }
    }

    private ProfessorDao(Context context){
        this.context = context;

        //Abrir a conexão com a base de dados
        openHelper = new SQLiteDataHelper(this.context,
                "UNIPAR_BD", null, 1);

        //instanciando a base de dados
        baseDados = openHelper.getWritableDatabase();


    }

    @Override
    public long insert(Professor obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[0], obj.getIDprofessor()); //Id
            valores.put(colunas[1], obj.getMatricula()); //Matricula
            valores.put(colunas[2], obj.getNome_Prof()); //Nome

            return baseDados.insert(tabela, null, valores);

//            return baseDados.execSQL("INSERT INTO ALUNO (RA, NOME) VALUES " +
//                    "("+obj.getRa()+", "+obj.getNome()+" )");

        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: AlunoDao.insert() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public long update(Professor obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[2], obj.getNome_Prof());

            String[]identificador = {String.valueOf(obj.getIDprofessor())};

            return baseDados.update(tabela,  valores,
                    colunas[0]+"= ?", identificador);

        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: AlunoDao.update() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public long delete(Professor obj) {
        try{
            String[]identificador = {String.valueOf(obj.getIDprofessor())};

            return baseDados.delete(tabela,
                    colunas[0]+"= ?", identificador);
        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: ProfessorDao.delete() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<Professor> getAll() {
        ArrayList<Professor> lista = new ArrayList<>();
        try{
            Cursor cursor = baseDados.query(tabela,
                    colunas, null,
                    null, null,
                    null, colunas[0]+" desc");

            if(cursor.moveToFirst()){
                do{
                    Professor prof = new Professor();
                    prof.setIDprofessor(cursor.getInt(0));
                    prof.setMatricula(cursor.getInt(1));
                    prof.setNome_Prof(cursor.getString(2));

                    lista.add(prof);

                }while (cursor.moveToNext());
            }

        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: AlunoDao.getAll() "+ex.getMessage());
        }

        return lista;
    }

    @Override
    public Professor getById(int id) {
        try{
            String[]identificador = {String.valueOf(id)};
            Cursor cursor = baseDados.query(tabela, colunas,
                    colunas[0]+"= ?", identificador,
                    null, null, null);

            if(cursor.moveToFirst()){
                Professor prof = new Professor();
                prof.setIDprofessor(cursor.getInt(0));
                prof.setMatricula(cursor.getInt(1));
                prof.setNome_Prof(cursor.getString(2));

                return prof;
            }

        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: ProfessorDao.getById() "+ex.getMessage());
        }
        return null;
    }
}
