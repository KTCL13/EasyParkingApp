package com.example.easyparkingapp.ui.Mycar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyparkingapp.R;
import com.example.easyparkingapp.persistence.entidades.Car;

import java.util.ArrayList;

public class MyCarAdapter extends RecyclerView.Adapter<MyCarAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Car> model;

    public MyCarAdapter(){}

    public MyCarAdapter(Context context, ArrayList<Car> model){
        this.inflater = LayoutInflater.from(context);
        this.model = model;
    }

    @NonNull
    @Override
    public MyCarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.my_car_item,parent,false);

        return new MyCarAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCarAdapter.ViewHolder holder, int position) {

        String modelo=model.get(position).getModelo();
        String placa=model.get(position).getPlaca();
        String color=model.get(position).getColor();

        holder.modelo.setText(modelo);
        holder.placa.setText(placa);
        holder.color.setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_IN);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView modelo,placa;
        ImageView color;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            modelo=itemView.findViewById(R.id.myCar_model);
            placa=itemView.findViewById(R.id.myCar_placa);
            color=itemView.findViewById(R.id.icon_myCar);
        }
    }
}
