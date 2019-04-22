package com.example.sf;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
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

public class BuscarProductoActivity extends AppCompatActivity {

    private List<Producto> productoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProductoAdapter mAdapter;
    private String cadenaJson = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_producto);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //recibirDatos();
        EditText campoBusqueda = (EditText) findViewById(R.id.txvBuscarM);
        campoBusqueda.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean procesado = false;
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // Mostrar mensaje
                    Toast.makeText(BuscarProductoActivity.this,
                            "Buscando " + v.getText().toString() + " ...", Toast.LENGTH_LONG).show();
                    // Ocultar teclado virtual
                    InputMethodManager imm =
                            (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    procesado = true;
                }
                return procesado;
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new ProductoAdapter(productoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mAdapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                /*final String nombre;
                nombre = productoList.get(recyclerView.getChildAdapterPosition(v)).getNombre();
                Toast.makeText(getApplicationContext(),"Selección: "+
                        productoList.get(recyclerView.getChildAdapterPosition(v)).getNombre(),Toast.LENGTH_SHORT).show();*/

                Producto item = productoList.get(recyclerView.getChildAdapterPosition(v));
                Intent intent = new Intent (v.getContext(), DetalleProductoActivity.class);

                intent.putExtra("id", item.getId());
                intent.putExtra("nombre", item.getNombre());
                intent.putExtra("descripción", item.getDescripcion());
                intent.putExtra("marca", item.getMarca());
                intent.putExtra("precio", item.getPrecio());
                startActivityForResult(intent, 0);


            }
        });
        recyclerView.setAdapter(mAdapter);
        prepareProductoData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_buscar_producto, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //Bundle extras = getIntent().getExtras();
        //String email = extras.getString("email");

        switch (item.getItemId()) {
            case R.id.menu_buscar:
                Toast.makeText(BuscarProductoActivity.this,
                        "Por el momento, la cámara no esta disponible.", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_categorias:
                Intent categorias = new Intent(this, CategoriaActivity.class);
                startActivity(categorias);
                return true;
            case R.id.menu_perfil:
                Intent perfil = new Intent(this, PerfilActivity.class);
                startActivity(perfil);
                return true;
            case R.id.menu_salir:
                Intent salir = new Intent(this, LoginUsuarioActivity.class);
                startActivity(salir);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*probando*/

    private void prepareProductoData() {
        //https://gisell-gisell1991.c9users.io/tiendas
        Request request = new Request.Builder().url("https://gisell-gisell1991.c9users.io/productos").build();
        OkHttpClient client = new OkHttpClient();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    cadenaJson = response.body().string();
                    Log.i("====>", cadenaJson);
                    BuscarProductoActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            onRun();
                        }
                    });
                }
            }
        });
    }

    public void onRun(){
        Gson gson = new Gson();

        Type stringStringMap = new TypeToken<ArrayList<Map<String, Object>>>() {
        }.getType();
        final ArrayList<Map<String, Object>> retorno = gson.fromJson(cadenaJson, stringStringMap);

        for (Map<String, Object> x : retorno) {
            Producto producto = new Producto();

            producto.setNombre(x.get("nombre").toString());
            producto.setDescripcion(x.get("descripcion").toString());
            producto.setPrecio(x.get("precio").toString());
            producto.setMarca(x.get("marca").toString());
            String image = x.get("id").toString();
            producto.setId(image);
            if (image.isEmpty()){
                //nunca entra aqui
            }
            else {
                if (image.equals("1.0")){
                    producto.setImagen(R.drawable.camisa_hombre);
                }
                else if (image.equals("2.0"))
                {
                    producto.setImagen(R.drawable.pantalon_hombre);
                }
                else if (image.equals("3.0"))
                {
                    producto.setImagen(R.drawable.vestido1_mujer);
                }
                else if (image.equals("4.0"))
                {
                    producto.setImagen(R.drawable.vestido2_mujer);
                }
                else if (image.equals("5.0"))
                {
                    producto.setImagen(R.drawable.infantil1);
                }
                else if (image.equals("6.0"))
                {
                    producto.setImagen(R.drawable.infantil2);
                }
                else if (image.equals("7.0"))
                {
                    producto.setImagen(R.drawable.zapatilla_hombre);
                }
                else if (image.equals("8.0"))
                {
                    producto.setImagen(R.drawable.botin_hombre);
                }
                else if (image.equals("9.0"))
                {
                    producto.setImagen(R.drawable.zapatilla_mujer);
                }
                else if (image.equals("10.0"))
                {
                    producto.setImagen(R.drawable.botin_mujer);
                }
                else if (image.equals("11.0"))
                {
                    producto.setImagen(R.drawable.zapato_infantil);
                }
                else if (image.equals("12.0"))
                {
                    producto.setImagen(R.drawable.zapato2_infantil);
                }
            }
            productoList.add(producto);
        }
        mAdapter.notifyDataSetChanged();
    }

    public void goToCamara(View view) {
        //AlertDialog.Builder ayuda = new AlertDialog.Builder(this);
        //ayuda.setMessage("Por el momento, la cámara no esta disponible.").show();
        Toast.makeText(BuscarProductoActivity.this,
                "Por el momento, la cámara no esta disponible.", Toast.LENGTH_LONG).show();
    }

    private void createChannel() { // Notification channel should only be created for devices running Android API level 26+.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel chan1 = new NotificationChannel( "default_channel_id", "default_channel_id", NotificationManager.IMPORTANCE_NONE);
            chan1.setLightColor(Color.TRANSPARENT);
            chan1.setLockscreenVisibility(Notification.VISIBILITY_SECRET);
            notificationManager.createNotificationChannel(chan1);
            Log.i("=========>", "Canal creado!!");
        }
    }
}
