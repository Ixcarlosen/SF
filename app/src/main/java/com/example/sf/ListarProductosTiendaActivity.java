package com.example.sf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListarProductosTiendaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_productos_tienda);

        ListView lstProductos = (ListView)findViewById(R.id.lstGeneros);
        int i = 0;
        String[] matriz = new String[6];
        matriz[i++] = "Polo Batman";
        matriz[i++] = "Polo Batman oscuro";
        matriz[i++] = "Polo Superman";
        matriz[i++] = "Polo Flash";
        matriz[i++] = "Polo Mujer Maravilla";
        matriz[i++] = "Polo Gatubela";
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(ListarProductosTiendaActivity.this, android.R.layout.simple_list_item_1, matriz);
        lstProductos.setAdapter(adaptador);
    }

}

