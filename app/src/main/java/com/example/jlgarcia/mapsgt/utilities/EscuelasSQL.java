package com.example.jlgarcia.mapsgt.utilities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jlgarcia on 22/03/2018.
 */

public class EscuelasSQL  extends SQLiteOpenHelper{

    private String createEscuelas ="CREATE TABLE escuela(codigo TEXT, nombre TEXT)";

    public EscuelasSQL(Context context) {
        super(context, DBUtility.DBNAME, null, DBUtility.DBVER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( createEscuelas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
