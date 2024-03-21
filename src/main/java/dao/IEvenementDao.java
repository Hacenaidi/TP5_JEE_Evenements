package dao;
import java.util.List;
import metier.entities.Evenement;
public interface IEvenementDao {
public Evenement save(Evenement p);
public List<Evenement> EvenementParMC(String mc);
public Evenement getEvenement(Long id);
public Evenement updateEvenement(Evenement p);
public void deleteEvenement(Long id);
}