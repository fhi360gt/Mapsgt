package com.example.jlgarcia.mapsgt.utilities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jlgarcia.mapsgt.data.Escuela;

import java.util.List;

/**
 * Created by jlgarcia on 23/03/2018.
 */

public class DBUtility {
    public static final String DBNAME = "esuela";
    public static final int DBVER = 1;

    private Context context;
    private EscuelasSQL conn;

    public DBUtility(Context context) {
        this.context = context;
        this.conn = new EscuelasSQL(context);
    }
    public void insertExcuela (Escuela dato) {
        String sql = "INSERT INTO escuela (codigo, nombre) VALUES( '" + dato.getCodigo() + "','" + dato.getNombre()+"')";
        SQLiteDatabase db = conn.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    public List<Escuela> getAllScuela() {
        List<Escuela> list;
        String query = "SELECT codigo, nombre FROM escuela";
        SQLiteDatabase db = conn.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);
        list = Escuela.getListFromCursor(c);
        c.close();
        db.close();
        return list;
    }
    public boolean validCode (String str) {
        boolean strValue=false;
        String query = "SELECT count(*) FROM escuela WHERE codigo=" + str;
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        if (!(c.getString(0)).equals("0")) {
            strValue=true;
        }
        c.close();
        db.close();
        return strValue;
    }

    public void deleteRecord(String string) {
        SQLiteDatabase db = conn.getWritableDatabase();
        db.delete("escuela",string,null);
        db.close();
    }
}
