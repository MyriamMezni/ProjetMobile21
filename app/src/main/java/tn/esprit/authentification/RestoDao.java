package tn.esprit.authentification;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RestoDao {


    @Insert
    void addHotel(RestoEntity RestoEntity);

    @Query("SELECT * from resto where pays='France'")
    List<RestoEntity> ReadAllFrance() ;

    @Query("SELECT * from resto where pays='Tunisie'")
    List<RestoEntity> ReadAllTunisie() ;

    @Query("SELECT * from resto where pays='Angleterre'")
    List<RestoEntity> ReadAllAngleterre() ;

    @Query("SELECT * from resto where pays='Italie'")
    List<RestoEntity> ReadAllItalie() ;

    @Query("SELECT * from resto where pays='Espagne'")
    List<RestoEntity> ReadAllEspagne() ;

    @Query("SELECT * from resto where pays='Turquie'")
    List<RestoEntity> ReadAllTurquie() ;


}
