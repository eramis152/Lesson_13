package com.example.lesson13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String selectedItem; // Para almacenar el artículo seleccionado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configura la Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Navegar a OrderActivity cuando se presione el icono
        toolbar.setNavigationOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, OrderActivity.class);
            // Pasar el nombre del artículo seleccionado
            intent.putExtra("selectedItem", selectedItem);
            startActivity(intent);
        });
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showFoodOrder(View view) {
        int viewId = view.getId();

        // Guardar el nombre del artículo seleccionado
        if (viewId == R.id.donut) {
            selectedItem = "donut";
            displayToast(getString(R.string.donut_order_message));
        } else if (viewId == R.id.ice_cream) {
            selectedItem = "ice cream";
            displayToast(getString(R.string.ice_cream_order_message));
        } else if (viewId == R.id.froyo) {
            selectedItem = "froyo";
            displayToast(getString(R.string.froyo_order_message));
        }
    }

    public void goToOrderActivity(View view) {
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra("selectedItem", selectedItem);
        startActivity(intent);
    }
}
