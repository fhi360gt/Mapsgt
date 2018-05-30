package com.example.jlgarcia.mapsgt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jlgarcia.mapsgt.adapter.EscuelaArrayAdapter;
import com.example.jlgarcia.mapsgt.data.Escuela;
import com.example.jlgarcia.mapsgt.utilities.DBUtility;
import com.example.jlgarcia.mapsgt.utilities.ToolsFCN;

import java.util.List;

/**
 * Created by jlgarcia on 22/03/2018.
 */

public class Escuelas  extends AppCompatActivity implements  View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText et_codigo;
    private EditText et_escuela;
    private Button btn_guardar;
    private ListView lv_result;

    private DBUtility conn;
    private List<Escuela> escuelaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esculeas);
        conn = new DBUtility(this);
        et_codigo = (EditText) findViewById(R.id.et_codigo);
        et_escuela = (EditText) findViewById(R.id.et_escuela);
        btn_guardar = (Button) findViewById(R.id.btn_guardar);
        lv_result = (ListView) findViewById(R.id.lv_result);


        loadEscuelas();

        btn_guardar.setOnClickListener(this);
        lv_result.setOnItemClickListener(this);
    }

    private void loadEscuelas () {
        escuelaList = conn.getAllScuela();
        lv_result.setAdapter(new EscuelaArrayAdapter(getApplicationContext(), R.layout.row_school_list, escuelaList ));
    }

    private void getSchools(int i) {
        Escuela temp = new Escuela();
        temp.setCodigo(escuelaList.get(i).getCodigo());
        temp.setNombre(escuelaList.get(i).getNombre());
    }



    @Override
    public void onClick(View view) {
        Escuela esc = new Escuela();
        esc.setCodigo(et_codigo.getText().toString());
        esc.setNombre(et_escuela.getText().toString());
        if (!conn.validCode(et_codigo.getText().toString())) {
            conn.insertExcuela(esc);
            Toast.makeText(this, "Escuela guardada...!!!!", Toast.LENGTH_SHORT).show();
            et_codigo.setText("");
            et_escuela.setText("");
        } else {
            Toast.makeText(this, "Escuela existente...!!!!", Toast.LENGTH_SHORT).show();
        }
        loadEscuelas();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ToolsFCN.dialogAlertConfirm(this, getResources(), 1, Integer.parseInt(escuelaList.get(i).getCodigo()),conn);
    }
}
