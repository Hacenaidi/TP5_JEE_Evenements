package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import metier.entities.Type;
import util.JPAutil;
public class TypeDaoImpl implements ITypeDao {

private EntityManager entityManager=JPAutil.getEntityManager("TP6_JEE_evenement");
@Override
public Type save(Type ty ) {
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.persist(ty);
tx.commit();
return ty;
}
@Override
public Type getType(Long id) {
 return entityManager.find(Type.class, id);
}
@Override
public Type updateType(Type ty) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.merge(ty);
	tx.commit();
	return ty;
}
@Override
public void deleteType(Long id) {
Type type = entityManager.find(Type.class, id);
entityManager.getTransaction().begin();
entityManager.remove(type);
entityManager.getTransaction().commit();
}
@Override
public List<Type> getAllType() {
List<Type> tys =
entityManager.createQuery("select c from Type c").getResultList();
return tys;
}
}