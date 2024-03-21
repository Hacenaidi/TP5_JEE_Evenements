package web;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Evenement;
public class EvenementModele {
private String motCle;
List<Evenement> evenements = new ArrayList<>();
public String getMotCle() {
return motCle;
}
public void setMotCle(String motCle) {
this.motCle = motCle;
}
public List<Evenement> getEvenements() {
return evenements;
}
public void setEvenements(List<Evenement> Evenements) {
this.evenements = Evenements;
}

}