package tn.esprit.authentification;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName="preferenceResto")
public class PreferencesRestoEntity {
    @PrimaryKey(autoGenerate = true)
    Integer idPref;


    @ColumnInfo(name="nomResto")
    String nomResto;
    @ColumnInfo(name="adr")
    String adresse;


    @ColumnInfo(name="nomUser")
    String nomUser;


    @ColumnInfo(name="idResto")
    Integer idResto;

    @ColumnInfo(name="idUser")
    Integer idUser;


    public Integer getIdPref() {
        return idPref;
    }

    public void setIdPref(Integer idPref) {
        this.idPref = idPref;
    }

    public String getNomResto() {
        return nomResto;
    }

    public void setNomResto(String nomResto) {
        this.nomResto = nomResto;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public Integer getIdResto() {
        return idResto;
    }

    public void setIdResto(Integer idResto) {
        this.idResto = idResto;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }


    public PreferencesRestoEntity(String nomResto, String adresse, String nomUser, Integer idResto, Integer idUser) {
        this.nomResto = nomResto;
        this.adresse = adresse;
        this.nomUser = nomUser;
        this.idResto = idResto;
        this.idUser = idUser;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
