package com.example.fisicaapp.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DAO extends SQLiteOpenHelper{

    public DAO(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE dados_spinner_conversor(dados TEXT);";
        db.execSQL(sql);

        String[] dados_para_inserir = {"Tempo",
                "Velocidade", "Temperatura",
                "Comprimento"};

        for(int i=0; i<dados_para_inserir.length; i++){
            ContentValues dados = new ContentValues();
            dados.put("dados", dados_para_inserir[i]);
            db.insert("dados_spinner_conversor",null,dados);

        }


    }

    @SuppressLint("Range")
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {


    }

    @SuppressLint("Range")
    public ArrayList<String> buscaDadosSpinnerConversor(){
        SQLiteDatabase db = getReadableDatabase();
        String sql_busca_dados_spinner_conversor = "SELECT * FROM dados_spinner_conversor;";
        ArrayList<String> dados_spinner_conversor = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql_busca_dados_spinner_conversor,null);
        while (cursor.moveToNext()){
            dados_spinner_conversor.add(cursor.getString(cursor.getColumnIndex("dados")));

        }
        return dados_spinner_conversor;
    }
}
