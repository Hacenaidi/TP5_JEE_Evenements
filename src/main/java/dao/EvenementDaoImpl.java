package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Evenement;
import util.JPAutil;
public class EvenementDaoImpl implements IEvenementDao {
private EntityManager entityManager=JPAutil.getEntityManager("TP6_JEE_evenement");
@Override
public Evenement save(Evenement e) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.persist(e);
	tx.commit();
	return e;
	}
@Override
public List<Evenement> EvenementParMC(String mc) {
	List<Evenement> evenements =
	entityManager.createQuery("select p from Evenement p where p.nomEvenement like :mc").setParameter("mc", "%"+mc+"%")

	.getResultList();
	return evenements; 
	}
@Override
public Evenement getEvenement(Long id) {
 
	return entityManager.find(Evenement.class, id);
}
@Override
public Evenement updateEvenement(Evenement e) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.merge(e);
	tx.commit();
	return e;
}
@Override
public void deleteEvenement(Long id) {
	Evenement even = entityManager.find(Evenement.class, id);
	entityManager.getTransaction().begin();
	entityManager.remove(even);
	entityManager.getTransaction().commit();
}
}
