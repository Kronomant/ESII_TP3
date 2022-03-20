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

	private static SessionFactory buildSessionFactory() {
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();

		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	public static void createRecord(String nomeDigitado, String precoDigitado) {
		Alimento704593e706002 alimentoObj = new Alimento704593e706002();
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			alimentoObj = new Alimento704593e706002();
			alimentoObj.setPreco(Float.parseFloat(precoDigitado));
			alimentoObj.setNome(nomeDigitado);
			sessionObj.save(alimentoObj);

			sessionObj.getTransaction().commit();
			logger.info("\nSuccessfully Created Records In The Database!\n");
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

	@SuppressWarnings("unchecked")
	public static List<Alimento704593e706002> displayRecords() {
		List<Alimento704593e706002> alimentosList = new ArrayList<Alimento704593e706002>();
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			alimentosList = sessionObj.createQuery("FROM Alimento704593e706002").list();
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

	public static void updateRecord(int id, String novoNome, String novoPreco) {
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			Alimento704593e706002 alimentoObj = (Alimento704593e706002) sessionObj.get(Alimento704593e706002.class, id);
			alimentoObj.setNome(novoNome);
			alimentoObj.setPreco(Float.parseFloat(novoPreco));
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

	public static void deleteRecord(int id) {
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			Alimento704593e706002 alimentoObj = findRecordByName(id);
			sessionObj.delete(alimentoObj);
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

	public static Alimento704593e706002 findRecordByName(int id) {
		Alimento704593e706002 findAlimentoObj = null;
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			findAlimentoObj = (Alimento704593e706002) sessionObj.load(Alimento704593e706002.class, id);
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		}
		return findAlimentoObj;
	}

	public static void deleteAllRecords() {
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			Query queryObj = sessionObj.createQuery("DELETE FROM Alimento704593e706002");
			queryObj.executeUpdate();

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