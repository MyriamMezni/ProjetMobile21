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

public class ActivityRestoFrance extends AppCompatActivity {
    private Button retourAngleterreBT;
    RecyclerView restorv;
    RestoAdapter restoAdapter;
    List<RestoEntity> restos=new ArrayList<>();
    private TextView nomtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto_france);
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
        nomtv=findViewById(R.id.nomtv17);
        nomtv.setText("User "+name);
        retourAngleterreBT = (Button) findViewById(R.id.RetourFranceBT);
        retourAngleterreBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRetourAngleterreActivity();
            }
        });






        //setupRestos();
        restos=UserDatabase.getUserDatabase(this).restoDao().ReadAllFrance();
        restorv=findViewById(R.id.hotelRecyclerView);
        restoAdapter=new RestoAdapter(restos,this);
        restorv.setAdapter(restoAdapter);
        restorv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));













    }

    private void openRetourAngleterreActivity()
    {
        String name=getIntent().getStringExtra("name");
        Intent intent = new Intent(this, ActivityFranceHome.class).putExtra("name",name);
        startActivity(intent);
    }



















    public void setupRestos()
    {

//Tunisie

        RestoEntity restaurant1=new RestoEntity("Barberousse beach club","Hammamet","Tunisie","Cuisine Méditerranéenne, Européenne","Ouvert lun-dim","115","4.5");
        RestoEntity restaurant2=new RestoEntity("Amici miei","Hammamet","Tunisie","Cuisine Italienne","Ouvert lun-dim","200","4");
        RestoEntity restaurant3=new RestoEntity("La Marmite","Sousse","Tunisie","Cuisine Tunisienne, Fruits de mer & Poisson, Méditerranéenne, Européenne","Ouvert lun-dim","150","4");
        RestoEntity restaurant4=new RestoEntity("La fontana","Tozeur","Tunisie","Cuisine Italienne, Méditerranéenne, Européenne, Tunisienne","Ouvert lun-dim","49","4.5");
        RestoEntity restaurant5=new RestoEntity("El Fondouk","Djerba","Tunisie","Cuisine Italienne, Française, Fruits de mer & Poisson, Internationale, Tunisienne","Ouvert lun-dim","43","3.5");

//Italie
        RestoEntity restaurant10=new RestoEntity("Pizzeria Stuzzicheria de Neri","Florence","Italie","Pizza, Restauration rapide","Ouvert lun-dim","16","5");
        RestoEntity restaurant20=new RestoEntity("Moci","Rome","Italie","Cuisine Chinoise, Japonaise","Ouvert lun-dim","100","4");
        RestoEntity restaurant30=new RestoEntity("Hostaria Pizzeria Hakuna Matata","Rome","Italie","Cuisine Italienne, Pizza, Grillades","Ouvert lun-dim","200","4.5");
        RestoEntity restaurant40=new RestoEntity("Panzarotti","Milan","Italie","Cuisine de rue(Street food)","50","5","3");
        RestoEntity restaurant50=new RestoEntity("Say Cheese Bistrot","Milan","Italie","Cuisine Italienne, Française, Américaine, Internationale, Bar à vins","Ouvert lun-dim","100","4.5");


//Torkya
        RestoEntity restaurant100=new RestoEntity("Mivan Restaurant Cafe","Istanbul","Turquie","Cuisine Méditerranéenne, Turque","Ouvert lun-dim","70","5");
        RestoEntity restaurant200=new RestoEntity("Roof Mezze 360","Istanbul","Turquie","Cuisine Turque, Moyen-Orient","Ouvert lun-dim","170","5");
        RestoEntity restaurant300=new RestoEntity("Seraser Fine Dining Restaurant","Antalya","Turquie","Cuisine Méditerranéenne, Européenne, Turque, Internationale","Ouvert lun-dim","50","4.5");
        RestoEntity restaurant400=new RestoEntity("Dinç Restaurant Cafe&Bar","Bodrum","Turquie","Cuisine Méditerranéenne, Européenne, Turque","80","5","4");
        RestoEntity restaurant500=new RestoEntity("Taksim Sütiş","Taksim","Turquie","Cuisine Turque","Ouvert lun-dim","100","4");

//Espagnaaa
        RestoEntity restaurant10000=new RestoEntity("Ándele París","Barcelone","Espagne","Cuisine Mexicaine, Latino, Street food","Ouvert lun-dim","100","5");
        RestoEntity restaurant20000=new RestoEntity("Más Que Sushi - Gran Via","Barcelone","Espagne","Cuisine Japonaise","Ouvert lun-dim","60","5");
        RestoEntity restaurant30000=new RestoEntity("Trattoria Pulcinella","Madrid","Espagne","Cuisine Italienne, Napolitaine","Ouvert lun-dim","100","4.5");
        RestoEntity restaurant40000=new RestoEntity("The Irish Temple","Madrid","Espagne","Cuisine Végétariens,sans gluten","80","4.5","3.5");
        RestoEntity restaurant50000=new RestoEntity("Gusto","Malaga","Espagne","Cuisine Espagnole","Ouvert lun-dim","70","4.5");

//Franca
        RestoEntity restaurant100000=new RestoEntity("Il Etait Un Square","Paris","France","Cuisine Française, Steakhouse, Européenne","Ouvert lun-dim","100","5");
        RestoEntity restaurant200000=new RestoEntity("Más Que Sushi - Gran Via","Toulouse","Cuisine Japonaise","Ouvert lun-dim","60","5","5");
        RestoEntity restaurant300000=new RestoEntity("La Véranda","Nice","France","Cuisine Chinoise, Asiatique, Thaï, Vietnamiennee","Ouvert lun-dim","90","5");
        RestoEntity restaurant400000=new RestoEntity("Suzzi","Bordeaux","France","Cuisine Suédoise, Scandinave","80","5","5");
        RestoEntity restaurant500000=new RestoEntity("Le Neuvième Art","Lyon","France","Cuisine Française","Ouvert lun-dim","550","5");

//Angeletrre
        RestoEntity restaurant1000000=new RestoEntity("temper Covent Garden","Londres","Angleterre","Steakhouse, Barbecue/Grillades","Ouvert lun-dim","160","4");
        RestoEntity restaurant2000000=new RestoEntity("Hibox","Londres","Angleterre","Cuisine Libanaise","Ouvert lun-dim","30","5");
        RestoEntity restaurant3000000=new RestoEntity("MyLahore Manchester","Manchester","Angleterre","Cuisine Asiatique, Britannique, Fusion","Ouvert lun-dim","90","5");
        RestoEntity restaurant4000000=new RestoEntity("Revolution Parsonage Gardens","Manchester","Angleterre","Cuisine Britannique","80","4.5","4");
        RestoEntity restaurant5000000=new RestoEntity("eastZeast","Ecosse","Angleterre","Cuisine Indienne, Asiatique, Saine, Balti, Grillades","Ouvert lun-dim","100","4.5");


        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
        final RestoDao restoDao = userDatabase.restoDao();

        restoDao.addHotel(restaurant1);
        restoDao.addHotel(restaurant2);
        restoDao.addHotel(restaurant3);
        restoDao.addHotel(restaurant4);
        restoDao.addHotel(restaurant5);
        restoDao.addHotel(restaurant10);
        restoDao.addHotel(restaurant100);
        restoDao.addHotel(restaurant10000);
        restoDao.addHotel(restaurant100000);
        restoDao.addHotel(restaurant1000000);
        restoDao.addHotel(restaurant20);
        restoDao.addHotel(restaurant200);
        restoDao.addHotel(restaurant20000);
        restoDao.addHotel(restaurant200000);
        restoDao.addHotel(restaurant2000000);

        restoDao.addHotel(restaurant30);
        restoDao.addHotel(restaurant300);
        restoDao.addHotel(restaurant30000);
        restoDao.addHotel(restaurant300000);
        restoDao.addHotel(restaurant3000000);


        restoDao.addHotel(restaurant40);
        restoDao.addHotel(restaurant400);
        restoDao.addHotel(restaurant40000);
        restoDao.addHotel(restaurant400000);
        restoDao.addHotel(restaurant4000000);


        restoDao.addHotel(restaurant50);
        restoDao.addHotel(restaurant500);
        restoDao.addHotel(restaurant50000);
        restoDao.addHotel(restaurant500000);
        restoDao.addHotel(restaurant5000000);
    }




}