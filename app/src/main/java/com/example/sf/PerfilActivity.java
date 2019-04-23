package com.example.sf;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends AppCompatActivity {
    int idObtenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        //recibirDatos();

        SharedPreferences prefs = getSharedPreferences("PERFIL", Context.MODE_PRIVATE);
        idObtenido = prefs.getInt("ID", 0);
        String nombre = prefs.getString("NOMBRE", "");
        String apellido = prefs.getString("APELLIDO", "");
        String email = prefs.getString("EMAIL", "");
        TextView tv1 = (TextView)findViewById(R.id.txtNombre);
        TextView tv2 = (TextView)findViewById(R.id.txtApellido);
        TextView tv3 = (TextView)findViewById(R.id.emailText);
        tv1.setText(nombre);
        tv2.setText(apellido);
        tv3.setText(email);
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
                Intent atras = new Intent(this, BuscarProductoActivity.class);
                startActivity(atras);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void actualizar(View view) {
        Intent actu = new Intent(this, ActualizarUsuarioActivity.class);
        startActivity(actu);
    }

    public void eliminar(View view) {
        UsuarioDAO dao = new UsuarioDAO(getBaseContext());
        try {
        dao.eliminar(idObtenido);
        Intent elim = new Intent(this, LoginUsuarioActivity.class);
        startActivity(elim);
        Toast toast= Toast.makeText(getApplicationContext(), "Se actualizó correctamente", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
        } catch (DAOException e) {
            Log.i("UsuarioEliminadoActi", "====> " + e.getMessage());
        }
    }
}
