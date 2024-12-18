package com.example.lesson13;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    private static final String TAG_ACTIVITY = OrderActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Navegar de regreso a MainActivity cuando se presione el icono
        toolbar.setNavigationOnClickListener(v -> finish());

        // Obtener el artículo seleccionado desde el Intent
        Intent intent = getIntent();
        String selectedItem = intent.getStringExtra("selectedItem");

        // Actualizar el TextView con el mensaje "You ordered a [item]"
        TextView orderIntroText = findViewById(R.id.order_intro_text);
        if (selectedItem != null) {
            orderIntroText.setText("You ordered a " + selectedItem);
        } else {
            orderIntroText.setText("No item selected");
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String message = "";

        if (view.getId() == R.id.sameday) {
            if (checked) {
                message = getString(R.string.same_day_messenger_service);
            }
        } else if (view.getId() == R.id.nextday) {
            if (checked) {
                message = getString(R.string.next_day_ground_delivery);
            }
        } else if (view.getId() == R.id.pickup) {
            if (checked) {
                message = getString(R.string.pick_up);
            }
        } else {
            Log.d(TAG_ACTIVITY, getString(R.string.nothing_clicked));
        }

        displayToast(getString(R.string.chosen) + message);
    }
}
