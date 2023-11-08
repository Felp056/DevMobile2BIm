package com.example.exemplobancodados.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.exemplobancodados.helper.SQLiteDataHelper;
import com.example.exemplobancodados.model.Disciplina;
import com.example.exemplobancodados.model.Professor;

import java.util.ArrayList;

public class DisciplinaDao implements IGenericDao<Disciplina>{
    private SQLiteOpenHelper openHelper;

    //Base de Dados
    private SQLiteDatabase baseDados;

    //nome das colunas da tabela;
    private String[]colunas = {"IDDISCIPLINA", "DESCRICAO", "PERIODO", "CARGAHORARIA", "IDPROFESSOR"};

    //nome da tabela
    private String tabela = "DISCIPLINA";

    //Contexto (view)
    private Context context;

    private static DisciplinaDao instancia;

    public static DisciplinaDao getInstancia(Context context){
        if(instancia == null){
            return instancia = new DisciplinaDao(context);
        }else{
            return instancia;
        }
    }

    private DisciplinaDao(Context context){
        this.context = context;

        //Abrir a conexão com a base de dados
        openHelper = new SQLiteDataHelper(this.context,
                "UNIPAR_BD", null, 1);

        //instanciando a base de dados
        baseDados = openHelper.getWritableDatabase();


    }

    @Override
    public long insert(Disciplina obj) {
        try{
            // private String[]colunas = {"IDDISCIPLINA", "DESCRICAO", "PERIODO", "CARGAHORARIA", "IDPROFESSOR"};
            ContentValues valores = new ContentValues();
            valores.put(colunas[0], obj.getIIDDISCIPLINA());
            valores.put(colunas[1], obj.getDESCRICAO());
            valores.put(colunas[2], obj.getPERIODO());
            valores.put(colunas[3], obj.getCARGAHORARIA());
            valores.put(colunas[4], obj.getIDPROFESSOR());

            return baseDados.insert(tabela, null, valores);
        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: AlunoDao.insert() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public long update(Disciplina obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getDESCRICAO());
            valores.put(colunas[2], obj.getPERIODO());
            valores.put(colunas[3], obj.getCARGAHORARIA());
            valores.put(colunas[4], obj.getIDPROFESSOR());

            String[]identificador = {String.valueOf(obj.getIIDDISCIPLINA())};

            return baseDados.update(tabela,  valores,
                    colunas[0]+"= ?", identificador);

        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: AlunoDao.update() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public long delete(Disciplina obj) {
        try{
            String[]identificador = {String.valueOf(obj.getIIDDISCIPLINA())};

            return baseDados.delete(tabela,
                    colunas[0]+"= ?", identificador);
        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: ProfessorDao.delete() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<Disciplina> getAll() {
        ArrayList<Disciplina> lista = new ArrayList<>();
        try{
            Cursor cursor = baseDados.query(tabela,
                    colunas, null,
                    null, null,
                    null, colunas[0]+" desc");

            if(cursor.moveToFirst()){
                do{
                    Disciplina disc = new Disciplina();
                    disc.setIIDDISCIPLINA(cursor.getInt(0));
                    disc.setDESCRICAO(cursor.getString(1));
                    disc.setPERIODO(cursor.getInt(2));
                    disc.setCARGAHORARIA(cursor.getDouble(3));
                    disc.setIDPROFESSOR(cursor.getInt(4));

                    lista.add(disc);

                }while (cursor.moveToNext());
            }

        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: AlunoDao.getAll() "+ex.getMessage());
        }

        return lista;
    }

    @Override
    public Disciplina getById(int id) {
        try{
            String[]identificador = {String.valueOf(id)};
            Cursor cursor = baseDados.query(tabela, colunas,
                    colunas[0]+"= ?", identificador,
                    null, null, null);

            if(cursor.moveToFirst()){
                Disciplina disc = new Disciplina();
                disc.setIIDDISCIPLINA(cursor.getInt(0));
                disc.setDESCRICAO(cursor.getString(1));
                disc.setPERIODO(cursor.getInt(2));
                disc.setCARGAHORARIA(cursor.getDouble(3));
                disc.setIDPROFESSOR(cursor.getInt(4));

                return disc;
            }

        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: ProfessorDao.getById() "+ex.getMessage());
        }
        return null;
    }
}
