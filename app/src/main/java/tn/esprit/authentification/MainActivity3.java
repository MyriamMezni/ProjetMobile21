package tn.esprit.authentification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity3 extends AppCompatActivity {

    private Button franceBT;
    private Button italieBT;
    private Button turquieBT;
    private Button espagneBT;
    private Button tuniseBT;
    private Button angleterreBT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

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
                        startActivity(new Intent(getApplicationContext(),ActivitySettings.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.action_notification:
                        startActivity(new Intent(getApplicationContext(),ActivityNotification.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });


        franceBT = (Button) findViewById(R.id.FranceBT);
        franceBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //openFranceActivity();
                startActivity(new Intent(MainActivity3.this,ActivityFranceHome.class));

            }
        });

        turquieBT = (Button) findViewById(R.id.TurquieBT);
        turquieBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity3.this,ActivityTurquieHome.class));

            }
        });

        italieBT = (Button) findViewById(R.id.ItalieBT);
        italieBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity3.this,ActivityItalieHome.class));

            }
        });

        espagneBT = (Button) findViewById(R.id.EspagneBT);
        espagneBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity3.this,ActivityEspagneHome.class));


            }
        });

        tuniseBT = (Button) findViewById(R.id.TunisieBT);
        tuniseBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity3.this,ActivityTunisieHome.class));

            }
        });

        angleterreBT = (Button) findViewById(R.id.AngleterreBT);
        angleterreBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity3.this,ActivityAngleterreHome.class));


            }
        });
    }

}