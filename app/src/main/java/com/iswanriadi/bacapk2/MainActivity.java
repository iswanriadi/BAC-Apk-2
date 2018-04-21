package com.iswanriadi.bacapk2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnCheckbox, mBtnRadio, mBtnToggle, mBtnSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnCheckbox = findViewById(R.id.btn_checkbox);
        mBtnRadio = findViewById(R.id.btn_radio);
        mBtnToggle = findViewById(R.id.btn_toggle);
        mBtnSpinner = findViewById(R.id.btn_spinner);

        mBtnCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KontrolInputActivity.class);
                intent.putExtra("judul", "CHECKBOX");
                startActivity(intent);
            }
        });
        mBtnRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KontrolInputActivity.class);
                intent.putExtra("judul", "RADIO");
                startActivity(intent);
            }
        });
        mBtnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KontrolInputActivity.class);
                intent.putExtra("judul", "TOGGLE");
                startActivity(intent);
            }
        });
        mBtnSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KontrolInputActivity.class);
                intent.putExtra("judul", "SPINNER");
                startActivity(intent);
            }
        });
    }
}
