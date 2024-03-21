package dao;
import java.util.List;
import metier.entities.Evenement;
public class TestDao {
public static void main(String[] args) {
EvenementDaoImpl edao= new EvenementDaoImpl();
Evenement even= edao.save(new Evenement("Crepto Art","2023-02-20"));
System.out.println(even);
List<Evenement> evens =edao.EvenementParMC("IEE");
for (Evenement e : evens)
System.out.println(e);
}
}