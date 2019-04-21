package com.example.sf;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class DetalleProductoActivity extends AppCompatActivity {
    private static final String TAG= "GalleryActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalle_producto,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_buscar:
                Intent buscar = new Intent(this, BuscarProductoActivity.class);
                startActivity(buscar);
                return true;
            case R.id.menu_irtienda:
                Intent tienda = new Intent(this, DetalleTiendaActivity.class);
                startActivity(tienda);
                return true;
            case R.id.menu_llamar:
                Toast.makeText(this,
                        "Por el momento, llamar no esta disponible", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void goToLisProTie(View view){
        Intent intent = new Intent(this, ListarProductosTiendaActivity.class);
        startActivity(intent);
    }

    public void pedir(View view) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(DetalleProductoActivity.this);
        alerta.setMessage("¿Desea pedir este producto?")
                .setCancelable(false)

                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Se agrego producto", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog titulo = alerta.create();
        titulo.setTitle("Agregar pedido");
        titulo.show();
    }

    public void mensaje (View view) {
        Intent mensaje = new Intent(this, MensajeActivity.class);
        startActivity(mensaje);
    }
}



