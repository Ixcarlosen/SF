package com.example.sf;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DetalleTiendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_tienda);
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
