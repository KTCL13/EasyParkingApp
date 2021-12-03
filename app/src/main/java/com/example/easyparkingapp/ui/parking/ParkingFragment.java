package com.example.easyparkingapp.ui.parking;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easyparkingapp.R;
import com.example.easyparkingapp.persistence.entidades.Parking;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.Queue;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ParkingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ParkingFragment extends Fragment {

    private ParkingAdapter parkingAdapter;
    private RecyclerView recyclerViewParking;
    private ArrayList<Parking> parkingArrayList;
    private FirebaseFirestore mFirestore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_parking, container, false);

        recyclerViewParking=view.findViewById(R.id.parking_list);
        parkingArrayList= new ArrayList<>();

        mFirestore=FirebaseFirestore.getInstance();

        Query query=mFirestore.collection("parqueaderos");

        recyclerViewParking.setLayoutManager(new LinearLayoutManager(getContext()));

        ParkingAdapter<Parking>firestoreRecyclerOptions=
        getParkingsFromFirebase();
        // Inflate the layout for this fragment
        return view;
    }


    private void getParkingsFromFirebase() {
    }


}