package com.example.sf;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MensajeActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0;
    EditText textMsg, textPhoneNo;
    String msg, phoneNo;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        //comprobar si el permiso no está concedido
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED) {
            //Si no se concede el permiso, compruebe si el usuario ha denegado el permiso
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {

            } else {
                //aparecerá una ventana emergente solicitando el permiso requerido, es decir, permitir o denegar
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }

        textMsg = findViewById(R.id.textMsg);
        textPhoneNo = findViewById(R.id.textPhoneNo);
        send = findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTextMessage();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        //revisará el código de solicitud
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                //compruebe si la longitud de grantResults es mayor que 0 y es igual a PERMISSION_GRANTED
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Gracias por permitir!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "¿Por qué no lo permitiste?", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    protected void sendTextMessage() {
        msg = textMsg.getText().toString();
        phoneNo = textPhoneNo.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNo, null, msg, null, null);
        Toast.makeText(this, "Enviado!", Toast.LENGTH_LONG).show();

        msg.isEmpty();
        phoneNo.isEmpty();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mapa,menu);
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
