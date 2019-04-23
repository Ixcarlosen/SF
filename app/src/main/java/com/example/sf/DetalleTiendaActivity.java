package com.example.sf;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleTiendaActivity extends AppCompatActivity {
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_tienda);

        TextView txtNombre = findViewById(R.id.txtNombre);
        TextView txtDescripcion = findViewById(R.id.txtDescripcion);
        TextView txtTelefono = findViewById(R.id.txtTelefono);
        imagen =findViewById(R.id.imagen);

        Bundle bundle = getIntent().getExtras();

        txtNombre.setText(bundle.getString("titulo"));
        txtDescripcion.setText(bundle.getString("descripcion"));
        txtTelefono.setText(bundle.getString("telefono"));
        String id = bundle.getString("id");

        if (id.equals("1.0")){
            imagen.setImageResource(R.drawable.logo_ripley);
        }
        else if (id.equals("2.0"))
        {
            imagen.setImageResource(R.drawable.logo_saga);
        }
        else if (id.equals("3.0"))
        {
            imagen.setImageResource(R.drawable.logo_paris);
        }
        else if (id.equals("4.0"))
        {
            imagen.setImageResource(R.drawable.logo_hm);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalle_tienda,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_buscar:
                Intent buscar = new Intent(this, BuscarProductoActivity.class);
                startActivity(buscar);
                return true;
            case R.id.menu_llamar:
                Toast.makeText(this,
                        "Por el momento, llamar no esta disponible", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_mapa:
                Intent mapa = new Intent(this, MapaBasicoActivity.class);
                startActivity(mapa);
                return true;
            case R.id.menu_salir:
                Intent salir = new Intent(this, LoginUsuarioActivity.class);
                startActivity(salir);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void mensaje (View view)
    {
        Intent mensaje = new Intent(this, MensajeActivity.class);
        startActivity(mensaje);
    }
    public void producto (View view)
    {
        Intent producto = new Intent(this, ListarProductosTiendaActivity.class);
        startActivity(producto);
    }
}
