package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.*;
import jpa.*;

@WebServlet(name = "userinfobis", urlPatterns = { "/UserInfoBis" })
public class UserInfoBis extends HttpServlet {

	private EntityManager manager;

	@Override
	public void init() {

		this.manager = EntitiesManagerHelp.getEntityManager();

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			Personne personne = new Personne();
			personne.setPrenom(request.getParameter("prenom"));
			personne.setNom(request.getParameter("nom"));
			personne.setAge(Integer.parseInt(request.getParameter("age")));

			if (!request.getParameter("add").isEmpty()) {
				Residence maison = new Residence();
				maison.setAdresse(request.getParameter("add"));
				maison.setNbPieces(Integer.parseInt(request.getParameter("nbPiece")));
				maison.setTaille(Integer.parseInt(request.getParameter("taille")));
				maison.setProprio(personne);
				Collection<Residence> maisons = new ArrayList<Residence>();
				maisons.add(maison);
				personne.setMaisons(maisons);
			}

			manager.persist(personne);

		} catch (Exception e) {
			e.printStackTrace();
		}

		tx.commit();

	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		String temp = "<html><body>" + "<h1> Liste des Personnes</h1>";

		Collection<Personne> personnes = manager.createQuery("select p FROM Personne p", Personne.class)
				.getResultList();

		temp += "<ul>";
		for (Personne pers : personnes) {
			temp += "<h2>Personne " + pers.getId() + "</h2>";
			temp += "<li><ul>";
			temp += "<li>Nom : " + pers.getNom() + "</li>";
			temp += "<li>Prenom : " + pers.getPrenom() + "</li>";
			temp += "<li>Age : " + pers.getAge() + "</li>";
			if (pers.getElectronicDevices() != null) {
				temp += "<li><h3>Apppareils</h3></li>";
				for (ElectronicDevice app : pers.getElectronicDevices()) {
					temp += "<li><ul><li>";
					temp += "Nom :" + app.getNom();
					temp += "</li>";
					temp += "<li>";
					temp += "Conso : " + app.getConso();
					temp += "</li></ul></li>";
				}
			}
			if (pers.getMaisons() != null || pers.getMaisons().isEmpty()) {
				temp += "<li><h3>Maison</h3></li>";

				for (Residence mais : pers.getMaisons()) {
					temp += "<li><ul><li>";
					temp += "Adresse :" + mais.getAdresse();
					temp += "</li>";
					temp += "<li>";
					temp += "Taille : " + mais.getTaille() + "m²";
					temp += "</li>";
					temp += "<li>";
					temp += "NbPiece : " + mais.getNbPieces();
					temp += "</li>";
					if (mais.getChauffages() != null) {
						temp += "<li><h4>Chauffages</h4></li>";
						for (Heater chau : mais.getChauffages()) {
							temp += "<li><ul><li>";
							temp += "id :" + chau.getId();
							temp += "</li>";
							temp += "<li>";
							temp += "Conso : " + chau.getConso();
							temp += "</li></ul></li>";
						}
					}
					temp += "</li></ul></li>";
				}
			}
			temp += "</ul></li>";
		}
		temp += "</ul></body></html>";

		temp += "<a href='monform.html>retout</a>'";

		p.print(temp);
		p.flush();

	}

	@Override
	public void destroy() {
		manager.close();
		EntitiesManagerHelp.closeEntityManagerFactory();
	}
}
