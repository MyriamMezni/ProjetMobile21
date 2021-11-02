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
    List<HotelEntity> ReadAllFrance() ;

    @Query("SELECT * from hotels where pays='Tunisie'")
    List<HotelEntity> ReadAllTunisie() ;

    @Query("SELECT * from hotels where pays='Angleterre'")
    List<HotelEntity> ReadAllAngleterre() ;

    @Query("SELECT * from hotels where pays='Italie'")
    List<HotelEntity> ReadAllItalie() ;

    @Query("SELECT * from hotels where pays='Espagne'")
    List<HotelEntity> ReadAllEspagne() ;

    @Query("SELECT * from hotels where pays='Turquie'")
    List<HotelEntity> ReadAllTurquie() ;


}
