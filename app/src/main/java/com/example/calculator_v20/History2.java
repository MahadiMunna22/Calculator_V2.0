package com.example.calculator_v20;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class History2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listView;
    DatabaseReference databaseReference;
    private List<StoreResult> resultList;
    private CustomAdapter customAdapter;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history2);
        setTitle("Advanced History");

        databaseReference = FirebaseDatabase.getInstance().getReference("Advanced Result");
        resultList = new ArrayList<>();

        customAdapter = new CustomAdapter(History2.this, resultList);

        listView = findViewById(R.id.listViewId);

        drawerLayout = findViewById(R.id.DrawerLayout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                resultList.clear();
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    StoreResult storeResult = dataSnapshot1.getValue(StoreResult.class) ;
                    resultList.add(storeResult);
                }
                listView.setAdapter(customAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        super.onStart();
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
}
