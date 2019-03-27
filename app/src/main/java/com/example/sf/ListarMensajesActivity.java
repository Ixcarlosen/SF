package com.example.sf;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ListarMensajesActivity extends AppCompatActivity {

    Integer[] imagenes={
            R.drawable.camerica,
            R.drawable.superman,
            R.drawable.gatubela,
            R.drawable.iroman
    };
    String[] nombres=new String[]{
            "Capitan America","Superman","Gatubela","Ironman"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_mensajes);

        ListView lv = (ListView)findViewById(R.id.lstMensajes);
        imagenNombre adapter = new imagenNombre(this,nombres,imagenes);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListarMensajesActivity.this,
                        "Por el momento, el detalle del mensaje no esta disponible", Toast.LENGTH_LONG).show();

            }
        });


        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.principal,menu);
        return true;
    }
}

