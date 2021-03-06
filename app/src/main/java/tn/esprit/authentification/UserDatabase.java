package tn.esprit.authentification;

import android.content.Context;
import android.service.autofill.UserData;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities={UserEntity.class,HotelEntity.class,RestoEntity.class,Preference.class,PreferencesRestoEntity.class,reservationrestaurant.class},version =11)
public abstract class UserDatabase extends RoomDatabase {
    private static final String dbName="user";
    private static UserDatabase userDatabase;
    public static synchronized UserDatabase getUserDatabase(Context context){
        if (userDatabase==null){
            userDatabase= Room.databaseBuilder(context,UserDatabase.class,dbName).fallbackToDestructiveMigration().allowMainThreadQueries().build();

        }
        return userDatabase;
    }

    public abstract UserDao userDao();
    public abstract HotelDao hotelDao();
    public abstract RestoDao restoDao();
    public abstract PreferenceDao preferenceDao();
    public abstract PreferencesRestoDao preferencesRestoDao();
    public abstract reservationrestaurantDao reservationrestaurantDao();

}
