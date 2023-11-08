package com.example.exemplobancodados.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.exemplobancodados.helper.SQLiteDataHelper;
import com.example.exemplobancodados.model.Professor;
import com.example.exemplobancodados.model.Turma;

import java.util.ArrayList;

public class TurmaDao implements IGenericDao<Turma>{

    private SQLiteOpenHelper openHelper;

    //Base de Dados
    private SQLiteDatabase baseDados;

    //nome das colunas da tabela;
    private String[]colunas = {"IDTURMA", "CURSO", "ANOINICIO", "ANOFIM"};

    //nome da tabela
    private String tabela = "TURMA";

    //Contexto (view)
    private Context context;

    private static TurmaDao instancia;

    public static TurmaDao getInstancia(Context context){
        if(instancia == null){
            return instancia = new TurmaDao(context);
        }else{
            return instancia;
        }
    }

    private TurmaDao(Context context){
        this.context = context;

        //Abrir a conexão com a base de dados
        openHelper = new SQLiteDataHelper(this.context,
                "UNIPAR_BD", null, 1);

        //instanciando a base de dados
        baseDados = openHelper.getWritableDatabase();


    }

    @Override
    public long insert(Turma obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[0], obj.getIDTURMA());
            valores.put(colunas[1], obj.getCURSO());
            valores.put(colunas[2], obj.getANOINICIO());
            valores.put(colunas[3], obj.getANOFIM());

            return baseDados.insert(tabela, null, valores);

//            return baseDados.execSQL("INSERT INTO ALUNO (RA, NOME) VALUES " +
//                    "("+obj.getRa()+", "+obj.getNome()+" )");

        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: TurmaDao.insert() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public long update(Turma obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getCURSO());
            valores.put(colunas[2], obj.getANOINICIO());
            valores.put(colunas[3], obj.getANOFIM());

            String[]identificador = {String.valueOf(obj.getIDTURMA())};

            return baseDados.update(tabela,  valores,
                    colunas[0]+"= ?", identificador);

        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: AlunoDao.update() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public long delete(Turma obj) {
        try{
            String[]identificador = {String.valueOf(obj.getIDTURMA())};

            return baseDados.delete(tabela,
                    colunas[0]+"= ?", identificador);
        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: ProfessorDao.delete() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<Turma> getAll() {
        ArrayList<Turma> lista = new ArrayList<>();
        try{
            Cursor cursor = baseDados.query(tabela,
                    colunas, null,
                    null, null,
                    null, colunas[0]+" desc");

            if(cursor.moveToFirst()){
                do{
                    Turma turma = new Turma();
                    turma.setIDTURMA(cursor.getInt(0));
                    turma.setCURSO(cursor.getString(1));
                    turma.setANOINICIO(cursor.getInt(2));
                    turma.setANOFIM(cursor.getInt(3));

                    lista.add(turma);

                }while (cursor.moveToNext());
            }

        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: AlunoDao.getAll() "+ex.getMessage());
        }

        return lista;
    }

    @Override
    public Turma getById(int id) {
        try{
            String[]identificador = {String.valueOf(id)};
            Cursor cursor = baseDados.query(tabela, colunas,
                    colunas[0]+"= ?", identificador,
                    null, null, null);

            if(cursor.moveToFirst()){
                Turma turma = new Turma();
                turma.setIDTURMA(cursor.getInt(0));
                turma.setCURSO(cursor.getString(1));
                turma.setANOINICIO(cursor.getInt(2));
                turma.setANOFIM(cursor.getInt(3));

                return turma;
            }

        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: ProfessorDao.getById() "+ex.getMessage());
        }
        return null;
    }
}
