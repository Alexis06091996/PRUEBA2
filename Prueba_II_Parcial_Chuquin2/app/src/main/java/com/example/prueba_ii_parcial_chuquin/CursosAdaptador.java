package com.example.prueba_ii_parcial_chuquin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CursosAdaptador extends RecyclerView.Adapter<CursosAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre,telefono,correo;
        public  ViewHolder(View itemView){
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.tveNombre);
            telefono=(TextView)itemView.findViewById(R.id.tveNumero);
            correo=(TextView)itemView.findViewById(R.id.tveCorreo);
        }
    }

    public List<ContactosModelo> cursoLista;
    public CursosAdaptador(List<ContactosModelo> cursoLista){this.cursoLista=cursoLista; }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacto,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    public void  onBindViewHolder(ViewHolder holder, int position){
        holder.nombre.setText(cursoLista.get(position).getNombre());
        holder.telefono.setText(cursoLista.get(position).getTelefono());
        holder.correo.setText(cursoLista.get(position).getCorreo());
    }
public int getItemCount(){return cursoLista.size();
    }
}
