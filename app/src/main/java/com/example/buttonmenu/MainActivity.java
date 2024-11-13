package com.example.buttonmenu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
public static FrameLayout Home_frame,DashBoard_frame,LogIn_frame;
private Home_Frag homeFrag;
private DashBoardFrag dashBoardFrag;
private LoginFrag loginFrag;
private BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Home_frame=findViewById(R.id.Home_Frame);
        DashBoard_frame=findViewById(R.id.Dashboard_Frame);
        LogIn_frame=findViewById(R.id.LogIn_Frame);
        bottomNavigation=findViewById(R.id.bottom_navigation);
        startFragment();

    }
    private void startFragment(){
       homeFrag=new Home_Frag();
       dashBoardFrag=new DashBoardFrag();
       loginFrag=new LoginFrag();
       getSupportFragmentManager().beginTransaction().replace(R.id.Home_Frame,homeFrag).commit();
       getSupportFragmentManager().beginTransaction().replace(R.id.Dashboard_Frame,dashBoardFrag).commit();
       getSupportFragmentManager().beginTransaction().replace(R.id.LogIn_Frame,loginFrag).commit();
       //hide other fragments
        DashBoard_frame.setVisibility(View.INVISIBLE);
        LogIn_frame.setVisibility(View.INVISIBLE);
        //Set up navigation View listener
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.menu_Home){
                    Home_frame.setVisibility(View.VISIBLE);
                    DashBoard_frame.setVisibility(View.INVISIBLE);
                    LogIn_frame.setVisibility(View.INVISIBLE);
                }
                if (item.getItemId()==R.id.menu_Dashboard){
                    Home_frame.setVisibility(View.INVISIBLE);
                    DashBoard_frame.setVisibility(View.VISIBLE);
                    LogIn_frame.setVisibility(View.INVISIBLE);
                }
                if (item.getItemId()==R.id.menu_LogIn){
                    Home_frame.setVisibility(View.INVISIBLE);
                    DashBoard_frame.setVisibility(View.INVISIBLE);
                    LogIn_frame.setVisibility(View.VISIBLE);
                }

                return true;
            }
        });


    }
}