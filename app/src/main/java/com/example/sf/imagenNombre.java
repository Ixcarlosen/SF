package com.example.sf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class imagenNombre extends BaseAdapter {
    Context c;
    String[] p;
    Integer[] b;

    public imagenNombre(Context con, String[] pai, Integer[] ban){
        c = con;
        p = pai;
        b = ban;
    }

    @Override
    public int getCount() {
        //Para obtener la cantidad de elementos que manejara el BaseAdapter
        return p.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater=(LayoutInflater)c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
        //Se recupera el contenido del activity que invocara a esta clase
        grid = new View(c);
        grid = inflater.inflate(R.layout.activity_mensaje_fila,null);
        //Con esto se le vincula al layout que contendra a los elementos por cada cuadricula

        TextView tpais = (TextView)grid.findViewById(R.id.txtNombre);
        ImageView iimagen = (ImageView)grid.findViewById(R.id.imgImagen);

        tpais.setText(p[position]);
        iimagen.setImageResource(b[position]);
        return grid;
    }
}
