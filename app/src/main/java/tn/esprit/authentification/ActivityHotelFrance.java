package tn.esprit.authentification;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ActivityHotelFrance extends AppCompatActivity {

    private Button retourFranceBT;
    RecyclerView hotelrv;
    HotelAdapter hotelAdapter;
    List<HotelEntity> hotels=new ArrayList<>();
    private TextView nomtv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_france);
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
        nomtv=findViewById(R.id.nomtv9);
        nomtv.setText("User "+name);
        retourFranceBT = (Button) findViewById(R.id.RetourFranceBT);
        retourFranceBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRetourFranceActivity();
            }
        });






       setupHotels();
        hotels=UserDatabase.getUserDatabase(this).hotelDao().ReadAllFrance();
        hotelrv=findViewById(R.id.hotelRecyclerView);
        hotelAdapter=new HotelAdapter(hotels,this);
        hotelrv.setAdapter(hotelAdapter);
        hotelrv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));




    }

    private void openRetourFranceActivity()
    {
        String name=getIntent().getStringExtra("name");
        Intent intent = new Intent(this, ActivityFranceHome.class).putExtra("name",name);
        startActivity(intent);
    }



    public void setupHotels()
    {

//tounisss
        HotelEntity hotel1=new HotelEntity("La Badira","Hammamet","Compl??te","Tunisie","5","319","??quitation","Plong??e sous-marine","Court de tennis","Centre d'affaires","9,5/10");
        HotelEntity hotel2=new HotelEntity("El mouradi","Yasmine Hammamet","Compl??te","Tunisie","4","145","Garderie d'enfants","Club de remise en forme","Salle de r??union","Climatisation","6,5/10");
        HotelEntity hotel3=new HotelEntity("La Ciagle","Tabarka","Compl??te","Tunisie","5","427","Bureau d'excursions","Plage priv??e","Minigolf","Chemin??e ext??rieure","8.9/10");
        HotelEntity hotel4=new HotelEntity("Anantara","Tozeur","Compl??te","Tunisie","5","892","Cours de cuisine","Concerts/Spectacles ","Garde d'enfants","Bar dans la piscine","8.9/10");
        HotelEntity hotel5=new HotelEntity("Iberostar Selection Kuriat Palace","Monastir","Compl??te","Tunisie","5","228","Bingo","Service de change","Biblioth??que","Barri??res de s??curit?? pour b??b??s","8.3/10");

//Italy
        HotelEntity hotel6=new HotelEntity("Four Seasons Hotel Firenze","Florence","Compl??te","Italie","5","2349","Concerts/Spectacles","Centre d'affaires","Jeux de plein air pour enfants","Coffre-fort","9.4/10");
        HotelEntity hotel7=new HotelEntity("The Pope's Window","Rome","Compl??te","Italie","4","440","Service d'??tage","Navette a??roport","S??curit?? 24h/24","Lit pliant","9.3/10");
        HotelEntity hotel8=new HotelEntity("Trevi Portrait","Rome","Compl??te","Italie","3","758","Vue sur la ville","Wi-Fi Gratuit","Navette a??roport","Coffre-fort","8/10");
        HotelEntity hotel9=new HotelEntity("Rosso Segnale Milano","Milan","Compl??te","Italie","4","333","Chambre anti-allergie","Boutique de souvenirs/cadeaux","Navette a??roport","Climatisation","9.4/10");
        HotelEntity hotel10=new HotelEntity("Hotel di Porta Romana","Milan","Compl??te","Italie","3","482","Bureau d'excursions","Animaux domestiques admis","Navette a??roport","Chauffage","7.6/10");


//Torkya
        HotelEntity hotel11=new HotelEntity("Blue Mosque Suites","Istanbul","Compl??te","Turquie","4","651","Cyclisme","Extincteurs","Navette a??roport","Coffre-fort","9.7/10");
        HotelEntity hotel12=new HotelEntity("Nova Plaza Crystal Hotel & Spa","Istanbul","Compl??te","Turquie","4","619","Spa et centre de bien-??tre","Wi-Fi Gratuit","Navette a??roport","Service d'??tage","8.6/10");
        HotelEntity hotel13=new HotelEntity("Konak Hotel Kalei??i","Antalya","Compl??te","Turquie","3","82","Bureau d'excursions","Service de change","Navette a??roport","Chambres familiales","8.5/10");
        HotelEntity hotel14=new HotelEntity("Roas Hotel","Bodrum","Compl??te","Turquie","3","282","piscine","Salon d'accueil VIP","Navette a??roport","Location de voitures","9.8/10");
        HotelEntity hotel15=new HotelEntity("Trevi Portrait","Taksim","Compl??te","Turquie","4","296","Centre de remise en forme","Wi-Fi Gratuit Partout","Navette a??roport","D??tecteurs de fum??e","8.2/10");

//Espagnaaa
        HotelEntity hotel16=new HotelEntity("Hostal Bcn 46","Barcelone","Compl??te","Espagne","2","500","Bagagerie","Fax/photocopies","Navette a??roport","Climatisation","7.7/10");
        HotelEntity hotel17=new HotelEntity("Vincci Bit","Barcelone","Compl??te","Espagne","4","619","Bar","Service de concierge","Navette a??roport","Parquet","8.5/10");
        HotelEntity hotel18=new HotelEntity("Madrid Binefar Aparment","Madrid","Compl??te","Espagne","3","377","Canap?? Lit","Lave-linge","Navette a??roport","Climatisation","6.9/10");
        HotelEntity hotel19=new HotelEntity("Artrip Hotel","Madrid","Compl??te","Espagne","2","901","Service de r??veil","Bureau d'excursions","Navette a??roport","Insonorisation","9.7/10");
        HotelEntity hotel20=new HotelEntity("Wonderful Malagueta Pompidou","Malaga","Compl??te","Espagne","4","286","Vue sur la mer","Extincteurs","Navette a??roport","Ascenseur","8.9/10");

//Franca
        HotelEntity hotel21=new HotelEntity("Hotel de l'Aqueduc","Paris","Compl??te","France","3","476","Bagagerie","Salles de r??unions","Navette a??roport","Chauffage","7.3/10");
        HotelEntity hotel22=new HotelEntity("H??tel Le Seize","Nice","Compl??te","France","3","187","Bureau d'excursions","Service de concierge","Navette a??roport","Climatisation","7.4/10");
        HotelEntity hotel23=new HotelEntity("Novotel Bordeaux Lac","Bordeaux","Compl??te","France","4","292","Bar","Service de concierge","Navette a??roport","Parquet","7.9/10");
        HotelEntity hotel24=new HotelEntity("ibis Styles Marseille Gare Saint-Charles","Marseille","Compl??te","France","3","278","Terrasse","Service de m??nage quotidien","Navette a??roport","Ascenseur","7.9/10");
        HotelEntity hotel25=new HotelEntity("Campanile Lyon Centre Part-Dieu","Lyon","Compl??te","France","3","246","Bar","Parking sur place","Navette a??roport","Moquette","8/10");

//Angeletrre
        HotelEntity hotel26=new HotelEntity("Park Grand PaddHotelington Court","Londres","Compl??te","Angleterre","4","644","Bureau d'excursions","Salles de r??unions","Navette a??roport","Moquette","7.8/10");
        HotelEntity hotel27=new HotelEntity("Pestana Chelsea Bridge Hotel & Spa","Londres","Compl??te","Angleterre","4","721","Service de cireur","Service de m??nage quotidien","Navette a??roport","Parquet","8.3/10");
        HotelEntity hotel28=new HotelEntity("ibis Styles Manchester Portland","Manchester","Compl??te","Angleterre","3","930","Bagagerie","D??tecteurs de fum??e","Navette a??roport","Moquette","8.1/10");
        HotelEntity hotel29=new HotelEntity("Jurys Inn Manchester City Centre","Manchester","Compl??te","Angleterre","4","1280","Bar","Service de change","Navette a??roport","Climatisation","8.7/10");
        HotelEntity hotel30=new HotelEntity("The Weigh Inn Hotel","Ecosse","Compl??te","Angleterre","3","215","Bar","Fax/photocopies","Navette a??roport","Chauffage","7.7/10");



        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
        final HotelDao hotelDao = userDatabase.hotelDao();

        hotelDao.addHotel(hotel1);
        hotelDao.addHotel(hotel2);
        hotelDao.addHotel(hotel3);
        hotelDao.addHotel(hotel4);
        hotelDao.addHotel(hotel5);
        hotelDao.addHotel(hotel6);
        hotelDao.addHotel(hotel7);
        hotelDao.addHotel(hotel8);
        hotelDao.addHotel(hotel9);
        hotelDao.addHotel(hotel10);
        hotelDao.addHotel(hotel11);
        hotelDao.addHotel(hotel12);
        hotelDao.addHotel(hotel13);
        hotelDao.addHotel(hotel14);
        hotelDao.addHotel(hotel15);
        hotelDao.addHotel(hotel16);
        hotelDao.addHotel(hotel17);
        hotelDao.addHotel(hotel18);
        hotelDao.addHotel(hotel19);
        hotelDao.addHotel(hotel20);
        hotelDao.addHotel(hotel21);
        hotelDao.addHotel(hotel22);
        hotelDao.addHotel(hotel23);
        hotelDao.addHotel(hotel24);
        hotelDao.addHotel(hotel25);
        hotelDao.addHotel(hotel26);
        hotelDao.addHotel(hotel27);
        hotelDao.addHotel(hotel28);
        hotelDao.addHotel(hotel29);
        hotelDao.addHotel(hotel30);




    }













}