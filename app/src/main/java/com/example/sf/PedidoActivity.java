package com.example.sf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PedidoActivity extends AppCompatActivity {
    TextView nombreText;

    Integer[] imagenes={
            R.drawable.vestido1_mujer,
            R.drawable.zapatilla_mujer,
            R.drawable.infantil1,
            R.drawable.botin_mujer
    };
    String[] nombres=new String[]{
            "Vestido Mujer Precio: 150.00","Zapatilla Precio:50.00","Casaca Niño Precio 50.00","Botin Mujer Precio:90.00"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        recibirDatos();

        ListView lv = (ListView)findViewById(R.id.lstPedidos);
        imagenNombre adapter = new imagenNombre(this,nombres,imagenes);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PedidoActivity.this,
                        "Por el momento, el detalle del mensaje no esta disponible", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void recibirDatos()
    {
        /*Bundle extras=getIntent().getExtras();
        String nombre= extras.getString("nombre");


        nombreText=(TextView) findViewById(R.id.emailText);
        nombreText.setText(nombre);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pedidos,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.menu_categorias:
                Intent mensajes = new Intent(this, CategoriaActivity.class);
                startActivity(mensajes);
                return true;

            case R.id.menu_productos:
                Intent salir = new Intent(this, BuscarProductoActivity.class);
                startActivity(salir);
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }
    }
}
