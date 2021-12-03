package com.example.easyparkingapp.ui.parking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyparkingapp.R;
import com.example.easyparkingapp.persistence.entidades.Parking;

import java.util.ArrayList;

public class ParkingAdapter extends RecyclerView.Adapter<ParkingAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<Parking> model;

    public ParkingAdapter(Context context, ArrayList<Parking> model) {
        this.inflater = LayoutInflater.from(context);
        this.model = model;
    }

    @NonNull
    @Override
    public ParkingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.parking_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParkingAdapter.ViewHolder holder, int position) {

        String nombre=model.get(position).getNombre();
        String address=model.get(position).getAddress();
        int imagen=model.get(position).getImageId();

        holder.nombres.setText(nombre);
        holder.direccion.setText(address);
        holder.imagen.setImageResource(imagen);

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombres,direccion;
        ImageView imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombres=itemView.findViewById(R.id.name_parking);
            direccion=itemView.findViewById(R.id.address_parking);
            imagen=itemView.findViewById(R.id.icon_parking);

        }
    }
}
