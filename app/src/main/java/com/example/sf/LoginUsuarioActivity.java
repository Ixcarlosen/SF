package com.example.sf;

import android.content.Intent;
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

    public void Validar(View view)
    {
        final String email=validaremail.getEditableText().toString().trim();
        final String regex = "(?:[^<>()\\[\\].,;:\\s@\"]+(?:\\.[^<>()\\[\\].,;:\\s@\"]+)*|\"[^\\n\"]+\")@(?:[^<>()\\[\\].,;:\\s@\"]+\\.)+[^<>()\\[\\]\\.,;:\\s@\"]{2,63}";
        String password=validarpassword.getText().toString();

        if (email.length()==0 && password.length()==0)
        {
            Toast.makeText(this, "Campos Obligatorios",Toast.LENGTH_LONG).show();
        }else   if(email.length()==0)
        {
            Toast.makeText(this, "Debes ingresar tu email",Toast.LENGTH_LONG).show();
        }else if (!email.matches(regex))
        {
            Toast.makeText(this, "Por favor, introduce bien tu email", Toast.LENGTH_LONG).show();
        } else if (password.length()==0)
        {
            Toast.makeText(this, "Debes ingresar tu password",Toast.LENGTH_LONG).show();
        }
        else if ((email.equals("gisell@gmail.com") || password.equals("12345678")))
        {
            Intent oIntent = new Intent(this, TiendaActivity.class);
            startActivity(oIntent);


        }
        else
        {
            Toast.makeText(this, "Las credenciales no son correctas",Toast.LENGTH_LONG).show();
        }

    }


    public void enviar(View view1)
    {
        Intent intent = new Intent(this, RegistrarUsuarioActivity.class);
        startActivity(intent);
    }

}
