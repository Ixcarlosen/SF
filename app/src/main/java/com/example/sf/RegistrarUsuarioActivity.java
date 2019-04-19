package com.example.sf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
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
        final String email=validarEmail.getEditableText().toString().trim();
        final String regex = "(?:[^<>()\\[\\].,;:\\s@\"]+(?:\\.[^<>()\\[\\].,;:\\s@\"]+)*|\"[^\\n\"]+\")@(?:[^<>()\\[\\].,;:\\s@\"]+\\.)+[^<>()\\[\\]\\.,;:\\s@\"]{2,63}";
        String password=validarContraseña.getText().toString();
        String confirmarpassword=confirmarContraseña.getText().toString();

        if (nombre.length()==0 && apellido.length()==0 && email.length()==0 && password.length()==0) {
            Toast.makeText(this, "Campos Obligatorios",Toast.LENGTH_LONG).show();
        } else if(nombre.length()==0) {
            Toast.makeText(this, "Debes ingresar tu nombre",Toast.LENGTH_LONG).show();
        } else if(apellido.length()==0) {
            Toast.makeText(this, "Debes ingresar tu apellido",Toast.LENGTH_LONG).show();
        } else if(email.length()==0) {
            Toast.makeText(this, "Debes ingresar tu email",Toast.LENGTH_LONG).show();
        }else if (!email.matches(regex)) {
            Toast.makeText(this, "Por favor, introduce bien su email", Toast.LENGTH_LONG).show();
        }else if(password.length()==0) {
            Toast.makeText(this, "Debes ingresar tu password",Toast.LENGTH_LONG).show();
        } else if(password.length()<8) {
            Toast.makeText(this, "El password debe tener mínimo 8 caracteres",Toast.LENGTH_LONG).show();
        } else if(password.equals(confirmarpassword)) {

            /*EditText titulo = (EditText) findViewById(R.id.titulo);
            EditText descripcion = (EditText) findViewById(R.id.descripcion);*/

            RegistrarUsuarioDAO dao = new RegistrarUsuarioDAO(getBaseContext());
            try {
                //dao.eliminarTodos();
                dao.insertar(validarNombre.getText().toString(), validarApellido.getText().toString(),validarEmail.getText().toString(),validarContraseña.getText().toString());
                Toast toast= Toast.makeText(getApplicationContext(), "Se insertó correctamente", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();

                validarNombre.setText(""); validarApellido.setText(""); validarEmail.setText(""); validarContraseña.setText("");

                Intent principal = new Intent(this, LoginUsuarioActivity.class);
                startActivity(principal);
            }
                catch (DAOException e) { Log.i("UsuarioNuevoActi", "====> " + e.getMessage()); } }


            //Toast.makeText(this, "Registro en proceso...",Toast.LENGTH_LONG).show();
         else {
            Toast.makeText(this, "Las contraseñas no son iguales "+password +" - " + confirmarpassword,Toast.LENGTH_LONG).show();
        }
    }

    public void cancelar(View v)
    {
        Intent intent = new Intent(this, LoginUsuarioActivity.class);
        startActivity(intent);

    }

}
