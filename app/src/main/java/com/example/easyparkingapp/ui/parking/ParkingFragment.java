package com.example.easyparkingapp.ui.parking;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easyparkingapp.R;
import com.example.easyparkingapp.persistence.entidades.Parking;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

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
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                            @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_parking, container, false);
        /**
        ProgressDialog progressDialog=new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Recuperando datos...");
        progressDialog.show();
         */
        recyclerViewParking=view.findViewById(R.id.parking_list);
        parkingArrayList= new ArrayList<>();

        mFirestore=FirebaseFirestore.getInstance();

        recyclerViewParking.setLayoutManager(new LinearLayoutManager(getContext()));

        parkingArrayList= new ArrayList<>();
        parkingAdapter=new ParkingAdapter(getContext(),parkingArrayList);

        recyclerViewParking.setAdapter(parkingAdapter);
        getParkingsFromFirebase();
        // Inflate the layout for this fragment
        return view;
    }


    private void getParkingsFromFirebase() {
        mFirestore.collection("parqueaderos").orderBy("nombre", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if(error != null){
                            Log.e("Firestore error",error.getMessage());
                            return;
                        }
                        for(DocumentChange dc: value.getDocumentChanges()){
                            if(dc.getType()==DocumentChange.Type.ADDED){

                                parkingArrayList.add(dc.getDocument().toObject(Parking.class));
                            }

                            parkingAdapter.notifyDataSetChanged();

                        }
                    }
                });
    }
}