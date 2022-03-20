package com.jcg.hibernate.crud.operations;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DbOperationsAlimento {

	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

	public final static Logger logger = Logger.getLogger(DbOperationsAlimento.class);

	// This Method Is Used To Create The Hibernate's SessionFactory Object
	private static SessionFactory buildSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration File
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();

		// Creating Hibernate SessionFactory Instance
		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	// Method 1: This Method Used To Create A New Student Record In The Database
	// Table
	public static void createRecord(String nomeDigitado, String precoDigitado) {
		int count = 0;
		Alimento alimentoObj = new Alimento();
		try {
			// Getting Session Object From SessionFactory
			sessionObj = buildSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			sessionObj.beginTransaction();

			alimentoObj = new Alimento();
			alimentoObj.setPreco(Float.parseFloat(precoDigitado));
			alimentoObj.setNome(nomeDigitado);
			sessionObj.save(alimentoObj);

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
			logger.info("\nSuccessfully Created '" + count + "' Records In The Database!\n");
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}

	// Method 2: This Method Is Used To Display The Records From The Database Table
	@SuppressWarnings("unchecked")
	public static List<Alimento> displayRecords() {
		List<Alimento> alimentosList = new ArrayList<Alimento>();
		try {
			// Getting Session Object From SessionFactory
			sessionObj = buildSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			sessionObj.beginTransaction();

			alimentosList = sessionObj.createQuery("FROM Alimento").list();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
		return alimentosList;
	}

	// Method 3: This Method Is Used To Update A Record In The Database Table
	public static void updateRecord(int id, String novoNome, String novoPreco) {
		try {
			// Getting Session Object From SessionFactory
			sessionObj = buildSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			sessionObj.beginTransaction();

			// Creating Transaction Entity
			Alimento alimentoObj = (Alimento) sessionObj.get(Alimento.class, id);
			alimentoObj.setNome(novoNome);
			alimentoObj.setPreco(Float.parseFloat(novoPreco));

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
			logger.info("\nAlimento With Id?= " + id + " Is Successfully Updated In The Database!\n");
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}

	// Method 4(a): This Method Is Used To Delete A Particular Record From The
	// Database Table
	public static void deleteRecord(int id) {
		try {
			// Getting Session Object From SessionFactory
			sessionObj = buildSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			sessionObj.beginTransaction();

			Alimento alimentoObj = findRecordByName(id);
			sessionObj.delete(alimentoObj);

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
			logger.info("\nAlimento With Nome?= " + id + " Is Successfully Deleted From The Database!\n");
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}

	// Method 4(b): This Method To Find Particular Record In The Database Table
	public static Alimento findRecordByName(int id) {
		Alimento findAlimentoObj = null;
		try {
			// Getting Session Object From SessionFactory
			sessionObj = buildSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			sessionObj.beginTransaction();

			findAlimentoObj = (Alimento) sessionObj.load(Alimento.class, id);
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		}
		return findAlimentoObj;
	}

	// Method 5: This Method Is Used To Delete All Records From The Database Table
	public static void deleteAllRecords() {
		try {
			// Getting Session Object From SessionFactory
			sessionObj = buildSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			sessionObj.beginTransaction();

			Query queryObj = sessionObj.createQuery("DELETE FROM Alimento");
			queryObj.executeUpdate();

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
			logger.info("\nSuccessfully Deleted All Records From The Database Table!\n");
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}
}