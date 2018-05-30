package com.example.jlgarcia.mapsgt.utilities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.widget.Toast;

import com.example.jlgarcia.mapsgt.R;

public class ToolsFCN {

    // *********** Control Alerts ************************
    public static void dialogAlertConfirm(final Context contexto, Resources resources, int v, final int codigo,final
     DBUtility conn){
        final int msj_alert=v;
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(contexto);
        dialogo1.setTitle(resources.getString(R.string.str_important));
        if (v == 1){dialogo1.setMessage(resources.getString(R.string.str_delete_record)+ " " + String.valueOf(codigo)+"?");}

        //dialogo1.setCancelable(false);

        dialogo1.setPositiveButton(resources.getString(R.string.str_ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                if (msj_alert==1) {conn.deleteRecord(String.valueOf(codigo));}
                if (msj_alert==2) {Toast.makeText(contexto, "Hace otra cosa", Toast.LENGTH_SHORT).show();}

            }
        });
        //if (v == 11) {
            dialogo1.setNegativeButton(resources.getString(R.string.str_cancel), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    cancel();
                }
            });
        //}


        dialogo1.show();
    }

    private static void cancel() {
    }

    private static void confirm() {
    }
}
