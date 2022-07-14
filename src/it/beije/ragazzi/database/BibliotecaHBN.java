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
			
			
			//Transaction transaction = session.beginTransaction();
//			Transaction transaction = session.getTransaction();
//			transaction.begin();
			
//			//INSERT
//			Contatto newContatto = new Contatto();
//			newContatto.setId(3);
//			newContatto.setCognome("Giuseppe");
//			newContatto.setNome("Verde");
//			newContatto.setEmail("g.verde@beije.it");
//			System.out.println("contatto PRE : " + newContatto);
//			
//			session.save(newContatto);
//			
//			System.out.println("contatto POST : " + newContatto);

			
			//SELECT HQL
			Query<Utente> query = session.createQuery("SELECT u FROM Utente as u");//SELECT * FROM utenti
			utenti = query.getResultList();
			
			Utente utente = null;
			for (Utente u : utenti) {
				System.out.println(u);
				//if (u.getId() == 12) contatto = u;
			}

			
//			//UPDATE
//			System.out.println("modifico : " + contatto);
//			//contatto.setId(20);
//			contatto.setNote("queste sono le note");
//			contatto.setNome("Piero");
//			session.save(contatto);
//			System.out.println("contatto POST update : " + contatto);
			
//			//DELETE
//			session.remove(contatto);
			
			//transaction.commit();
			//transaction.rollback();

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
