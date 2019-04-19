package com.example.sf;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class DetalleTiendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_tienda);
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void goToLisProTie(View view){
        Intent intent = new Intent(this, ListarProductosTiendaActivity.class);
        startActivity(intent);
    }

    public void goToChatTie(View view){
        //AlertDialog.Builder ayuda = new AlertDialog.Builder(this);
        //ayuda.setMessage("Por el momento, el chat no esta disponible.").show();
        Toast.makeText(DetalleTiendaActivity.this,
                "Por el momento, el chat no esta disponible.", Toast.LENGTH_LONG).show();
    }
    public void mensaje (View view)
    {
        Intent mensaje = new Intent(this, ListarMensajesActivity.class);
        startActivity(mensaje);
    }
    public void producto (View view)
    {
        Intent producto = new Intent(this, BuscarProductoActivity.class);
        startActivity(producto);
    }
}
