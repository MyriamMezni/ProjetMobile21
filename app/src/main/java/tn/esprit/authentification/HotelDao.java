package tn.esprit.authentification;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public  interface HotelDao {

    @Insert
    void addHotel(HotelEntity HotelEntity);

    @Query("SELECT * from hotels where pays='France'")
    List<HotelEntity> ReadAll() ;


}
