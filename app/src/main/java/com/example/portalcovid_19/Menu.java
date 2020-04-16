package com.example.portalcovid_19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Menu extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private RecyclerView rvArtikel;
    private ArrayList<artikel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getWindow().setStatusBarColor(Color.rgb(222,26,26));
        loadFragment(new homeFragment());
        BottomNavigationView navigation = findViewById(R.id.bottom_nav);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.menu_berita:
                fragment = new homeFragment();

                break;
            case R.id.menu_rs:
                fragment = new rsFragment();
                break;
            case R.id.menu_profil:
                fragment = new profilFragment();
                break;
        }
        return loadFragment(fragment);
    }

    public boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.menu_content,fragment)
                    .commit();
            return true;
        }
        return false;
    }




    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
