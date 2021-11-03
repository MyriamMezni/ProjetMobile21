package tn.esprit.authentification;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityAngleterreHome extends AppCompatActivity {

    private Button retourMainBT;
    private Button restaurantFranceBT;
    private Button hebergementFranceBT;
    private Button loisirFranceBT;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angleterre_home);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_profile);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.action_profile:
                        startActivity(new Intent(getApplicationContext(),ActivityProfile.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.action_settings:
                        startActivity(new Intent(getApplicationContext(),MainActivity3.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.action_notification:
                        startActivity(new Intent(getApplicationContext(),login.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });

        retourMainBT = (Button) findViewById(R.id.RetourMainBT);
        retourMainBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRetourMainActivity();
            }
        });

        hebergementFranceBT = (Button) findViewById(R.id.HebergementFranceBT);
        hebergementFranceBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ActivityAngleterreHome.this,ActivityHotelAngleterre.class));

            }
        });


        restaurantFranceBT = (Button) findViewById(R.id.RestaurantFranceBT);
        restaurantFranceBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ActivityAngleterreHome.this,ActivityRestoAngleterre.class));

            }
        });
    }

    private void openRetourMainActivity()
    {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);


    }
}