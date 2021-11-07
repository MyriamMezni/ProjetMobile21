package tn.esprit.authentification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ActivityHotelTurquie extends AppCompatActivity {
    private Button retourTurquieBT;
    RecyclerView hotelrv;
    HotelAdapter hotelAdapter;
    List<HotelEntity> hotels=new ArrayList<>();
    private TextView nomtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_turquie);
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
        nomtv=findViewById(R.id.nomtv12);
        nomtv.setText("User "+name);
        retourTurquieBT = (Button) findViewById(R.id.RetourFranceBT);
        retourTurquieBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRetourTurquieActivity();
            }
        });






        //setupHotels();
        hotels=UserDatabase.getUserDatabase(this).hotelDao().ReadAllTurquie();
        hotelrv=findViewById(R.id.hotelRecyclerView);
        hotelAdapter=new HotelAdapter(hotels,this);
        hotelrv.setAdapter(hotelAdapter);
        hotelrv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));



    }

    private void openRetourTurquieActivity()
    {
        String name=getIntent().getStringExtra("name");
        Intent intent = new Intent(this, ActivityTurquieHome.class).putExtra("name",name);
        startActivity(intent);
    }
}