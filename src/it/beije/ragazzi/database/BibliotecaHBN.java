package it.beije.ragazzi.database;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class BibliotecaHBN {

	public static void main(String[] args) {
		
		List<Utente> utenti = loadUsers();
		System.out.println("numero utenti : " + utenti.size());
		for (Utente u : utenti) {
			System.out.println(u);
		}
		
	}

	public static Session openHBSession() {
		Configuration configuration = new Configuration().configure()
				.addAnnotatedClass(Utente.class);			
		//.addAnnotatedClass(AltraClasse.class)				

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		return sessionFactory.openSession();
	}
	
		
	public static List<Utente> loadUsers() {
		List<Utente> utenti = null;
		
		Session session = null;
		try {
			
			session = openHBSession();//HBsessionFactory.openSession();
			System.out.println("session is open ? " + session.isOpen());
			
			
			Transaction transaction = session.beginTransaction();
//			Transaction transaction = session.getTransaction();
//			transaction.begin();
			
			//INSERT
//			Utente nuovo = new Utente();
////			nuovo.setId(30);
//			nuovo.setNome("Riccardo");
//			nuovo.setCognome("Marrone");
//			nuovo.setTelefono("234324");
//			nuovo.setEmail("rm@beije.it23");
//			
//			System.out.println("Utente PRE : " + nuovo);
//			
//			session.save(nuovo);
//			
//			System.out.println("Utente POST : " + nuovo);

//			transaction.rollback();
			
			//SELECT HQL
			Query<Utente> query = session.createQuery("SELECT u FROM Utente as u");//SELECT * FROM utenti
			utenti = query.getResultList();
			
			Utente utente = null;
			for (Utente u : utenti) {
				System.out.println(u);
				if (u.getId() == 2) utente = u;
			}

			
			//UPDATE
//			System.out.println("modifico : " + utente);
//			//utente.setId(20);
//			utente.setTelefono("11111111");
//			utente.setNome("Davide");
//			session.save(utente);
//			System.out.println("utente POST update : " + utente);
			
			//DELETE
//			session.remove(utente);
			
			transaction.commit();

		} catch (HibernateException hbmEx) {
			hbmEx.printStackTrace();
			throw hbmEx;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
		
		return utenti;
	}

}
