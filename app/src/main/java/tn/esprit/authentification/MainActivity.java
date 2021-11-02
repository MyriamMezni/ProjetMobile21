package tn.esprit.authentification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText userName,email,password;
Button register,login;
List<HotelEntity> hotels=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //setupHotels();
        userName = findViewById(R.id.userName);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        register.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //Creation d'entité
                UserEntity userEntity = new UserEntity();
                userEntity.setName(userName.getText().toString());
                userEntity.setEmail(email.getText().toString());
                userEntity.setPassword(password.getText().toString());
                if (valideInput(userEntity)) {
                    //Operation insertion
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    final UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.registerUser(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "user enregistré", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(MainActivity.this, login.class));

                                }
                            });
                        }
                    }).start();
                } else {
                    Toast.makeText(getApplicationContext(), "veuillez renseigner les champs!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, login.class));
            }
        });

    }
    private boolean valideInput(UserEntity userEntity)
    {
        if(userEntity.getEmail().isEmpty()||userEntity.getPassword().isEmpty()||userEntity.getName().isEmpty())
        {return false;}
        return true;
    }


public void setupHotels()
{

//tounisss
    HotelEntity hotel1=new HotelEntity("La Badira","Hammamet","Complète","Tunisie","5","319","Équitation","Plongée sous-marine","Court de tennis","Centre d'affaires","9,5/10");
    HotelEntity hotel2=new HotelEntity("El mouradi","Yasmine Hammamet","Complète","Tunisie","4","145","Garderie d'enfants","Club de remise en forme","Salle de réunion","Climatisation","6,5/10");
    HotelEntity hotel3=new HotelEntity("La Ciagle","Tabarka","Complète","Tunisie","5","427","Bureau d'excursions","Plage privée","Minigolf","Cheminée extérieure","8.9/10");
    HotelEntity hotel4=new HotelEntity("Anantara","Tozeur","Complète","Tunisie","5","892","Cours de cuisine","Concerts/Spectacles ","Garde d'enfants","Bar dans la piscine","8.9/10");
    HotelEntity hotel5=new HotelEntity("Iberostar Selection Kuriat Palace","Monastir","Complète","Tunisie","5","228","Bingo","Service de change","Bibliothèque","Barrières de sécurité pour bébés","8.3/10");

//Italy
    HotelEntity hotel6=new HotelEntity("Four Seasons Hotel Firenze","Florence","Complète","Italie","5","2349","Concerts/Spectacles","Centre d'affaires","Jeux de plein air pour enfants","Coffre-fort","9.4/10");
    HotelEntity hotel7=new HotelEntity("The Pope's Window","Rome","Complète","Italie","4","440","Service d'étage","Navette aéroport","Sécurité 24h/24","Lit pliant","9.3/10");
    HotelEntity hotel8=new HotelEntity("Trevi Portrait","Rome","Complète","Italie","3","758","Vue sur la ville","Wi-Fi Gratuit","Navette aéroport","Coffre-fort","8/10");
    HotelEntity hotel9=new HotelEntity("Rosso Segnale Milano","Milan","Complète","Italie","4","333","Chambre anti-allergie","Boutique de souvenirs/cadeaux","Navette aéroport","Climatisation","9.4/10");
    HotelEntity hotel10=new HotelEntity("Hotel di Porta Romana","Milan","Complète","Italie","3","482","Bureau d'excursions","Animaux domestiques admis","Navette aéroport","Chauffage","7.6/10");


//Torkya
    HotelEntity hotel11=new HotelEntity("Blue Mosque Suites","Istanbul","Complète","Turquie","4","651","Cyclisme","Extincteurs","Navette aéroport","Coffre-fort","9.7/10");
    HotelEntity hotel12=new HotelEntity("Nova Plaza Crystal Hotel & Spa","Istanbul","Complète","Turquie","4","619","Spa et centre de bien-être","Wi-Fi Gratuit","Navette aéroport","Service d'étage","8.6/10");
    HotelEntity hotel13=new HotelEntity("Konak Hotel Kaleiçi","Antalya","Complète","Turquie","3","82","Bureau d'excursions","Service de change","Navette aéroport","Chambres familiales","8.5/10");
    HotelEntity hotel14=new HotelEntity("Roas Hotel","Bodrum","Complète","Turquie","3","282","piscine","Salon d'accueil VIP","Navette aéroport","Location de voitures","9.8/10");
    HotelEntity hotel15=new HotelEntity("Trevi Portrait","Taksim","Complète","Turquie","4","296","Centre de remise en forme","Wi-Fi Gratuit Partout","Navette aéroport","Détecteurs de fumée","8.2/10");

//Espagnaaa
    HotelEntity hotel16=new HotelEntity("Hostal Bcn 46","Barcelone","Complète","Espagne","2","500","Bagagerie","Fax/photocopies","Navette aéroport","Climatisation","7.7/10");
    HotelEntity hotel17=new HotelEntity("Vincci Bit","Barcelone","Complète","Espagne","4","619","Bar","Service de concierge","Navette aéroport","Parquet","8.5/10");
    HotelEntity hotel18=new HotelEntity("Madrid Binefar Aparment","Madrid","Complète","Espagne","3","377","Canapé Lit","Lave-linge","Navette aéroport","Climatisation","6.9/10");
    HotelEntity hotel19=new HotelEntity("Artrip Hotel","Madrid","Complète","Espagne","2","901","Service de réveil","Bureau d'excursions","Navette aéroport","Insonorisation","9.7/10");
    HotelEntity hotel20=new HotelEntity("Wonderful Malagueta Pompidou","Malaga","Complète","Espagne","4","286","Vue sur la mer","Extincteurs","Navette aéroport","Ascenseur","8.9/10");

//Franca
    HotelEntity hotel21=new HotelEntity("Hotel de l'Aqueduc","Paris","Complète","France","3","476","Bagagerie","Salles de réunions","Navette aéroport","Chauffage","7.3/10");
    HotelEntity hotel22=new HotelEntity("Hôtel Le Seize","Nice","Complète","France","3","187","Bureau d'excursions","Service de concierge","Navette aéroport","Climatisation","7.4/10");
    HotelEntity hotel23=new HotelEntity("Novotel Bordeaux Lac","Bordeaux","Complète","France","4","292","Bar","Service de concierge","Navette aéroport","Parquet","7.9/10");
    HotelEntity hotel24=new HotelEntity("ibis Styles Marseille Gare Saint-Charles","Marseille","Complète","France","3","278","Terrasse","Service de ménage quotidien","Navette aéroport","Ascenseur","7.9/10");
    HotelEntity hotel25=new HotelEntity("Campanile Lyon Centre Part-Dieu","Lyon","Complète","France","3","246","Bar","Parking sur place","Navette aéroport","Moquette","8/10");

//Angeletrre
    HotelEntity hotel26=new HotelEntity("Park Grand Paddington Court","Londres","Complète","Angleterre","4","644","Bureau d'excursions","Salles de réunions","Navette aéroport","Moquette","7.8/10");
    HotelEntity hotel27=new HotelEntity("Pestana Chelsea Bridge Hotel & Spa","Londres","Complète","Angleterre","4","721","Service de cireur","Service de ménage quotidien","Navette aéroport","Parquet","8.3/10");
    HotelEntity hotel28=new HotelEntity("ibis Styles Manchester Portland","Manchester","Complète","Angleterre","3","930","Bagagerie","Détecteurs de fumée","Navette aéroport","Moquette","8.1/10");
    HotelEntity hotel29=new HotelEntity("Jurys Inn Manchester City Centre","Manchester","Complète","Angleterre","4","1280","Bar","Service de change","Navette aéroport","Climatisation","8.7/10");
    HotelEntity hotel30=new HotelEntity("The Weigh Inn Hotel","Ecosse","Complète","Angleterre","3","215","Bar","Fax/photocopies","Navette aéroport","Chauffage","7.7/10");




    hotels.add(hotel1);
    hotels.add(hotel2);
    hotels.add(hotel3);
    hotels.add(hotel4);
    hotels.add(hotel5);
    hotels.add(hotel6);
    hotels.add(hotel7);
    hotels.add(hotel8);
    hotels.add(hotel9);
    hotels.add(hotel10);
    hotels.add(hotel11);
    hotels.add(hotel12);
    hotels.add(hotel13);
    hotels.add(hotel14);
    hotels.add(hotel15);
    hotels.add(hotel16);
    hotels.add(hotel17);
    hotels.add(hotel18);
    hotels.add(hotel19);
    hotels.add(hotel20);
    hotels.add(hotel21);
    hotels.add(hotel22);
    hotels.add(hotel23);
    hotels.add(hotel24);
    hotels.add(hotel25);
    hotels.add(hotel26);
    hotels.add(hotel27);
    hotels.add(hotel28);
    hotels.add(hotel29);
    hotels.add(hotel30);

}







}