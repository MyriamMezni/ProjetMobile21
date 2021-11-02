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

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ActivityHotelItalie extends AppCompatActivity {
    private Button retourItalieBT;
    RecyclerView hotelrv;
    HotelAdapter hotelAdapter;
    List<HotelEntity> hotels=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_italie);



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

        retourItalieBT = (Button) findViewById(R.id.RetourFranceBT);
        retourItalieBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRetourItalieActivity();
            }
        });






        //setupHotels();
        hotels=UserDatabase.getUserDatabase(this).hotelDao().ReadAllItalie();
        hotelrv=findViewById(R.id.hotelRecyclerView);
        hotelAdapter=new HotelAdapter(hotels,this);
        hotelrv.setAdapter(hotelAdapter);
        hotelrv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));



    }

    private void openRetourItalieActivity()
    {
        Intent intent = new Intent(this, ActivityItalieHome.class);
        startActivity(intent);
    }
}