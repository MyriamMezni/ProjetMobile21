package tn.esprit.authentification;

import android.content.Context;
import android.service.autofill.UserData;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities={UserEntity.class,HotelEntity.class},version =3)
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

}
