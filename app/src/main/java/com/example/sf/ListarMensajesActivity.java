package com.example.sf;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListarMensajesActivity extends AppCompatActivity {

    Integer[] imagenes={
            R.drawable.logo_ripley,
            R.drawable.logo_saga,
            R.drawable.logo_hm,
            R.drawable.logo_paris
    };
    String[] nombres=new String[]{
            "Tienda Ripley","Tienda Saga","Tienda HM","Tienda Paris"
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
        getMenuInflater().inflate(R.menu.menu_listar_mensajes,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_buscar:
                Intent buscar = new Intent(this, BuscarProductoActivity.class);
                startActivity(buscar);
                return true;
            case R.id.menu_principal:
                Intent principal = new Intent(this, BuscarProductoActivity.class);
                startActivity(principal);
                return true;
            case R.id.menu_categorias:
                Intent categorias = new Intent(this, CategoriaActivity.class);
                startActivity(categorias);
                return true;
            case R.id.menu_perfil:
                Intent perfil = new Intent(this, PerfilActivity.class);
                startActivity(perfil);
                return true;
            case R.id.menu_salir:
                Intent salir = new Intent(this, LoginUsuarioActivity.class);
                startActivity(salir);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

