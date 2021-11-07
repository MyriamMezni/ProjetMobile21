package tn.esprit.authentification;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface reservationrestaurantDao {

    @Insert
    void addReservation(reservationrestaurant reservationrestaurant);

    @Query("SELECT * from reservationrestaurant")
    List<reservationrestaurant> ReadAll() ;
}
