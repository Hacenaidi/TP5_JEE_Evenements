package metier.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Evenement implements Serializable{
@Id
@Column (name="ID_EVENEMENT")
@GeneratedValue (strategy=GenerationType.IDENTITY)
//pour autoincrement
private Long idEvenement;
@Column (name="NOM_EVENEMENT")
private String nomEvenement;
@Column (name="DATE_EVENEMENT")
private  String DateEvenement;
public Evenement() {
super();
}
public Evenement(String nomEvenement, String DateEvenement) {
super();
this.nomEvenement = nomEvenement;
this.DateEvenement = DateEvenement;
}
public Long getIdEvenement() {
return idEvenement;
}
public void setIdEvenement(Long idEvenement) {
this.idEvenement = idEvenement;
}
public String getNomEvenement() {
return nomEvenement;
}
public void setNomEvenement(String nomEvenement) {
this.nomEvenement = nomEvenement;
}
public String getDateEvenement() {
return DateEvenement;
}
public void setDateEvenement(String DateEvenement) {
this.DateEvenement = DateEvenement;
}


}