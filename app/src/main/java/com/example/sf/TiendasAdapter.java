package com.example.sf;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TiendasAdapter extends
        RecyclerView.Adapter<TiendasAdapter.MyViewHolder>
{
    private List<Tienda> peliculasList;
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView titulo, descripcion, telefono;
        ImageView foto;

        public MyViewHolder(View view)
        {
            super(view);
            titulo = (TextView) view.findViewById(R.id.titulo);
            descripcion = (TextView) view.findViewById(R.id.genero);
            telefono = (TextView) view.findViewById(R.id.año);
            foto=(ImageView)view.findViewById(R.id.idImagen);
        }
    }
    public TiendasAdapter(List<Tienda> peliculasList)
    {
        this.peliculasList = peliculasList;
    }
    @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    { View itemView = LayoutInflater.from(parent.getContext()) .inflate(R.layout.tienda_fila,null,false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        Tienda pelicula = peliculasList.get(position);
        holder.titulo.setText(pelicula.getTitulo());
        holder.descripcion.setText(pelicula.getDescripcion());
        holder.telefono.setText(pelicula.getTelefono());
        holder.foto.setImageResource(pelicula.getImagenId());
    }
    @Override public int getItemCount() {
        return peliculasList.size();

    }

}

