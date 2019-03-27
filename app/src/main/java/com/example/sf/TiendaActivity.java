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

import java.util.ArrayList;
import java.util.List;

public class TiendaActivity extends AppCompatActivity {

    private List<Tienda> peliculaList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TiendasAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);


        /*comienza*/
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new TiendasAdapter(peliculaList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter); preparePeliculaData(); }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_home:
                Intent inte = new Intent(this, MenuActivity.class);
                startActivity(inte);
                return true;
            case R.id.menu_tienda:
                Intent intent = new Intent(this, TiendaActivity.class);
                startActivity(intent);

            case R.id.menu_producto:
                Intent intentt = new Intent(this, ListarProductosTiendaActivity.class);
                startActivity(intentt);


            case R.id.menu_buscar:
                Intent intenttt = new Intent(this, BuscarProductoMActivity.class);
                startActivity(intenttt);


            case R.id.menu_notificacion:
                Intent intenttttt = new Intent(this, ListarMensajesActivity.class);
                startActivity(intenttttt);

            case R.id.menu_foto:
                AlertDialog.Builder contacto = new AlertDialog.Builder(this);
                contacto.setMessage("Cámara no disponible").show();
                return true;

            case R.id.menu_salir:
                Intent intentttt = new Intent(this, LoginUsuarioActivity.class);
                startActivity(intentttt);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }


    private void preparePeliculaData()
    {

        Tienda tienda = new Tienda("Saga Falabella", "Ofrecemos la mejor calidad a nuestros usuarios", "Telf. 452-4567",R.drawable.logo_saga);
        peliculaList.add(tienda);

        tienda = new Tienda("Ripley", "Ofrecemos la mejor calidad a nuestros usuarios", "Telf. 451-7854",R.drawable.logo_ripley);
        peliculaList.add(tienda);


        tienda = new Tienda("Paris", "Ofrecemos la mejor calidad a nuestros usuarios", "Telf. 458-4587",R.drawable.logo_paris);
        peliculaList.add(tienda);


        tienda = new Tienda("HM", "Ofrecemos la mejor calidad a nuestros usuarios", "Telf. 458-4587",R.drawable.logo_hm);
        peliculaList.add(tienda);


        tienda = new Tienda("Oechsle", "Ofrecemos la mejor calidad a nuestros usuarios", "Telf. 458-4587",R.drawable.logo_oechsle);
        peliculaList.add(tienda);


        tienda = new Tienda("Estilos", "Ofrecemos la mejor calidad a nuestros usuarios", "Telf. 458-4587",R.drawable.logo_estilos);
        peliculaList.add(tienda);


        tienda = new Tienda("Now", "Ofrecemos la mejor calidad a nuestros usuarios", "Telf. 458-4587",R.drawable.logo_now);
        peliculaList.add(tienda);



        mAdapter.notifyDataSetChanged();
    }


}
