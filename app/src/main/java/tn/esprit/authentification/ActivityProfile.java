package tn.esprit.authentification;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ActivityProfile extends AppCompatActivity {

    private Button retourMainBT;
    RecyclerView prefrv;
    PreferenceAdapter prefAdapter;
    List<Preference> prefs=new ArrayList<>();
    private TextView nomtv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
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
                        startActivity(new Intent(getApplicationContext(),login.class).putExtra("name",name));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });

        nomtv=findViewById(R.id.nomtv7);
        nomtv.setText("User "+name);

        retourMainBT = (Button) findViewById(R.id.RetourMainBT);
        retourMainBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRetourMainActivity();
            }
        });









        prefs=UserDatabase.getUserDatabase(this).preferenceDao().ReadAll();
        prefrv=findViewById(R.id.hotelRecyclerView);
        prefAdapter=new PreferenceAdapter(prefs,this);
        prefrv.setAdapter(prefAdapter);
        prefrv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));



    }

    private void openRetourMainActivity()
    {
        String name=getIntent().getStringExtra("name");
        Intent intent = new Intent(this, MainActivity.class).putExtra("name",name);
        startActivity(intent);
    }
}