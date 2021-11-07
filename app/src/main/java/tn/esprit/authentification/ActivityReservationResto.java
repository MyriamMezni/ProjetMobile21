package tn.esprit.authentification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityReservationResto extends AppCompatActivity {


    private Button button;
    private Spinner sp1,sp2,sp3;
    private TextView tv1;
    private TextView tv2;
    private TextView nomtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_resto);
        String name=getIntent().getStringExtra("name");






        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_profile);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.action_profile:
                        startActivity(new Intent(getApplicationContext(),preferenceHome.class));
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


        nomtv=findViewById(R.id.nomtv5);
        //nomtv.setText("User "+" ");





        String nomReso=getIntent().getStringExtra("nomReso");
        String adresse=getIntent().getStringExtra("adresse");


        System.out.println(nomReso.toString());

        final TextView tv = (TextView) findViewById(R.id.nameresto);
        tv.setText(nomReso);

        final TextView tv2 = (TextView) findViewById(R.id.adressee);
        tv2.setText(adresse);



        final Spinner spinnerRegion3 = (Spinner) findViewById(R.id.spinnerRegion3);
        String[] lRegion3={"2 personnes","3 personnes","4 personnes","5 personnes"};
        ArrayAdapter<String> dataAdapterR3= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,lRegion3);
        dataAdapterR3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRegion3.setAdapter(dataAdapterR3);







        final Spinner spinnerRegion = (Spinner) findViewById(R.id.spinnerRegion);
        String[] lRegion={"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
        ArrayAdapter<String> dataAdapterR = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,lRegion);
        dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRegion.setAdapter(dataAdapterR);




        final Spinner spinnerRegion2 = (Spinner) findViewById(R.id.spinnerRegion2);
        String[] lRegion2={"15H","16H","17H","18H","19H","20H","21H","22H"};
        ArrayAdapter<String> dataAdapterR2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,lRegion2);
        dataAdapterR2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRegion2.setAdapter(dataAdapterR2);




    button=findViewById(R.id.button);
    sp1=findViewById(R.id.spinnerRegion);
    sp2=findViewById(R.id.spinnerRegion2);
    sp2=findViewById(R.id.spinnerRegion3);
    tv1=findViewById(R.id.nameresto);









                button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              String myRegion1 = ""+String.valueOf(spinnerRegion.getSelectedItem().toString());
              String myRegion2 =""+String.valueOf(spinnerRegion2.getSelectedItem()).toString();
              String myRegion3 =""+ String.valueOf(spinnerRegion3.getSelectedItem()).toString();

                UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                final reservationrestaurantDao PreferenceDao = userDatabase.reservationrestaurantDao();


                 reservationrestaurant p=new reservationrestaurant(nomReso,adresse,"",(String)myRegion1,(String)myRegion2,(String)myRegion3);
                 PreferenceDao.addReservation(p);
                 Toast.makeText(getApplicationContext(), "Réservation effectuée ", Toast.LENGTH_SHORT).show();


            }
        });






    }


}