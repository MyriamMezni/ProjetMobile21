package tn.esprit.authentification;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PreferenceDao {


    @Insert
    void addHotel(Preference Preference);

    @Query("SELECT * from preference")
    List<Preference> ReadAll() ;

    @Query("UPDATE preference SET nomUser=(:nom) where nomUser==null")
    void Update(String nom);

}
