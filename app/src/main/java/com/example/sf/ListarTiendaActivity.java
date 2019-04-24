package com.example.sf;

import android.content.Intent;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;

import android.widget.ArrayAdapter;

import android.widget.EditText;

import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.util.ArrayList;
import java.util.List;




public class ListarTiendaActivity extends AppCompatActivity {


    private List<Tienda> tiendaList = new ArrayList<>();

    private RecyclerView recyclerView;

    private TiendaAdapter mAdapter;


    private String cadenaJson = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tienda);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new TiendaAdapter(tiendaList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        mAdapter.setListener(new View.OnClickListener() {


            @Override

            public void onClick(final View v) {
               /*

                final String nombre;
                nombre = tiendaList.get(recyclerView.getChildAdapterPosition(v)).getTitulo();

                Toast.makeText(getApplicationContext(),"Selección: "+
                        tiendaList.get(recyclerView.getChildAdapterPosition(v)).getTitulo(),Toast.LENGTH_SHORT).show();

                */
                Tienda item = tiendaList.get(recyclerView.getChildAdapterPosition(v));
                Intent intent = new Intent (v.getContext(), DetalleTiendaActivity.class);

                intent.putExtra("id", item.getId());
                intent.putExtra("titulo", item.getTitulo());
                intent.putExtra("descripcion", item.getDescripcion());
                intent.putExtra("telefono", item.getTelefono());
                startActivityForResult(intent, 0);

            }
        });
        recyclerView.setAdapter(mAdapter);
        prepareTiendaData();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_tienda,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_home:

                Intent inte = new Intent(this, BuscarProductoActivity.class);

                startActivity(inte);

                return true;

            case R.id.menu_categoria:

                Intent categoria = new Intent(this, CategoriaActivity.class);

                startActivity(categoria);

                return true;

            case R.id.menu_salir:

                Intent salir = new Intent(this, LoginUsuarioActivity.class);

                startActivity(salir);

                return true;

            default:

                return super.onOptionsItemSelected(item);
        }
    }


    private void prepareTiendaData()
    {

//https://gisell-gisell1991.c9users.io/tiendas

        Request request = new Request.Builder().url("https://gisell-gisell1991.c9users.io/tiendas").build();

        OkHttpClient client = new OkHttpClient();

        client.newCall(request).enqueue(new Callback()
        {

            @Override
            public void onFailure(Call call, IOException e)

            {
                e.printStackTrace();
            }

            @Override

            public void onResponse(Call call, final Response response) throws IOException

            {

                if (!response.isSuccessful()) {

                    throw new IOException("Unexpected code " + response);
                }
                else {
                    cadenaJson = response.body().string();
                    Log.i("====>", cadenaJson);
                    ListarTiendaActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() { onRun(); }
                    });
                }
            }
        });
        /*
        Tienda tienda = new Tienda("Saga Falabella", "Ofrecemos la mejor calidad a nuestros usuarios", "Telf. 452-4567",R.drawable.logo_saga);
        tiendaList.add(tienda);
        tienda = new Tienda("Ripley", "Ofrecemos la mejor calidad a nuestros usuarios", "Telf. 451-7854",R.drawable.logo_ripley);
        tiendaList.add(tienda);
        tienda = new Tienda("Paris", "Ofrecemos la mejor calidad a nuestros usuarios", "Telf. 458-4587",R.drawable.logo_paris);
        tiendaList.add(tienda);
        tienda = new Tienda("HM", "Ofrecemos la mejor calidad a nuestros usuarios", "Telf. 458-4587",R.drawable.logo_hm);
        tiendaList.add(tienda);

tienda = new Tienda("Oechsle", "Ofrecemos la mejor calidad a nuestros usuarios", "Telf. 458-4587",R.drawable.logo_oechsle);

tiendaList.add(tienda);

tienda = new Tienda("Estilos", "Ofrecemos la mejor calidad a nuestros usuarios", "Telf. 458-4587",R.drawable.logo_estilos);
        tiendaList.add(tienda);
        tienda = new Tienda("Now", "Ofrecemos la mejor calidad a nuestros usuarios", "Telf. 458-4587",R.drawable.logo_now);
        tiendaList.add(tienda);

*/
        //mAdapter.notifyDataSetChanged();

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
        mAdapter.notifyDataSetChanged();
    }
}