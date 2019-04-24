package com.example.sf;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DetalleProductoActivity extends AppCompatActivity {
    private static final String TAG= "GalleryActivity";
    ImageView imagen;
    String marca, precio;
    private List<Tienda> tiendaList = new ArrayList<>();
    private String cadenaJson = "";
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        TextView txtNombre = findViewById(R.id.txtNombre);
        TextView txtDescripcion = findViewById(R.id.txtDescripcion);
        TextView txtMarca = findViewById(R.id.txtMarca);
        TextView txtPrecio = findViewById(R.id.txtPrecio);
        imagen =(ImageView)findViewById(R.id.imagen);
        Button btnTienda = findViewById(R.id.btnTienda);

        btnTienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irTienda(v);
            }
        });
        bundle = getIntent().getExtras();

        txtNombre.setText(bundle.getString("nombre"));
        txtDescripcion.setText(bundle.getString("descripcion"));
        marca=bundle.getString("marca");
        precio=bundle.getString("precio");
        txtMarca.setText("Marca: "+marca);
        txtPrecio.setText("Precio: "+precio);
        String id = bundle.getString("id");

        if (id.equals("1.0")){
            imagen.setImageResource(R.drawable.camisa_hombre);
        }
        else if (id.equals("2.0"))
        {
            imagen.setImageResource(R.drawable.pantalon_hombre);
        }
        else if (id.equals("3.0"))
        {
            imagen.setImageResource(R.drawable.vestido1_mujer);
        }
        else if (id.equals("4.0"))
        {
            imagen.setImageResource(R.drawable.vestido2_mujer);
        }
        else if (id.equals("5.0"))
        {
            imagen.setImageResource(R.drawable.infantil1);
        }
        else if (id.equals("6.0"))
        {
            imagen.setImageResource(R.drawable.infantil2);
        }
        else if (id.equals("7.0"))
        {
            imagen.setImageResource(R.drawable.zapatilla_hombre);
        }
        else if (id.equals("8.0"))
        {
            imagen.setImageResource(R.drawable.botin_hombre);
        }
        else if (id.equals("9.0"))
        {
            imagen.setImageResource(R.drawable.zapatilla_mujer);
        }
        else if (id.equals("10.0"))
        {
            imagen.setImageResource(R.drawable.botin_mujer);
        }
        else if (id.equals("11.0"))
        {
            imagen.setImageResource(R.drawable.zapato_infantil);
        }
        else if (id.equals("12.0"))
        {
            imagen.setImageResource(R.drawable.zapato2_infantil);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalle_producto,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_buscar:
                Toast.makeText(this,
                        "Por el momento, la cámara no está disponible", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_atras:
                Intent producto = new Intent(this,BuscarProductoActivity.class);
                startActivity(producto);
                return true;
            case R.id.menu_llamar:
                Toast.makeText(this,
                        "Por el momento, llamar no esta disponible", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_salir:
                Intent salir = new Intent(this, LoginUsuarioActivity.class);
                startActivity(salir);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Para que no se use el boton atras del android
    @Override
    public void onBackPressed() {
    }

    public void pedir(View view) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(DetalleProductoActivity.this);
        alerta.setMessage("¿Desea pedir este producto?")
                .setCancelable(false)

                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Se agrego producto", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog titulo = alerta.create();
        titulo.setTitle("Agregar pedido");
        titulo.show();
    }

    public void irLista (View view) {
        Intent lista = new Intent(this, BuscarProductoActivity.class);
        startActivity(lista);
    }
    public void irTienda (View view)
    {
        String id = bundle.getString("tiendaid");
        obtenerTienda(id);
    }


    private void obtenerTienda(String id)
    {
        Request request = new Request.Builder().url("https://gisell-gisell1991.c9users.io/tienda/"+id).build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                onFailure2(call, e);
            }
            @Override
            public void onResponse(Call call, final Response response) throws IOException
            {
                onResponse2(response);
            }
        });
    }
    public void onFailure2(Call call, IOException e){
        e.printStackTrace();
    }
    public void onResponse2(Response response) throws IOException{
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        else {
            cadenaJson = response.body().string();
            Log.i("====>", cadenaJson);
            DetalleProductoActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() { onRun(); }
            });
        }
    }
    public void onRun(){
        Gson gson = new Gson();

        Type stringStringMap = new TypeToken<ArrayList<Map<String, Object>>>() {
        }.getType();
        final ArrayList<Map<String, Object>> retorno = gson.fromJson(cadenaJson, stringStringMap);

        for (Map<String, Object> x : retorno) {
            Tienda tienda = new Tienda();
            tienda.setTitulo(x.get("titulo").toString());
            tienda.setDescripcion(x.get("descripcion").toString());
            tienda.setTelefono(x.get("telefono").toString());
            tienda.setId(x.get("id").toString());

            if (tienda.getId().isEmpty()){
                //nunca entra aqui
            }
            else {
                if (tienda.getId().equals("1.0")){
                    tienda.setImagenId(R.drawable.logo_ripley);
                }
                else if (tienda.getId().equals("2.0"))
                {
                    tienda.setImagenId(R.drawable.logo_saga);
                }
                else if (tienda.getId().equals("3.0"))
                {
                    tienda.setImagenId(R.drawable.logo_paris);
                }
                else if (tienda.getId().equals("4.0"))
                {
                    tienda.setImagenId(R.drawable.logo_hm);
                }
            }
            tiendaList.add(tienda);
        }
        Intent tiendaIntent = new Intent(this, DetalleTiendaActivity.class);

        if (tiendaList.size()>0){
            Tienda item = tiendaList.get(0);
            tiendaIntent.putExtra("id", item.getId());
            tiendaIntent.putExtra("titulo", item.getTitulo());
            tiendaIntent.putExtra("descripcion", item.getDescripcion());
            tiendaIntent.putExtra("telefono", item.getTelefono());
        }
        startActivity(tiendaIntent);
    }
}



