package com.example.exemplobancodados.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDataHelper extends SQLiteOpenHelper {

    public SQLiteDataHelper(@Nullable Context context,
                            @Nullable String name,
                            @Nullable SQLiteDatabase.CursorFactory factory,
                            int version) {
        super(context, name, factory, version);
    }

    /***
     * Método é executado uma unica vez quando o aplicativo é instalado
     * é responsável por executar os scripts da criação das tabelas
     * @param sqLiteDatabase : base de dados que irá se criar as tabelas
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE ALUNO (RA INTEGER, NOME VARCHAR(100))");
        sqLiteDatabase.execSQL("CREATE TABLE PROFESSOR(  IDPROFESSOR INTEGER, MATRICULA INTEGER, NOME_PROF VARCHAR(100))");
        sqLiteDatabase.execSQL("CREATE TABLE DISCIPLINA(IDDISCIPLINA INTEGER, DESCRICAO VARCHAR(100), PERIODO INTEGER, CARGAHORARIA NUMERIC, IDPROFESSOR INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE TURMA( IDTURMA INTEGER, CURSO VARCHAR(100), ANOINICIO INTEGER, ANOFIM INTEGER)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
