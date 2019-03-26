package com.example.sf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarUsuarioActivity extends AppCompatActivity
{

    private EditText validarNombre,validarApellido,validarEmail,validarContraseña,confirmarContraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        validarNombre=(EditText)findViewById(R.id.txtNombre);
        validarApellido=(EditText)findViewById(R.id.txtApellido);
        validarEmail=(EditText)findViewById(R.id.txtEmail);
        validarContraseña=(EditText)findViewById(R.id.txtPassword);
        confirmarContraseña=(EditText)findViewById(R.id.txtConfirmarPassword);
    }

    //metodo de boton

    public void Validar(View view)
    {
        String nombre=validarNombre.getText().toString();
        String apellido=validarApellido.getText().toString();
        String email=validarEmail.getText().toString();
        String password=validarContraseña.getText().toString();
        String confirmarpassword=confirmarContraseña.getText().toString();

        if (nombre.length()==0 && apellido.length()==0 && email.length()==0 && password.length()==0)
        {
            Toast.makeText(this, "Campos Obligatorios",Toast.LENGTH_LONG).show();
        }

        if(email.length()==0 && password.length()!=0)
        {
            Toast.makeText(this, "Debes ingresar tu email",Toast.LENGTH_LONG).show();
        }
        if (password.length()==0 && email.length()!=0)
        {
            Toast.makeText(this, "Debes ingresar tu password",Toast.LENGTH_LONG).show();
        }
        if(password.length()!=0 && password.length()<8)
        {
            Toast.makeText(this, "El Password debe tener mínimo 8 caracteres",Toast.LENGTH_LONG).show();
        }

        if(password!=confirmarpassword)
        {
            Toast.makeText(this, "Las contraseñas no son iguales",Toast.LENGTH_LONG).show();
        }

        if (nombre.length()!=0 && apellido.length()!=0 && email.length()!=0 && password.length()!=0 && confirmarpassword.length()!=0)
        {
            Toast.makeText(this, "Registro en proceso...",Toast.LENGTH_LONG).show();
        }

    }
}
