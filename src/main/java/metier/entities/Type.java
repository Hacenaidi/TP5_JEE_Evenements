package metier.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity 
public class Type implements Serializable {
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY) 
private Long idType;
private String nomType;
@Temporal( TemporalType.DATE )
private Date dateCreation;
@OneToMany (mappedBy="type")  
 private List<Evenement> evenements;
public Type() {
super();
}
public Type(String nomType, Date dateCreation) {
super();
this.nomType = nomType;
this.dateCreation = dateCreation;
}
public Long getIdType() {
return idType;
}
public void setIdType(Long idCat) {
this.idType = idType;
}
public String getNomType() {
return nomType;
}
public void setNomType(String nomType) {
this.nomType = nomType;
}
public Date getDateCreation() {
return dateCreation;
}
public void setDateCreation(Date dateCreation) {
this.dateCreation = dateCreation;
}
public List<Evenement> getEvenements() {
return evenements;
}
public void setEvenemnts(List<Evenement> evenements) {
this.evenements = evenements;
}
}