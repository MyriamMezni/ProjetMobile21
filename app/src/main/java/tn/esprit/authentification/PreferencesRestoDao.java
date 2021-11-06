package tn.esprit.authentification;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PreferencesRestoDao {


    @Insert
    void addHotel(PreferencesRestoEntity Preference);

    @Query("SELECT * from preferenceResto")
    List<PreferencesRestoEntity> ReadAll() ;

    @Query("UPDATE preference SET nomUser=(:nom) where nomUser==null")
    void Update(String nom);

}
