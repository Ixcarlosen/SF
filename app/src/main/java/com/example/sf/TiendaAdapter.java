package com.example.sf;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class TiendaAdapter extends
        RecyclerView.Adapter<TiendaAdapter.MyViewHolder>
        implements View.OnClickListener
{

    private List<Tienda> tiendaList;
    private View.OnClickListener listener;


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView titulo, descripcion, telefono;
        ImageView foto;


        public MyViewHolder(View view)

        {

            super(view);
            titulo = (TextView) view.findViewById(R.id.titulo);
            descripcion = (TextView) view.findViewById(R.id.descripcion);
            telefono = (TextView) view.findViewById(R.id.telefono);
            foto =(ImageView)view.findViewById(R.id.idImagen);
        }
    }



    public TiendaAdapter(List<Tienda> tiendaList)    {  this.tiendaList = tiendaList;   }


    @Override
    public TiendaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)

    { View itemView = LayoutInflater.from(parent.getContext()) .inflate(R.layout.tienda_fila,null,false);
        itemView.setOnClickListener(this);
        return new TiendaAdapter.MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(TiendaAdapter.MyViewHolder holder, int position)
    {

        Tienda tienda = tiendaList.get(position);
        holder.titulo.setText(tienda.getTitulo());
        holder.descripcion.setText(tienda.getDescripcion());
        holder.telefono.setText(tienda.getTelefono());
        holder.foto.setImageResource(tienda.getImagenId());
    }

    @Override public int getItemCount() {

        return tiendaList.size();
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


