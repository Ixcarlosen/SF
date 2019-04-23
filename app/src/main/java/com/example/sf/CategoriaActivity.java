package com.example.sf;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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

public class CategoriaActivity extends AppCompatActivity {
    private List<Categoria> categoriaList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CategoriasAdapter mAdapter;

    private String cadenaJson = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);


        /*ListView lv = (ListView) findViewById(R.id.lstMensajes);
        imagenNombre adapter = new imagenNombre(this, nombres, imagenes);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CategoriaActivity.this,
                        "Por el momento el direccionamiento a producto no esta disponible", Toast.LENGTH_LONG).show();*

            }
        });*/

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new CategoriasAdapter(categoriaList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        mAdapter.setListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                final String nombre;
                nombre = categoriaList.get(recyclerView.getChildAdapterPosition(v)).getTitulo();
                Toast.makeText(getApplicationContext(),"Selecciono: "+
                        categoriaList.get(recyclerView.getChildAdapterPosition(v)).getTitulo(),Toast.LENGTH_SHORT).show();

                Categoria item =  categoriaList.get(recyclerView.getChildAdapterPosition(v));
                Intent intent = new Intent (v.getContext(), DetalleProductoActivity.class);


                startActivityForResult(intent, 0);


            }
        });

        recyclerView.setAdapter(mAdapter);
        prepareCategoriaData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_categoria,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_home:
                Intent home = new Intent(this, BuscarProductoActivity.class);
                startActivity(home);
                return true;

            case R.id.menu_tienda:
                Intent tienda = new Intent(this, ListarTiendaActivity.class);
                startActivity(tienda);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }


    /*probando*/
    private void prepareCategoriaData() {

        Request request = new Request.Builder().url("https://gisell-gisell1991.c9users.io/categorias").build();
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
                    CategoriaActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() { onRun(); }
                    });

                }
            }
        });
    }

    public void onRun() {
        Gson gson = new Gson();

        Type stringStringMap = new TypeToken<ArrayList<Map<String, Object>>>() {
        }.getType();
        final ArrayList<Map<String, Object>> retorno = gson.fromJson(cadenaJson, stringStringMap);

        for (Map<String, Object> x : retorno) {
            Categoria categoria = new Categoria();

            categoria.setTitulo(x.get("nombre").toString());
            categoria.setDescripcion(x.get("descripcion").toString());
            String image = x.get("id").toString();

            if (image.isEmpty()){
               //nunca entra aca
            }
            else {
                if (image.equals("1.0")){
                    categoria.setImagenId(R.drawable.ropa_hombre);
                }
                else if (image.equals("2.0"))
                {
                    categoria.setImagenId(R.drawable.ropa_mujer);
                }
                else if (image.equals("3.0"))
                {
                    categoria.setImagenId(R.drawable.ropa_bebe);
                }
                else if (image.equals("4.0"))
                {
                    categoria.setImagenId(R.drawable.calzado_mujer);
                }
                else if (image.equals("5.0"))
                {
                    categoria.setImagenId(R.drawable.calzado_hombre);
                }
                else if (image.equals("6.0"))
                {
                    categoria.setImagenId(R.drawable.calzado_nino);
                }

        }
            categoriaList.add(categoria);
        }
        mAdapter.notifyDataSetChanged();
    }
}




