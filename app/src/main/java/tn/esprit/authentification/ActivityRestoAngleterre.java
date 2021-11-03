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

public class ActivityRestoAngleterre extends AppCompatActivity {

    private Button retourAngleterreBT;
    RecyclerView restorv;
    RestoAdapter restoAdapter;
    List<RestoEntity> restos=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto_angleterre2);








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

        retourAngleterreBT = (Button) findViewById(R.id.RetourFranceBT);
        retourAngleterreBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRetourAngleterreActivity();
            }
        });






        //setupHotels();
        restos=UserDatabase.getUserDatabase(this).restoDao().ReadAllAngleterre();
        restorv=findViewById(R.id.hotelRecyclerView);
        restoAdapter=new RestoAdapter(restos,this);
        restorv.setAdapter(restoAdapter);
        restorv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));













    }

    private void openRetourAngleterreActivity()
    {
        Intent intent = new Intent(this, ActivityAngleterreHome.class);
        startActivity(intent);
    }
}