package com.example.jlgarcia.mapsgt.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jlgarcia.mapsgt.R;
import com.example.jlgarcia.mapsgt.data.Escuela;

import java.util.List;

/**
 * Created by jlgarcia on 23/03/2018.
 */

public class EscuelaArrayAdapter extends ArrayAdapter<Escuela>{

    private Context context;
    private int layout;
    private List<Escuela> list;

    public EscuelaArrayAdapter(@NonNull Context context, int resource, @NonNull List<Escuela> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(layout,null);
        }
        if (list.get(position) != null) {
            TextView tv_codigo, tv_nombre;
            LinearLayout ly = (LinearLayout) v.findViewById(R.id.layout);

            tv_codigo = (TextView) v.findViewById(R.id.textView1);
            tv_nombre = (TextView) v.findViewById(R.id.textView2);

            tv_codigo.setText(list.get(position).getCodigo()+"");
            tv_nombre.setText(list.get(position).getNombre()+"");

            if (position % 2 == 0) {
                ly.setBackgroundColor(context.getResources().getColor(android.R.color.white));
            } else {
                ly.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));
            }
        }

        return v;
    }
}
