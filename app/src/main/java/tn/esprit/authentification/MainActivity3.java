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

public class MainActivity3 extends AppCompatActivity {

    private Button franceBT;
    private Button italieBT;
    private Button turquieBT;
    private Button espagneBT;
    private Button tuniseBT;
    private Button angleterreBT;
    private TextView nomtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
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
                        startActivity(new Intent(getApplicationContext(),ActivitySettings.class).putExtra("name",name));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.action_notification:
                        startActivity(new Intent(getApplicationContext(),ActivityNotification.class).putExtra("name",name));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });


        nomtv=findViewById(R.id.nomtv);
        nomtv.setText("User "+name);



        franceBT = (Button) findViewById(R.id.FranceBT);
        franceBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //openFranceActivity();
              //  String name=getIntent().getStringExtra("name");
             //   String id=getIntent().getStringExtra("id");
                startActivity(new Intent(MainActivity3.this,ActivityFranceHome.class).putExtra("name",name));

            }
        });

        turquieBT = (Button) findViewById(R.id.TurquieBT);
        turquieBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity3.this,ActivityTurquieHome.class).putExtra("name",name));

            }
        });

        italieBT = (Button) findViewById(R.id.ItalieBT);
        italieBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity3.this,ActivityItalieHome.class).putExtra("name",name));

            }
        });

        espagneBT = (Button) findViewById(R.id.EspagneBT);
        espagneBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity3.this,ActivityEspagneHome.class).putExtra("name",name));


            }
        });

        tuniseBT = (Button) findViewById(R.id.TunisieBT);
        tuniseBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity3.this,ActivityTunisieHome.class).putExtra("name",name));

            }
        });

        angleterreBT = (Button) findViewById(R.id.AngleterreBT);
        angleterreBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity3.this,ActivityAngleterreHome.class).putExtra("name",name));


            }
        });
    }

}