package com.example.sf;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginUsuarioActivity extends AppCompatActivity {

    private EditText validaremail,validarpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuario);

        validaremail=(EditText)findViewById(R.id.email);
        validarpassword=(EditText)findViewById(R.id.password);
    }

    //metodo de boton

    public void Validar(View view) throws DAOException {
        final String email = validaremail.getEditableText().toString().trim();
        final String regex = "(?:[^<>()\\[\\].,;:\\s@\"]+(?:\\.[^<>()\\[\\].,;:\\s@\"]+)*|\"[^\\n\"]+\")@(?:[^<>()\\[\\].,;:\\s@\"]+\\.)+[^<>()\\[\\]\\.,;:\\s@\"]{2,63}";
        String password = validarpassword.getText().toString();

        if (email.length() == 0 && password.length() == 0) {
            Toast.makeText(this, "Campos Obligatorios", Toast.LENGTH_LONG).show();
        } else if (email.length() == 0) {
            Toast.makeText(this, "Debes ingresar tu email", Toast.LENGTH_LONG).show();
        } else if (!email.matches(regex)) {
            Toast.makeText(this, "Por favor, introduce bien tu email", Toast.LENGTH_LONG).show();
        } else if (password.length() == 0) {
            Toast.makeText(this, "Debes ingresar tu password", Toast.LENGTH_LONG).show();
        }
        else {
            UsuarioDAO dao = new UsuarioDAO(getBaseContext());

            Usuario respuesta = dao.consultar(validaremail.getText().toString(), validarpassword.getText().toString());
            if (respuesta.getEmail() == null) {
                Toast.makeText(this, "El usuario no está registrado", Toast.LENGTH_LONG).show();
            }
            else{
                SharedPreferences prefs = getSharedPreferences("PERFIL", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("ID", respuesta.getId());
                editor.putString("NOMBRE", respuesta.getNombre());
                editor.putString("APELLIDO", respuesta.getApellido());
                editor.putString("EMAIL", respuesta.getEmail());
                editor.putString("PASSWORD", respuesta.getPassword());
                editor.commit();

                Intent intent = new Intent(this, BuscarProductoActivity.class);
                startActivity(intent);
            }
        }
    }

    //Para que no se use el boton atras del android
    @Override
    public void onBackPressed() {
    }

    public void enviar(View view1)
    {
        Intent intent = new Intent(this, RegistrarUsuarioActivity.class);
        startActivity(intent);
    }

}
