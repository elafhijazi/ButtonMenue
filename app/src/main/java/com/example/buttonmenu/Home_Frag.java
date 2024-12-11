package com.example.buttonmenu;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;


public class Home_Frag extends Fragment {
    private FloatingActionButton btnLogOut;
    private Button btnProduct;

    public Home_Frag() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_, container, false);
        btnLogOut=view.findViewById(R.id.btn_logOut);
        btnProduct=view.findViewById(R.id.btnProduct);
        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ProductActivity.class));
                getActivity().finish();
            }
        });
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogOut();
            }
        });
        return view;
    }
    private void LogOut(){
        FirebaseAuth.getInstance().signOut();
        MainActivity.isLogedIn=false;
        MainActivity.LogIn_frame.setVisibility(View.VISIBLE);
        MainActivity.Home_frame.setVisibility(View.INVISIBLE);
        MainActivity.DashBoard_frame.setVisibility(View.INVISIBLE);

    }
}