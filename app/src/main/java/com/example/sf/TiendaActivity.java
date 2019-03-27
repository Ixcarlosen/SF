package com.example.sf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

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
