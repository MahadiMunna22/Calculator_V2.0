package com.example.calculator_v20;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Advanced extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private String x = "",y = "", adv_result, inf = "Infinity";
    private int len=0;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);
        setTitle("Advanced Calculator");

        databaseReference = FirebaseDatabase.getInstance().getReference("Advanced Result");

        drawerLayout = findViewById(R.id.DrawerLayout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final EditText edit = findViewById(R.id.editText);
        final TextView text = findViewById(R.id.Text);

        Button sin = findViewById(R.id.btn_sine);
        Button cos = findViewById(R.id.btn_cosine);
        Button tan = findViewById(R.id.btn_tan);
        Button cot = findViewById(R.id.btn_cot);
        Button sec = findViewById(R.id.btn_sec);
        Button cosec = findViewById(R.id.btn_cosec);
        Button log = findViewById(R.id.btn_log);
        Button power = findViewById(R.id.btn_power);
        Button enter = findViewById(R.id.btn_equal);
        Button factorial = findViewById(R.id.factorial);
        Button root = findViewById(R.id.root);


        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double a = Double.parseDouble(edit.getText().toString());
                    double result = Math.sin(Math.toRadians(a));
                    adv_result = "sin("+a+") = "+String.format("%.3f",result);
                    text.setText(adv_result);
                    SaveData();
                } catch (Exception e) {
                    text.setText("Enter correctly");
                }
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double a = Double.parseDouble(edit.getText().toString());
                    double result = Math.cos(Math.toRadians(a));
                    adv_result = "cos("+a+") = "+String.format("%.3f",result);
                    text.setText(adv_result);
                    SaveData();
                } catch (Exception e) {
                    text.setText("Enter correctly");
                }
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double a = Double.parseDouble(edit.getText().toString());
                    if(a == 90.0)
                    {
                        adv_result = "tan(90) = "+inf;
                        text.setText(adv_result);
                        SaveData();
                    }
                    else
                    {
                        double result = Math.tan(Math.toRadians(a));
                        adv_result = "tan("+a+") = "+String.format("%.3f",result);
                        text.setText(adv_result);
                        SaveData();
                    }
                } catch (Exception e) {
                    text.setText("Enter correctly");
                }
            }
        });
        cot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    double a = Double.parseDouble(edit.getText().toString());
                    if(a == 0.0)
                    {
                        adv_result = "cot(0) = "+inf;
                        text.setText(adv_result);
                        SaveData();
                    }
                    else {
                        double result = 1 / Math.tan(Math.toRadians(a));
                        adv_result = "cot("+a+") = "+String.format("%.3f",result);
                        text.setText(adv_result);
                        SaveData();
                    }

                } catch (Exception e) {
                    text.setText("Enter correctly");
                }
            }
        });
        sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double a = Double.parseDouble(edit.getText().toString());
                    if(a == 90.0)
                    {
                        adv_result = "sec(90) = "+inf;
                        text.setText(adv_result);
                        SaveData();
                    }
                    else {
                        double result = 1/  Math.cos(Math.toRadians(a));
                        adv_result = "sec("+a+") = "+String.format("%.3f",result);
                        text.setText(adv_result);
                        SaveData();
                    }

                } catch (Exception e) {
                    text.setText("Enter correctly");
                }
            }
        });
        cosec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double a = Double.parseDouble(edit.getText().toString());
                    if(a == 0.0)
                    {
                        adv_result = "cosec(0) = "+inf;
                        text.setText(adv_result);
                        SaveData();
                    }
                    else {
                        double result = 1 / Math.sin(Math.toRadians(a));
                        adv_result = "cosec("+a+") = "+String.format("%.3f",result);
                        text.setText(adv_result);
                        SaveData();
                    }

                } catch (Exception e) {
                    text.setText("Enter correctly");
                }
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double a = Double.parseDouble(edit.getText().toString());
                    double result = Math.log10(a);
                    adv_result = "log("+a+") = "+String.format("%.2f",result);
                    text.setText(adv_result);
                    SaveData();
                } catch (Exception e) {
                    text.setText("Enter correctly");
                }
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String c = edit.getText().toString();
                    edit.setText(c+"^");
                    len = c.length();
                } catch (Exception e) {
                    text.setText("Enter correctly");
                }
            }
        });

        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(edit.getText().toString());
                    int mul = 1;
                    for(int i = a; i >0; i--)
                    {
                        mul = mul* i;
                    }
                    adv_result = a + "! = "+mul;
                    text.setText(adv_result);
                    SaveData();
                } catch (Exception e) {
                    text.setText("Enter correctly");
                }
            }
        });
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double a = Double.parseDouble(edit.getText().toString());
                    double result = Math.sqrt(a);
                    adv_result = "root("+a+ ") = "+ String.format("%.2f",result);
                    text.setText(adv_result);
                    SaveData();
                } catch (Exception e) {
                    text.setText("Enter correctly");
                }
            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    String a = edit.getText().toString();
                    int l = a.length();
                    for(int i = len+1; i < l; i++)
                    {
                        x = x + Character.toString(a.charAt(i));
                    }
                    for(int j = 0; j<len; j++)
                    {
                        y = y + Character.toString(a.charAt(j));
                    }
                    int X = Integer.parseInt(x);
                    int Y = Integer.parseInt(y),mul = 1;
                    for(int i = 0; i<X;i++)
                    {
                        mul = mul * Y;
                    }
                    adv_result = y+"^"+x+" = "+ mul;
                    text.setText(adv_result);
                    len = 0;
                    x = "";
                    y = "";
                    SaveData();
                } catch (Exception e) {
                    text.setText("Enter correctly");
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.simple) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
        else if(item.getItemId() == R.id.advanced) {
            Intent i = new Intent(getApplicationContext(), Advanced.class);
            startActivity(i);
        }
        else if(item.getItemId() == R.id.History) {
            Intent i = new Intent(getApplicationContext(), History2.class);
            startActivity(i);
        }
        else if(item.getItemId() == R.id.Converter) {
            Intent i = new Intent(getApplicationContext(), Converter.class);
            startActivity(i);
        }

        return false;
    }

    private void SaveData() {
        String key = databaseReference.push().getKey();
        StoreResult storeResult = new StoreResult(adv_result);
        databaseReference.child(key).setValue(storeResult);
        Toast.makeText(getApplicationContext(),"Result Successfully Uploaded",Toast.LENGTH_SHORT).show();
    }
}