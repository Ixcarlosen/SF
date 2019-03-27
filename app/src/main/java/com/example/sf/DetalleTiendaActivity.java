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
        getMenuInflater().inflate(R.menu.principal,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_home:
                Intent inte = new Intent(this, MenuActivity.class);
                startActivity(inte);
                return true;
            case R.id.menu_tienda:
                Intent intent = new Intent(this, TiendaActivity.class);
                startActivity(intent);

            case R.id.menu_producto:
                Intent intentt = new Intent(this, ListarProductosTiendaActivity.class);
                startActivity(intentt);

            case R.id.menu_foto:
                android.support.v7.app.AlertDialog.Builder foto = new android.support.v7.app.AlertDialog.Builder(this);
                foto.setMessage("La cámara no está disponible").show();

            case R.id.menu_buscar:
                Intent intenttt = new Intent(this, BuscarProductoMActivity.class);
                startActivity(intenttt);


            case R.id.menu_mapa:
                android.support.v7.app.AlertDialog.Builder mapa = new android.support.v7.app.AlertDialog.Builder(this);
                mapa.setMessage("Mapa no disponible").show();
                return true;

            case R.id.menu_contactanos:
                android.support.v7.app.AlertDialog.Builder contacto = new AlertDialog.Builder(this);
                contacto.setMessage("Contáctanos no disponible").show();
                return true;

            case R.id.menu_salir:
                Intent intentttt = new Intent(this, LoginUsuarioActivity.class);
                startActivity(intentttt);
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
}
