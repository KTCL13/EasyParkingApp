package com.example.easyparkingapp.ui.profile;

import androidx.annotation.StringDef;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.easyparkingapp.Bienvenida;
import com.example.easyparkingapp.R;
import com.example.easyparkingapp.databinding.FragmentProfileBinding;

import com.example.easyparkingapp.persistence.entidades.Parking;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

public class ProfileFragment extends Fragment {

    private ProfileViewModel mViewModel;
    private FragmentProfileBinding binding;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private String userID;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel=new ViewModelProvider(this).get(ProfileViewModel.class);
                binding=FragmentProfileBinding.inflate(inflater,container,false);
                View root= binding.getRoot();

                mAuth=FirebaseAuth.getInstance();


                userID=mAuth.getCurrentUser().getUid();

                db=FirebaseFirestore.getInstance();

                fetchdata();

                binding.logoutButton.setOnClickListener(v -> {
                    AlertDialog.Builder confirm= new AlertDialog.Builder(v.getContext());
                    confirm.setMessage(R.string.logOut)
                            .setCancelable(false)
                            .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    FirebaseAuth.getInstance().signOut();
                                    Intent home= new Intent(v.getContext(), Bienvenida.class);
                                    startActivity(home);
                                }
                            })
                            .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                    confirm.create();
                    confirm.show();
                });
        return root;
    }

    public void fetchdata(){
        DocumentReference documentReference=db.collection("usuarios").document(userID);
        documentReference.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if(documentSnapshot.exists()){

                    binding.profileNumber.setText(documentSnapshot.getString("phoneNumber"));
                    binding.profileName.setText(documentSnapshot.getString("nombre"));
                    binding.profileEmail.setText(documentSnapshot.getString("correo"));

                }
                else
                    Toast.makeText(getContext().getApplicationContext(),"failed to fetch data", Toast.LENGTH_SHORT).show();

                }
            })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext().getApplicationContext(),"failed to fetch data", Toast.LENGTH_SHORT).show();
                    }
                });
        }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        // TODO: Use the ViewModel
    }


}