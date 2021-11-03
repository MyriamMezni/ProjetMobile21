package tn.esprit.authentification;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="resto")
public class RestoEntity {

    @PrimaryKey(autoGenerate = true)
    Integer idResto;
    @ColumnInfo(name="nomResto")
    String nomResto;

    @ColumnInfo(name="adresse")
    String adresse;

    @ColumnInfo(name="pays")
    String pays;

    @ColumnInfo(name="cuisine")
    String cuisine;

    @ColumnInfo(name="ouvert")
    String ouvert;


    @ColumnInfo(name="budget")
    String budget;

    @ColumnInfo(name="note")
    String note;

    public Integer getIdResto() {
        return idResto;
    }

    public void setIdResto(Integer idResto) {
        this.idResto = idResto;
    }

    public String getNomResto() {
        return nomResto;
    }

    public void setNomResto(String nomResto) {
        this.nomResto = nomResto;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getOuvert() {
        return ouvert;
    }

    public void setOuvert(String ouvert) {
        this.ouvert = ouvert;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public RestoEntity(String nomResto, String adresse, String pays, String cuisine, String ouvert, String budget, String note) {
        this.nomResto = nomResto;
        this.adresse = adresse;
        this.pays = pays;
        this.cuisine = cuisine;
        this.ouvert = ouvert;
        this.budget = budget;
        this.note = note;
    }
}
