package tn.esprit.authentification;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="hotels")
public class HotelEntity {
    @PrimaryKey(autoGenerate = true)
    Integer idHotel;
    @ColumnInfo(name="nomHotel")
    String nomHotel;

    @ColumnInfo(name="adresse")
    String adresse;

    @ColumnInfo(name="pension")
    String pension;

    @ColumnInfo(name="pays")
    String pays;

    @ColumnInfo(name="nbEtoile")
    String nbEtoile;

    @ColumnInfo(name="prix")
    String prix;

    @ColumnInfo(name="service1")
    String service1;

    @ColumnInfo(name="service2")
    String service2;

    @ColumnInfo(name="service3")
    String service3;

    @ColumnInfo(name="equipements")
    String equipements;

    @ColumnInfo(name="note")
    String note;

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPension() {
        return pension;
    }

    public void setPension(String pension) {
        this.pension = pension;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getNbEtoile() {
        return nbEtoile;
    }

    public void setNbEtoile(String nbEtoile) {
        this.nbEtoile = nbEtoile;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }



    public String getEquipements() {
        return equipements;
    }

    public void setEquipements(String equipements) {
        this.equipements = equipements;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getService1() {
        return service1;
    }

    public void setService1(String service1) {
        this.service1 = service1;
    }

    public String getService2() {
        return service2;
    }

    public void setService2(String service2) {
        this.service2 = service2;
    }

    public String getService3() {
        return service3;
    }

    public void setService3(String service3) {
        this.service3 = service3;
    }

    public HotelEntity(String nomHotel, String adresse, String pension, String pays, String nbEtoile, String prix, String service1, String service2, String service3, String equipements, String note) {
        this.nomHotel = nomHotel;
        this.adresse = adresse;
        this.pension = pension;
        this.pays = pays;
        this.nbEtoile = nbEtoile;
        this.prix = prix;
        this.service1 = service1;
        this.service2 = service2;
        this.service3 = service3;
        this.equipements = equipements;
        this.note = note;
    }
}
