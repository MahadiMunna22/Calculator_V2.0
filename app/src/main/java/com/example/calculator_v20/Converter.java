package com.example.calculator_v20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Converter extends AppCompatActivity {

    private EditText Taka,Dollar,Feet,Inch,farhenheitEditText,celsiusEditText,Kg,Pound,Centimeter,Meter;
    private String taka,dollar,feet,inch,ferhenheit,celsius,kg,pound,centimeter,meter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        Taka = findViewById(R.id.TakaEditText);
        Dollar = findViewById(R.id.DollerEditText);
        Feet = findViewById(R.id.FeetEditText);
        Inch = findViewById(R.id.InchEditText);
        farhenheitEditText=findViewById(R.id.fahrenheitEditText);
        celsiusEditText=findViewById(R.id.celsiusEditText);
        Kg =findViewById(R.id.KgEditText) ;
        Pound = findViewById(R.id.PoundEditText);
        Centimeter =findViewById(R.id.CentimeterEditText) ;
        Meter = findViewById(R.id.MeterEditText);



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


//commenting to push again


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


        //  Celsius -Ferhenheit
        farhenheitEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ferhenheit= String.valueOf(farhenheitEditText.getText());

                try {
                    celsiusEditText.setText(( (Double.parseDouble(ferhenheit)-32) *5/9)+"");
                } catch (NumberFormatException e) {

                }

            }
        });
        celsiusEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                celsius =String.valueOf(celsiusEditText.getText());
                try {
                    farhenheitEditText.setText(( (Double.parseDouble(celsius)*9/5)+32)+"");
                }
                catch (NumberFormatException e) {
                }
            }
        });

        //kg--pound

        Kg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kg= Kg.getText().toString().trim();
                try {
                    Pound.setText((Double.parseDouble(kg)*2.20462)+"");
                } catch (NumberFormatException e) {

                }

            }
        });
        Pound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pound = Pound.getText().toString().trim();
                try {
                    Kg.setText(String.format("%.2f",(Double.parseDouble(pound)/2.20462)));
                } catch (NumberFormatException e) {

                }

            }
        });


        Centimeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                centimeter = Centimeter.getText().toString().trim();
                try {
                    Meter.setText((Double.parseDouble(centimeter)/100)+"");
                } catch (NumberFormatException e) {

                }

            }
        });
        Meter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meter = Meter.getText().toString().trim();
                try {
                    Centimeter.setText((Double.parseDouble(meter)*100)+"");
                }
                catch (NumberFormatException e) {

                }
            }
        });





    }
}
