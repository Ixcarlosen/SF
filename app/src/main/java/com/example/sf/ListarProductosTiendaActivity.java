package com.example.sf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_listar_producto_tienda,menu);
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
                Intent tienda = new Intent(this, DetalleTiendaActivity.class);
                startActivity(tienda);
                return true;
            case R.id.menu_mensaje:
                Intent mensaje = new Intent(this, MensajeActivity.class);
                startActivity(mensaje);
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
}

