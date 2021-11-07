package tn.esprit.authentification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class preferenceHome extends AppCompatActivity {
Button prefHotel,prefResto,reservation;
    private TextView nomtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_home);



        String name=getIntent().getStringExtra("name");






        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_profile);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.action_profile:
                        startActivity(new Intent(getApplicationContext(),Activity_AllPreference.class).putExtra("name",name));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.action_settings:
                        startActivity(new Intent(getApplicationContext(),MainActivity3.class).putExtra("name",name));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.action_notification:
                        startActivity(new Intent(getApplicationContext(),login.class).putExtra("name",name));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });
        nomtv=findViewById(R.id.nomtv24);
        nomtv.setText("User "+name);


        prefHotel = (Button) findViewById(R.id.prefHotel);
        prefResto = (Button) findViewById(R.id.prefResto);
        reservation = (Button) findViewById(R.id.reservation);




        prefHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(preferenceHome.this,Activity_AllPreference.class).putExtra("name",name));

            }
        });





        prefResto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(preferenceHome.this,preferencesReso.class).putExtra("name",name));

            }
        });






        reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(preferenceHome.this,preferencereservation.class).putExtra("name",name));

            }
        });

    }
}