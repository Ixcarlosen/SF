package com.example.sf;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
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
                            "Buscando " + v.getText().toString(), Toast.LENGTH_LONG).show();

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

    public void goToCamara(View view){
        AlertDialog.Builder ayuda = new AlertDialog.Builder(this);
        ayuda.setMessage("Por el momento, la cámara no esta disponible.").show();
    }
}
