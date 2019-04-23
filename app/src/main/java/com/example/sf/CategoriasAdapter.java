package com.example.sf;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CategoriasAdapter extends
        RecyclerView.Adapter<CategoriasAdapter.MyViewHolder>
        implements View.OnClickListener {

    private List<Categoria> categoriaList;
    private View.OnClickListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titulo, descripcion;
        ImageView foto;

        public MyViewHolder(View view) {
            super(view);
            titulo = (TextView) view.findViewById(R.id.titulo);
            descripcion = (TextView) view.findViewById(R.id.descripcion);
            foto = (ImageView) view.findViewById(R.id.idImagen);
        }
    }

    public CategoriasAdapter(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    @Override
    public CategoriasAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.categoria_fila, null, false);
        itemView.setOnClickListener(this);
        return new CategoriasAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoriasAdapter.MyViewHolder holder, int position) {
        Categoria categoria = categoriaList.get(position);
        holder.titulo.setText(categoria.getTitulo());
        holder.descripcion.setText(categoria.getDescripcion());
        holder.foto.setImageResource(categoria.getImagenId());
    }

    @Override
    public int getItemCount() {
        return categoriaList.size();
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;

    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);

        }
    }
}

