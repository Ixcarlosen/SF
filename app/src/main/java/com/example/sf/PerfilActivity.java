package com.example.sf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {
    TextView emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        //recibirDatos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_perfil,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_buscar:
                Intent buscar = new Intent(this, BuscarProductoActivity.class);
                startActivity(buscar);
                return true;
            case R.id.menu_atras:
                this.finish();
                return true;
            case R.id.menu_lmensajes:
                Intent mensajes = new Intent(this, ListarMensajesActivity.class);
                startActivity(mensajes);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

/*public void recibirDatos()
{
    Bundle extras=getIntent().getExtras();
    String email= extras.getString("email");
    String d1=email;

    emailText=(TextView) findViewById(R.id.emailText);
    emailText.setText(email);
}*/

    public void actualizar(View view) {

    }

    public void eliminar(View view) {

    }
}
