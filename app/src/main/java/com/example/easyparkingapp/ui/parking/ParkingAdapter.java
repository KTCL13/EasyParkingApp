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
import com.google.protobuf.StringValue;

import java.util.ArrayList;

public class ParkingAdapter extends RecyclerView.Adapter<ParkingAdapter.ViewHolder> {

    Context context;
    ArrayList<Parking> model;

    public ParkingAdapter(Context context, ArrayList<Parking> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public ParkingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.parking_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParkingAdapter.ViewHolder holder, int position) {

        Parking parking= model.get(position);

        holder.nombre.setText(parking.getNombre());
        holder.address.setText(parking.getAddress());


    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre,address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.name_parking);
            address=itemView.findViewById(R.id.address_parking);
        }
    }
}
