package web;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Type;
public class TypeModele {
List<Type> types = new ArrayList<>();
public List<Type> getTypes() {
return types;
}
public void setTypes(List<Type> categories) {
this.types = categories;
}
}