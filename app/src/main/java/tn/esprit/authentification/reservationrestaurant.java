package tn.esprit.authentification;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "reservationrestaurant")
public class reservationrestaurant {


    @PrimaryKey(autoGenerate = true)
    Integer idReservationRestaurant;


    @ColumnInfo(name = "nomRestoReservation")
    String nomRestoReservation;
    @ColumnInfo(name = "adresse")
    String adresse;


    @ColumnInfo(name = "nomUserRestaurant")
    String nomUserRestaurant;

    @ColumnInfo(name = "nbPersonne")
    String nbPersonne;


    @ColumnInfo(name = "jour")
    String jour;

    @ColumnInfo(name = "heurerepas")
    String heurerepas;

    public reservationrestaurant() {
    }

    public reservationrestaurant(String nomRestoReservation, String adresse, String nomUserRestaurant, String nbPersonne, String jour, String heurerepas) {
        this.nomRestoReservation = nomRestoReservation;
        this.adresse = adresse;
        this.nomUserRestaurant = nomUserRestaurant;
        this.nbPersonne = nbPersonne;
        this.jour = jour;
        this.heurerepas = heurerepas;
    }

    public Integer getIdReservationRestaurant() {
        return idReservationRestaurant;
    }

    public void setIdReservationRestaurant(Integer idReservationRestaurant) {
        this.idReservationRestaurant = idReservationRestaurant;
    }

    public String getNomRestoReservation() {
        return nomRestoReservation;
    }

    public void setNomRestoReservation(String nomRestoReservation) {
        this.nomRestoReservation = nomRestoReservation;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNomUserRestaurant() {
        return nomUserRestaurant;
    }

    public void setNomUserRestaurant(String nomUserRestaurant) {
        this.nomUserRestaurant = nomUserRestaurant;
    }

    public String getNbPersonne() {
        return nbPersonne;
    }

    public void setNbPersonne(String nbPersonne) {
        this.nbPersonne = nbPersonne;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getHeurerepas() {
        return heurerepas;
    }

    public void setHeurerepas(String heurerepas) {
        this.heurerepas = heurerepas;
    }
}
