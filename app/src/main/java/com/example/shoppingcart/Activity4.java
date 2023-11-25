package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity4 extends AppCompatActivity {

    TextView tv13, tv14, tv15, tv17, tv18, tv19, tv20, tv21, tv22, tv23, tv24, tv25, tv27;
    Button b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        tv13 = findViewById(R.id.tv13);
        tv14 = findViewById(R.id.tv14);
        tv15 = findViewById(R.id.tv15);
        tv17 = findViewById(R.id.tv17);
        tv18 = findViewById(R.id.tv18);
        tv19 = findViewById(R.id.tv19);
        tv20 = findViewById(R.id.tv20);
        tv21 = findViewById(R.id.tv21);
        tv22 = findViewById(R.id.tv22);
        tv23 = findViewById(R.id.tv23);
        tv24 = findViewById(R.id.tv24);
        tv25 = findViewById(R.id.tv25);
        tv27 = findViewById(R.id.tv27);
        b6 = findViewById(R.id.b6);

        Intent intent = getIntent();
        String[] item = intent.getStringArrayExtra("list");
        String[] prices = intent.getStringArrayExtra("list1");
        String[] quantity = intent.getStringArrayExtra("list2");
        String[] total = intent.getStringArrayExtra("list3");

        tv13.setText(item[0]);
        tv14.setText(item[1]);
        tv15.setText(item[2]);
        tv17.setText(quantity[0]);
        tv18.setText(quantity[1]);
        tv19.setText(quantity[2]);
        tv20.setText(prices[0]);
        tv21.setText(prices[1]);
        tv22.setText(prices[2]);
        tv23.setText(total[0]);
        tv24.setText(total[1]);
        tv25.setText(total[2]);
        tv27.setText(total[3]);

        b6.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Total Bill = " + tv27.getText(), Toast.LENGTH_SHORT).show();
        });
    }
}