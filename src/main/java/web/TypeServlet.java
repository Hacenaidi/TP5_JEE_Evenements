package web;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import dao.TypeDaoImpl;
import dao.ITypeDao;
import metier.entities.Type;
@WebServlet (name="TypeServ",urlPatterns= {"/types","/saisieType",
"/saveType","/supprimerType","/editerType","/updateType"})
public class TypeServlet extends HttpServlet {
ITypeDao metier;
@Override
public void init() throws ServletException {
metier = new TypeDaoImpl();
}
@Override
protected void doGet(HttpServletRequest request,
 HttpServletResponse response) 
 throws ServletException, IOException {
String path=request.getServletPath();
System.out.println("PATH "+path);
if (path.equals("/types"))
{
	TypeModele model= new TypeModele();
List<Type> tys = metier.getAllType();
model.setTypes(tys);
request.setAttribute("model", model);
request.getRequestDispatcher("types.jsp").forward(request,response);
}
else if (path.equals("/saisieType") )
{
request.getRequestDispatcher("saisieType.jsp").forward(request,response
);
}
else if (path.equals("/saveType") && 
request.getMethod().equals("POST"))
{
Date datety= new Date();
 String nom=request.getParameter("nom");
 String pattern = "yyyy-MM-dd";
 SimpleDateFormat simpleDateFormat = new
SimpleDateFormat(pattern);
 try {
	 datety = 
			 simpleDateFormat.parse(request.getParameter("datety"));
			 } catch (ParseException e) {
			 e.printStackTrace();
			 }
			  
 			Type ty = metier.save(new Type(nom,datety));
			 request.setAttribute("type", ty);
			 response.sendRedirect("types");
			 }
			 else if (path.equals("/supprimerType"))
			 {
			  Long id= Long.parseLong(request.getParameter("id"));
			  metier.deleteType(id);
			  response.sendRedirect("types");
			 }
			 else if (path.equals("/editerType") )
			 {
			 Long id= Long.parseLong(request.getParameter("id"));
			 Type cat = metier.getType(id);
			  request.setAttribute("type", cat);
			 request.getRequestDispatcher("editerType.jsp").forward(request,response
			 );
			 }
			 else if (path.equals("/updateType") )
			 {
			 Date datety= new Date();
			 Long id = Long.parseLong(request.getParameter("id"));
			 String nom=request.getParameter("nom");
			 Type ty = new Type();
			 ty.setIdType(id);
			 ty.setNomType(nom);
			 String pattern = "yyyy-MM-dd";
			 SimpleDateFormat simpleDateFormat = new
			 SimpleDateFormat(pattern);
			  try {
			 datety = 
			 simpleDateFormat.parse(request.getParameter("dateCreation"));
			 } catch (ParseException e) {
			 e.printStackTrace();
			 }
			 ty.setDateCreation(datety);
			  metier.updateType(ty);
			 response.sendRedirect("types");
			 }
			 else
			 {
			 response.sendError(Response.SC_NOT_FOUND);
			 }
			 }
			 @Override
			 protected void doPost(HttpServletRequest request, 
					 HttpServletResponse response) throws
			 ServletException, IOException {
			 doGet(request,response);
			 }}
