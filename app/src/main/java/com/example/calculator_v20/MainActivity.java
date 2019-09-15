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
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private double s = 0, a1, a2;
    private String previous = "", value,op,result;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Basic Calculator");

        databaseReference = FirebaseDatabase.getInstance().getReference("Basic Result");
        final TextView text = findViewById(R.id.Text);

        drawerLayout = findViewById(R.id.DrawerLayout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button zero = (Button)findViewById(R.id.btn0);
        Button one = (Button)findViewById(R.id.btn1);
        Button two = (Button)findViewById(R.id.btn2);
        Button three = (Button)findViewById(R.id.btn3);
        Button four = (Button)findViewById(R.id.btn4);
        Button five = (Button)findViewById(R.id.btn5);
        Button six = (Button)findViewById(R.id.btn6);
        Button seven = (Button)findViewById(R.id.btn7);
        Button eight = (Button)findViewById(R.id.btn8);
        Button nine = (Button)findViewById(R.id.btn9);
        Button plus = (Button)findViewById(R.id.btnPlus);
        Button minus = (Button)findViewById(R.id.btnMinus);
        Button multiply = (Button)findViewById(R.id.btnMultiply);
        Button divide = (Button)findViewById(R.id.btnDivide);
        Button equal = (Button)findViewById(R.id.btnEqual);
        Button clear = (Button)findViewById(R.id.btnClear);
        Button back = (Button)findViewById(R.id.btnBack);
        Button dot = (Button)findViewById(R.id.btnDot);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = "0";
                text.setText(previous + value);
                previous = previous + value;
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = "1";
                text.setText(previous + value);
                previous = previous + value;
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = "2";
                text.setText(previous + value);
                previous = previous + value;
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = "3";
                text.setText(previous + value);
                previous = previous + value;
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = "4";
                text.setText(previous + value);
                previous = previous + value;
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = "5";
                text.setText(previous + value);
                previous = previous + value;
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = "6";
                text.setText(previous + value);
                previous = previous + value;
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = "7";
                text.setText(previous + value);
                previous = previous + value;
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = "8";
                text.setText(previous + value);
                previous = previous + value;
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = "9";
                text.setText(previous + value);
                previous = previous + value;
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = ".";
                text.setText(previous + value);
                previous = previous + value;
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = "";
                previous = "";
                text.setText("");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String b = text.getText().toString();
                    int n1 = b.length();
                    b = b.substring(0, n1 - 1);
                    text.setText(b);
                } catch (Exception e) {
                    text.setText("");
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    op = "+";
                    a1 = Double.parseDouble(text.getText().toString());
                    text.setText(op);
                    previous = "";
                } catch (Exception e) {
                    text.setText(op);
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    op = "-";
                    a1 = Double.parseDouble(text.getText().toString());
                    text.setText(op);
                    previous = "";
                } catch (Exception e) {
                    text.setText(op);
                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    op = "*";
                    a1 = Double.parseDouble(text.getText().toString());
                    text.setText(op);
                    previous = "";
                } catch (Exception e) {
                    text.setText(op);
                }
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    op = "/";
                    a1 = Double.parseDouble(text.getText().toString());
                    text.setText(op);
                    previous = "";
                } catch (Exception e) {
                    text.setText(op);
                }
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    a2 = Double.parseDouble(text.getText().toString());
                    if (op == "+") {
                        s = a1 + a2;
                        if (s == (int) s) {
                            result = a1+" + "+a2+" = "+(int) s + "";
                            text.setText(result);
                            SaveData();
                        } else{
                            result = a1+" + "+a2+" = "+ String.format("%.2f",s);
                            text.setText(result);
                            SaveData();
                        }

                    } else if (op == "-") {
                        s = a1 - a2;
                        if (s == (int) s) {
                            result = a1+" - "+a2+" = "+(int) s + "";
                            text.setText(result);
                            SaveData();
                        } else{
                            result = a1+" - "+a2+" = "+String.format("%.2f",s);
                            text.setText(result);
                            SaveData();
                        }

                    } else if (op == "*") {
                        s = a1 * a2;
                        if (s == (int) s) {
                            result = a1+" * "+a2+" = "+(int) s + "";
                            text.setText(result);
                            SaveData();
                        } else{
                            result = a1+" * "+a2+" = "+String.format("%.2f",s);
                            text.setText(result);
                            SaveData();
                        }

                    } else if (op == "/") {
                        s = a1 / a2;
                        if (s == (int) s) {
                            result = a1+"/"+a2+" = "+(int) s + "";
                            text.setText(result);
                            SaveData();
                        } else{
                            result = a1+"/"+a2+" = "+String.format("%.2f",s);
                            text.setText(result);
                            SaveData();
                        }
                    }

                } catch (Exception e) {
                    text.setText("");
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
            Intent i = new Intent(getApplicationContext(), History.class);
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
        StoreResult storeResult = new StoreResult(result);
        databaseReference.child(key).setValue(storeResult);
        Toast.makeText(getApplicationContext(),"Result Successfully Uploaded",Toast.LENGTH_SHORT).show();
    }
}

