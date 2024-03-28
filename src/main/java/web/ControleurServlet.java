package web;
import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;

import dao.EvenementDaoImpl;
import dao.IEvenementDao;
import dao.ITypeDao;
import dao.TypeDaoImpl;
import metier.entities.Evenement;
import metier.entities.Type;
@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
IEvenementDao metier;
ITypeDao metierty;

@Override
public void init() throws ServletException {
metier = new EvenementDaoImpl();
metierty = new TypeDaoImpl();

}
@Override
protected void doGet(HttpServletRequest request,
		 HttpServletResponse response) 
		 throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/index.do"))
		{
		request.getRequestDispatcher("evenements.jsp").forward(request,response);
		}
		else if (path.equals("/chercher.do"))
		{
		String motCle=request.getParameter("motCle");
		EvenementModele model= new EvenementModele();
		model.setMotCle(motCle);
		List<Evenement> even = metier.EvenementParMC(motCle);
		model.setEvenements(even);
		request.setAttribute("model", model);
		request.getRequestDispatcher("evenements.jsp").forward(request,response);
		}
		else if (path.equals("/saisie.do") )
		{
			List<Type> tys = metierty.getAllType();
			TypeModele model= new TypeModele();
			model.setTypes(tys);
			request.setAttribute("typeModel", model);
		request.getRequestDispatcher("saisieEvenement.jsp").forward(request,response);
		}
		else if (path.equals("/save.do") && 
		request.getMethod().equals("POST"))
		{
		 String nom=request.getParameter("nom");
		 Long TypeId=Long.parseLong(request.getParameter("type"));
		String date = request.getParameter("date");
		Type ty = metierty.getType(TypeId);
		Evenement e = metier.save(new Evenement(nom,date,ty));
		request.setAttribute("evenement", e);
		request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else if (path.equals("/supprimer.do"))
		{
		 Long id= Long.parseLong(request.getParameter("id"));
		 metier.deleteEvenement(id);
		 response.sendRedirect("chercher.do?motCle=");
		}
		else if (path.equals("/editer.do") )
		{
		Long id= Long.parseLong(request.getParameter("id"));
		Evenement e = metier.getEvenement(id);
		 request.setAttribute("evenement", e);
		 List<Type> tys = metierty.getAllType();
		 TypeModele model= new TypeModele();
		 model.setTypes(tys);
		 request.setAttribute("typeModel", model);
		request.getRequestDispatcher("editerEvenement.jsp").forward(request,response);
		}
		else if (path.equals("/update.do") )
		{
		Long id = Long.parseLong(request.getParameter("id"));
		String nom=request.getParameter("nom");
		String date = request.getParameter("date");
		 Long TypeId=Long.parseLong(request.getParameter("type"));
		Evenement e = new Evenement();
		e.setIdEvenement(id);
		e.setNomEvenement(nom);
		e.setDateEvenement(date);
		Type ty = metierty.getType(TypeId);
		e.setType(ty);
		metier.updateEvenement(e);
		request.setAttribute("evenement", e);
		request.getRequestDispatcher("confirmation.jsp").forward(request,response);
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
}
}
