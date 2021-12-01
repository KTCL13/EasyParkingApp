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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.easyparkingapp.Bienvenida;
import com.example.easyparkingapp.R;
import com.example.easyparkingapp.databinding.FragmentProfileBinding;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends Fragment {

    private ProfileViewModel mViewModel;
    private FragmentProfileBinding binding;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel=new ViewModelProvider(this).get(ProfileViewModel.class);
                binding=FragmentProfileBinding.inflate(inflater,container,false);
                View root= binding.getRoot();

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        // TODO: Use the ViewModel
    }


}