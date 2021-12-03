package com.example.easyparkingapp.ui.Mycar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easyparkingapp.databinding.MyCarFragmentBinding;
import com.example.easyparkingapp.persistence.entidades.Car;

import java.util.ArrayList;

public class MyCarFragment extends Fragment {

    private MyCarViewModel myCarViewModel;
    private MyCarFragmentBinding binding;
    private RecyclerView recyclerViewMyCar;
    private ArrayList<Car> carArrayList;
    private MyCarAdapter myCarAdapter;

    public static MyCarFragment newInstance() {
        return new MyCarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        myCarViewModel=new ViewModelProvider(this).get(MyCarViewModel.class);

        binding=MyCarFragmentBinding.inflate(inflater,container,false);
        View root= binding.getRoot();

        recyclerViewMyCar=binding.mycarList;
        carArrayList=new ArrayList<>();

        cargarLista();
        mostrarLista();


        return root;
    }

    private void cargarLista() {
        carArrayList.add(new Car("Kia 240","HDR-4K","#5EE053"));

    }
    private void mostrarLista() {
        recyclerViewMyCar.setLayoutManager(new LinearLayoutManager(getContext()));
        myCarAdapter=new MyCarAdapter(getContext(),carArrayList);
        recyclerViewMyCar.setAdapter(myCarAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myCarViewModel = new ViewModelProvider(this).get(MyCarViewModel.class);
        // TODO: Use the ViewModel
    }

}