package tn.esprit.authentification;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityItalieHome extends AppCompatActivity {

    private Button retourMainBT;
    private Button restaurantFranceBT;
    private Button hebergementFranceBT;
    private Button loisirFranceBT;
    private TextView nomtv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italie_home);
        String name=getIntent().getStringExtra("name");

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_profile);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.action_profile:
                        startActivity(new Intent(getApplicationContext(),preferenceHome.class).putExtra("name",name));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.action_settings:
                        startActivity(new Intent(getApplicationContext(),MainActivity3.class).putExtra("name",name));
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

        nomtv=findViewById(R.id.nomtv13);
        nomtv.setText("User "+name);
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

                startActivity(new Intent(ActivityItalieHome.this,ActivityHotelItalie.class).putExtra("name",name));

            }
        });

        restaurantFranceBT = (Button) findViewById(R.id.RestaurantFranceBT);
        restaurantFranceBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ActivityItalieHome.this,ActivityRestoItalie.class).putExtra("name",name));

            }
        });
    }

    private void openRetourMainActivity()
    {        String name=getIntent().getStringExtra("name");
        Intent intent = new Intent(this, MainActivity3.class).putExtra("name",name);
        startActivity(intent);
    }
}