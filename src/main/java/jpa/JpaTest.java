package jpa;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.*;
import jpa.*;
public class JpaTest {

	/**
	 * @param args
	 */
/**	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			
			
//Person p = new Person();
			//p.setName("martin");
			//manager.persist(p);
	
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
//		String s = "SELECT e FROM Person as e where e.name=:name";
		
//		Query q = manager.createQuery(s,Person.class);
//		q.setParameter("name", "martin"); 
//		List<Person> res = q.getResultList();
		
//		System.err.println(res.size());
//		System.err.println(res.get(0).getName());
		
		manager.close();
		factory.close();
	}*/

	/**
	 * **************************************************************************************
	 */

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	
	public static void main(String[] args) {
		EntityManager manager = EntitiesManagerHelp.getEntityManager();
		EntityTransaction tx = manager.getTransaction();

		tx.begin();

		try {
			create(manager);
		} catch (Exception e) {
			e.printStackTrace();
		}

		tx.commit();

		manager.close();
		EntitiesManagerHelp.closeEntityManagerFactory();
	}

	@SuppressWarnings("unused")
	private static void create(final EntityManager manager) {
		Long nbPersonne = (Long) manager.createQuery("select count(p) FROM Personne p").getSingleResult();

		if (nbPersonne == 0) {

			Collection<ElectronicDevice> appList1 = new ArrayList<ElectronicDevice>();
			Collection<ElectronicDevice> appList2 = new ArrayList<ElectronicDevice>();
			Collection<ElectronicDevice> appList3 = new ArrayList<ElectronicDevice>();

			Personne HTSA = new Personne();
			Personne Yvann = new Personne();
			Personne Thomas = new Personne();

			ElectronicDevice tv = new ElectronicDevice();
			tv.setNom("TV");
			tv.setConso(120);
			tv.setProprio(HTSA);

			ElectronicDevice lDVD = new ElectronicDevice();
			lDVD.setNom("lecteurDVD");
			lDVD.setConso(19);
			lDVD.setProprio(HTSA);

			ElectronicDevice hc = new ElectronicDevice();
			hc.setNom("homecinema");
			hc.setConso(200);
			hc.setProprio(HTSA);

			ElectronicDevice mo = new ElectronicDevice();
			mo.setNom("micro_ondes");
			mo.setConso(200);
			mo.setProprio(Thomas);

			ElectronicDevice fo = new ElectronicDevice();
			fo.setNom("four");
			fo.setConso(200);
			fo.setProprio(Thomas);

			ElectronicDevice tel = new ElectronicDevice();
			tel.setNom("smart_phone");
			tel.setConso(100);
			tel.setProprio(Thomas);

			ElectronicDevice table = new ElectronicDevice();
			table.setNom("tablette");
			table.setConso(80);
			table.setProprio(Yvann);

			ElectronicDevice impr = new ElectronicDevice();
			impr.setNom("imprimante");
			impr.setConso(120);
			impr.setProprio(Yvann);

			appList1.add(tv);
			appList1.add(lDVD);
			appList1.add(hc);

			appList2.add(mo);
			appList2.add(fo);
			appList2.add(tel);

			appList3.add(table);
			appList3.add(impr);

			Heater ch1 = new Heater();
			Heater ch2 = new Heater();
			Heater ch3 = new Heater();
			Heater ch4 = new Heater();
			Heater ch5 = new Heater();
			Heater ch6 = new Heater();
			Heater ch7 = new Heater();

			Collection<Heater> chList1 = new ArrayList<Heater>();
			Collection<Heater> chList2 = new ArrayList<Heater>();
			Collection<Heater> chList3 = new ArrayList<Heater>();

			Residence maison1 = new Residence();
			maison1.setAdresse("5 square Dr Guerin");
			maison1.setChauffages(chList1);
			maison1.setNbPieces(2);
			maison1.setTaille(50);
			maison1.setProprio(Yvann);

			Residence maison2 = new Residence();
			maison2.setAdresse("64 boulevard Raymond Poincarré");
			maison2.setChauffages(chList2);
			maison2.setNbPieces(3);
			maison2.setTaille(80);
			maison2.setProprio(HTSA);

			Residence maison3 = new Residence();
			maison3.setAdresse("4 boulevard Solferino");
			maison3.setChauffages(chList3);
			maison3.setNbPieces(2);
			maison3.setTaille(60);
			maison3.setProprio(Thomas);

			ch1.setConso(50);
			ch2.setConso(60);
			ch3.setConso(70);
			ch4.setConso(60);
			ch5.setConso(50);
			ch6.setConso(80);
			ch7.setConso(80);

			ch1.setMaison(maison1);
			ch2.setMaison(maison1);
			ch7.setMaison(maison1);

			ch3.setMaison(maison2);
			ch4.setMaison(maison2);

			ch6.setMaison(maison3);
			ch5.setMaison(maison3);

			chList1.add(ch1);
			chList1.add(ch2);
			chList1.add(ch7);

			chList2.add(ch3);
			chList2.add(ch4);

			chList3.add(ch5);
			chList3.add(ch6);

			maison1.setChauffages(chList1);
			maison2.setChauffages(chList2);
			maison3.setChauffages(chList3);

			Collection<Personne> poteHtsa = new ArrayList<Personne>();
			Collection<Personne> poteYvann = new ArrayList<Personne>();
			Collection<Personne> poteThomas = new ArrayList<Personne>();

			Collection<Residence> maisonHtsa = new ArrayList<Residence>();
			Collection<Residence> maisonYvann = new ArrayList<Residence>();
			Collection<Residence> maisonThomas = new ArrayList<Residence>();

			maisonHtsa.add(maison3);
			maisonThomas.add(maison2);
			maisonYvann.add(maison1);

			HTSA.setPrenom("Hedi Theo");
			HTSA.setNom("Sahraoui");
			HTSA.setElectronicDevices(appList1);
			HTSA.setMaisons(maisonHtsa);
			HTSA.setAge(16);

			Yvann.setPrenom("Yvann");
			Yvann.setNom("Josso");
			Yvann.setElectronicDevices(appList2);
			Yvann.setMaisons(maisonYvann);
			Yvann.setAge(21);

			Thomas.setPrenom("Thomas");
			Thomas.setNom("Gregoire");
			Thomas.setElectronicDevices(appList3);
			Thomas.setMaisons(maisonThomas);
			Thomas.setAge(22);

			poteHtsa.add(Yvann);
			poteHtsa.add(Thomas);

			poteYvann.add(Thomas);
			poteYvann.add(HTSA);

			poteThomas.add(Yvann);
			poteThomas.add(HTSA);

			HTSA.setAmis(poteHtsa);
			Yvann.setAmis(poteYvann);
			Thomas.setAmis(poteThomas);

			manager.persist(HTSA);
			manager.persist(Yvann);
			manager.persist(Thomas);

		}
	}

}
