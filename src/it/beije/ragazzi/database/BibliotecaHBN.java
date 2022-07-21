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
	
	public static Utente currentUser(List<Utente> utenti, int id) {
		Utente utenteCorrente = new Utente();
		for (Utente utente : utenti) {
			if(utente.getId() == id) utenteCorrente = utente;
		}
		return utenteCorrente;
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
			// Apro una nuova sessione
			session = openHBSession();//HBsessionFactory.openSession();
			System.out.println("session is open ? " + session.isOpen());
			
			// Inizio la transaction
			Transaction transaction = session.beginTransaction();
			// è equivalente a fare:
//			Transaction transaction = session.getTransaction();
//			transaction.begin();
			
			//SELECT HQL
			Query<Utente> query = session.createQuery("SELECT u FROM Utente as u");//SELECT * FROM utenti
			utenti = query.getResultList();
			
			// Creo un utente
//			Utente nuovoUtente = new Utente();
//			nuovoUtente.setNome("a");
//			nuovoUtente.setCognome("b");
//			nuovoUtente.setTelefono("000009191");
//			nuovoUtente.setEmail("a@b.c");
//			session.save(nuovoUtente);
			
			// Prendo un utente
			Utente utente = currentUser(utenti, 14);
			System.out.println("Utente corrente: " + utente);
			
			// Aggiorno un utente
//			utente.setNome("Mario");
//			utente.setCognome("Gini");
//			utente.setTelefono("123987564");
//			utente.setEmail("g.c@abcd.e");
//			session.save(utente);
			
			// Rimuovo un utente
//			session.delete(utente);
			
			// Committo (chiedere di transaction.rollback();) annullare operazione
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
