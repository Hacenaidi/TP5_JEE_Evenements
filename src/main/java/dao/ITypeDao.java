package dao;
import java.util.List;
import metier.entities.Type;

public interface ITypeDao {
	public Type save(Type cat);
	public Type getType(Long id);
	public Type updateType(Type cat);
	public void deleteType(Long id);
	public List<Type> getAllType();
}
