package com.example.calculator_v20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Converter extends AppCompatActivity {

    private EditText Taka,Dollar,Feet,Inch;
    private String taka,dollar,feet,inch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        Taka = findViewById(R.id.TakaEditText);
        Dollar = findViewById(R.id.DollerEditText);
        Feet = findViewById(R.id.FeetEditText);
        Inch = findViewById(R.id.InchEditText);
        //  Taka - Dollar1
        //push again
        Taka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taka = Taka.getText().toString().trim();
                try {
                    Dollar.setText((Double.parseDouble(taka)/80)+"");
                } catch (NumberFormatException e) {

                }

            }
        });
        Dollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dollar = Dollar.getText().toString().trim();
                try {
                    Taka.setText((Double.parseDouble(dollar)*80)+"");
                }
                catch (NumberFormatException e) {

                }
            }
        });





        //  Feet - Inch
        Feet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feet = Feet.getText().toString().trim();
                try {
                    Inch.setText((Double.parseDouble(feet)*12)+"");
                } catch (NumberFormatException e) {

                }

            }
        });
        Inch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inch = Inch.getText().toString().trim();
                try {
                    Feet.setText(String.format("%.2f",(Double.parseDouble(inch)/12)));
                }
                catch (NumberFormatException e) {
                }
            }
        });


    }
}
