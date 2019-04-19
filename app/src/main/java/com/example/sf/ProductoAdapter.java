package com.example.sf;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductoAdapter extends
        RecyclerView.Adapter<ProductoAdapter.MyViewHolder>
    implements View.OnClickListener {

    private List<Producto> productoList;
    private View.OnClickListener listener;



    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView nombre, descripcion, precio,marca;
        ImageView foto;

        public MyViewHolder(View view)
        {
            super(view);
            //----------------------------------------------------------------------------
            nombre = (TextView) view.findViewById(R.id.titulo);
            descripcion = (TextView) view.findViewById(R.id.descripcion);
            precio = (TextView) view.findViewById(R.id.precio);
            marca = (TextView) view.findViewById(R.id.marca);
            foto =(ImageView)view.findViewById(R.id.idImagen);


        }
    }

    public ProductoAdapter(List<Producto> productoList)
    {
        this.productoList = productoList;
    }

    @Override
    public ProductoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    //----------------------------------------------------------------------------
    { View itemView = LayoutInflater.from(parent.getContext()) .inflate(R.layout.producto_fila,null,false);
        itemView.setOnClickListener(this);
    return new ProductoAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ProductoAdapter.MyViewHolder holder, int position)
    {
        Producto producto = productoList.get(position);
        holder.nombre.setText(producto.getNombre());
        holder.descripcion.setText(producto.getDescripcion());
        holder.precio.setText(producto.getPrecio());
        holder.marca.setText(producto.getMarca());
        holder.foto.setImageResource(producto.getImagen());


    }

    @Override public int getItemCount() {
        return productoList.size();
    }


    public void setListener(View.OnClickListener listener)
    {
        this.listener=listener;

    }

    @Override
    public void onClick(View v) {
        if (listener!=null)
        {
            listener.onClick(v);

        }

    }


}
