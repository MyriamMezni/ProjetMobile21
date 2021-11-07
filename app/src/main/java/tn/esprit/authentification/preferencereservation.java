package tn.esprit.authentification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class preferencereservation extends AppCompatActivity {
    private TextView nomtv;
    RecyclerView prefrv;
    ReservationRestoAdapter prefAdapter;
    List<reservationrestaurant> prefs = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencereservation);
        String name = getIntent().getStringExtra("name");







        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_profile);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_profile:
                        startActivity(new Intent(getApplicationContext(), preferenceHome.class).putExtra("name", name));
                        finish();
                        overridePendingTransition(0, 0);
                        return;
                    case R.id.action_settings:
                        startActivity(new Intent(getApplicationContext(), MainActivity3.class).putExtra("name", name));
                        finish();
                        overridePendingTransition(0, 0);
                        return;
                    case R.id.action_notification:
                        startActivity(new Intent(getApplicationContext(), login.class).putExtra("name", name));
                        finish();
                        overridePendingTransition(0, 0);
                        return;
                }
            }
        });


        nomtv = findViewById(R.id.nomtv25);
        nomtv.setText("User " + name);



        prefs = UserDatabase.getUserDatabase(this).reservationrestaurantDao().ReadAll();
        prefrv = findViewById(R.id.hotelRecyclerView);
        prefAdapter = new ReservationRestoAdapter(prefs, this);
        prefrv.setAdapter(prefAdapter);
        prefrv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));



    }
}