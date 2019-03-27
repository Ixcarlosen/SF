package com.example.sf;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuscarProductoMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_producto_m);

        EditText campoBusqueda = (EditText) findViewById(R.id.txvBuscarM);

        campoBusqueda.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean procesado = false;

                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // Mostrar mensaje
                    Toast.makeText(BuscarProductoMActivity.this,
                            "Buscando " + v.getText().toString()+" ...", Toast.LENGTH_LONG).show();

                    // Ocultar teclado virtual
                    InputMethodManager imm =
                            (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    procesado = true;
                }
                return procesado;
            }
        });
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


            case R.id.menu_buscar:
                Intent intenttt = new Intent(this, BuscarProductoMActivity.class);
                startActivity(intenttt);


            case R.id.menu_notificacion:
                Intent intenttttt = new Intent(this, ListarMensajesActivity.class);
                startActivity(intenttttt);

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

    public void goToCamara(View view){
        //AlertDialog.Builder ayuda = new AlertDialog.Builder(this);
        //ayuda.setMessage("Por el momento, la cámara no esta disponible.").show();
        Toast.makeText(BuscarProductoMActivity.this,
                "Por el momento, la cámara no esta disponible.", Toast.LENGTH_LONG).show();
    }
}
