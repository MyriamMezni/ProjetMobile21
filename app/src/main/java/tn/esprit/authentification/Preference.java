package tn.esprit.authentification;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName="preference")
public class    Preference {
    @PrimaryKey(autoGenerate = true)
    Integer idPref;




    @ColumnInfo(name="nomHotel")
    String nomHotel;

    @ColumnInfo(name="nomUser")
    String nomUser;

    @ColumnInfo(name="adr")
    String adresse;

    @ColumnInfo(name="idHotel")
    Integer idHotel;


    @ColumnInfo(name="adresse")
     Integer idUser;

    public Integer getIdPref() {
        return idPref;
    }

    public void setIdPref(Integer idPref) {
        this.idPref = idPref;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Preference(String nomHotel, String nomUser, String adresse, Integer idHotel, Integer idUser) {
        this.nomHotel = nomHotel;
        this.nomUser = nomUser;
        this.adresse = adresse;
        this.idHotel = idHotel;
        this.idUser = idUser;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
