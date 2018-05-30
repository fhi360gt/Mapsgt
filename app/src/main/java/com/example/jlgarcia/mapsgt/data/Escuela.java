package com.example.jlgarcia.mapsgt.data;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jlgarcia on 23/03/2018.
 */

public class Escuela {
    private String codigo;
    private String nombre;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static List<Escuela> getListFromCursor(Cursor c) {
        List<Escuela> list = new ArrayList<Escuela>();
        Escuela temp = new Escuela();
        if (c.moveToFirst()) {
            do{
                temp = new Escuela();
                temp.setCodigo( c.getString(0));
                temp.setNombre(c.getString(1));
                list.add(temp);
            }while (c.moveToNext());
        }
        return list;
    }

}
