package com.example.sf;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_buscar_producto,menu);
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
                Intent intent = new Intent(this, ListarTiendaActivity.class);
                startActivity(intent);
                return true;

            case R.id.menu_producto:
                Intent intentt = new Intent(this, ListarProductosTiendaActivity.class);
                startActivity(intentt);
                return true;


            case R.id.menu_buscar:
                Intent intenttt = new Intent(this, BuscarProductoActivity.class);
                startActivity(intenttt);
                return true;


            case R.id.menu_notificacion:
                Intent intenttttt = new Intent(this, ListarMensajesActivity.class);
                startActivity(intenttttt);
                return true;

            case R.id.menu_foto:
                AlertDialog.Builder contacto = new AlertDialog.Builder(this);
                contacto.setMessage("Cámara no disponible").show();
                return true;

            case R.id.menu_salir:
                Intent intentttt = new Intent(this, LoginUsuarioActivity.class);
                startActivity(intentttt);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

    public void tienda(View view){
        Intent intent = new Intent(this, ListarTiendaActivity.class);
        startActivity(intent);
    }

    public void categoria(View view){
        Intent intenttt = new Intent(this, CategoriaActivity.class);
        startActivity(intenttt);
    }

    public void producto(View view){
        Intent intentt = new Intent(this,ListarProductosTiendaActivity.class);
        startActivity(intentt);
    }

    public void camara(View view){
        AlertDialog.Builder perfil = new AlertDialog.Builder(this);
        perfil.setMessage("La cámara no está disponible").show();
    }
}
