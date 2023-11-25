package com.example.shoppingcart;

import static java.lang.Integer.parseInt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    CheckBox cb1,cb2,cb3;
    Button b3, b4, b5;
    TextView tv7,tv8,tv9;
    EditText et3, et4, et5;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        tv7 = findViewById(R.id.tv7);
        tv8 = findViewById(R.id.tv8);
        tv9 = findViewById(R.id.tv9);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);

        Intent intent = getIntent();
        String cat = intent.getExtras().getString("txt");
        if(cat.equals("Electronics"))
        {
            cb1.setText("Television");
            tv7.setText("90000");
            cb2.setText("Speakers");
            tv8.setText("1500");
            cb3.setText("Laptop");
            tv9.setText("70000");
        }
        else if(cat.equals("Food"))
        {
            cb1.setText("Donut");
            tv7.setText("90");
            cb2.setText("Ladoo");
            tv8.setText("15");
            cb3.setText("Puranpoli");
            tv9.setText("30");
        }
        else if(cat.equals("Books"))
        {
            cb1.setText("Atomic Habits");
            tv7.setText("250");
            cb2.setText("Rich Dad Poor Dad ");
            tv8.setText("300");
            cb3.setText("Mujhe padhna nahi aata");
            tv9.setText("10");
        }

        String[] items = new String[3];
        String[] price = new String[3];
        String[] quant = new String[3];
        String[] tot = new String[4];
        b3.setOnClickListener(v -> {
            if(cb1.isChecked())
            {
                items[0] = cb1.getText().toString();
                price[0] = tv7.getText().toString();
                quant[0] = et3.getText().toString();
                tot[0] = String.valueOf(parseInt(et3.getText().toString())*parseInt(tv7.getText().toString()));
                tot[3] = String.valueOf(parseInt(et3.getText().toString())*parseInt(tv7.getText().toString()));
            }
            if(cb2.isChecked())
            {
                if(cb1.isChecked())
                {
                    items[1] = cb2.getText().toString();
                    price[1] = tv8.getText().toString();
                    quant[1] = et4.getText().toString();
                    tot[1] = String.valueOf(parseInt(et4.getText().toString())*parseInt(tv8.getText().toString()));
                    tot[3] = String.valueOf((parseInt(et4.getText().toString())*parseInt(tv8.getText().toString()))+(parseInt(et3.getText().toString())*parseInt(tv7.getText().toString())));
                }
                else
                {
                    items[0] = cb2.getText().toString();
                    price[0] = tv8.getText().toString();
                    quant[0] = et4.getText().toString();
                    tot[0] = String.valueOf(parseInt(et4.getText().toString())*parseInt(tv8.getText().toString()));
                    tot[3] = String.valueOf(parseInt(et4.getText().toString())*parseInt(tv8.getText().toString()));
                }
            }
            if(cb3.isChecked())
            {
                if(cb1.isChecked())
                {
                    if(cb2.isChecked())
                    {
                        items[2] = cb3.getText().toString();
                        price[2] = tv9.getText().toString();
                        quant[2] = et5.getText().toString();
                        tot[2] = String.valueOf(parseInt(et5.getText().toString())*parseInt(tv9.getText().toString()));
                        tot[3] = String.valueOf((parseInt(et4.getText().toString())*parseInt(tv8.getText().toString()))+(parseInt(et3.getText().toString())*parseInt(tv7.getText().toString()))+(parseInt(et5.getText().toString())*parseInt(tv9.getText().toString())));
                    }
                    else
                    {
                        items[1] = cb3.getText().toString();
                        price[1] = tv9.getText().toString();
                        quant[1] = et5.getText().toString();
                        tot[1] = String.valueOf(parseInt(et5.getText().toString())*parseInt(tv9.getText().toString()));
                        tot[3] = String.valueOf(parseInt(et3.getText().toString())*parseInt(tv7.getText().toString())+(parseInt(et5.getText().toString())*parseInt(tv9.getText().toString())));
                    }
                }
                else if (cb2.isChecked())
                {
                    items[1] = cb3.getText().toString();
                    price[1] = tv9.getText().toString();
                    quant[1] = et5.getText().toString();
                    tot[1] = String.valueOf(parseInt(et5.getText().toString())*parseInt(tv9.getText().toString()));
                    tot[3] = String.valueOf((parseInt(et4.getText().toString())*parseInt(tv8.getText().toString()))+(parseInt(et5.getText().toString())*parseInt(tv9.getText().toString())));
                }
                else
                {
                    items[0] = cb3.getText().toString();
                    price[0] = tv9.getText().toString();
                    quant[0] = et5.getText().toString();
                    tot[0] = String.valueOf(parseInt(et5.getText().toString())*parseInt(tv9.getText().toString()));
                    tot[3] = String.valueOf(parseInt(et5.getText().toString())*parseInt(tv9.getText().toString()));
                }
            }
        });

        b4.setOnClickListener(v -> {
            Intent i = new Intent(Activity3.this,Activity4.class);
            i.putExtra("list", items);
            i.putExtra("list1", price);
            i.putExtra("list2", quant);
            i.putExtra("list3", tot);
            startActivity(i);
        });

        b5.setOnClickListener(v -> {
            finish();
        });
    }
}