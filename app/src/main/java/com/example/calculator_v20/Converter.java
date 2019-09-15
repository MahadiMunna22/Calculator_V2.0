package com.example.calculator_v20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Converter extends AppCompatActivity {

    //******************************************
    private EditText Taka,Dollar;
    private String taka,dollar;
    //*******************************************

    //******************************************
    private EditText celsiusEditText,fahrenheitEdittext;
    private String celsiusString,fahrenheitString;
    //************************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        Taka = findViewById(R.id.TakaEditText);
        Dollar = findViewById(R.id.DollerEditText);



        //  Taka - Dollar
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


        //
        celsiusEditText=findViewById(R.id.celsiusEditText);
        fahrenheitEdittext=findViewById(R.id.fahrenheitEditText);
        //

        celsiusEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                celsiusString= String.valueOf(celsiusEditText.getText());

                fahrenheitEdittext.setText(""+( Double.parseDouble(celsiusString)*9/5 +32 ));

            }
        });
        fahrenheitEdittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fahrenheitString=String.valueOf((fahrenheitEdittext.getText()));
                celsiusEditText.setText(""+ ( ( Double.parseDouble(fahrenheitString) -32 ) *5/9 ) );
            }
        });





    }
}
