package com.example.tarea4_navegacinconfragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cargar el fragmento inicial (Rojo)
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new RedFragment()).commit();

        // Configurar BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                // Seleccionar el fragmento basado en el ítem del menú
                if (item.getItemId() == R.id.menu_red) {
                    selectedFragment = new RedFragment();
                } else if (item.getItemId() == R.id.menu_blue) {
                    selectedFragment = new BlueFragment();
                } else if (item.getItemId() == R.id.menu_green) {
                    selectedFragment = new GreenFragment();
                }


                // Reemplazar el fragmento en el contenedor
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, selectedFragment).commit();

                return true;
            }
        });
    }
}