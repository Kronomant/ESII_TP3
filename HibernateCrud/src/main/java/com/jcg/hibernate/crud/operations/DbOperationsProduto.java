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

public class DbOperationsProduto {

	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

	public final static Logger logger = Logger.getLogger(DbOperationsProduto.class);

	private static SessionFactory buildSessionFactory() {

		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();

		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	public static void createRecord(Produto produtoObj) {
		logger.info("\n\n.......Função de adicionar registro.......\n");
		try {

			sessionObj = buildSessionFactory().openSession();

			sessionObj.beginTransaction();
			sessionObj.save(produtoObj);

			sessionObj.getTransaction().commit();

			logger.info("\nSuccessfully Created '");
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
	public static List<Produto> displayRecords() {
		List<Produto> produtosList = new ArrayList<Produto>();
		try {

			sessionObj = buildSessionFactory().openSession();

			sessionObj.beginTransaction();

			produtosList = sessionObj.createQuery("FROM Produto").list();
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
		return produtosList;
	}

	public static void updateRecord(Produto produtoObj) {
		try {

			sessionObj.beginTransaction();

			sessionObj.save(produtoObj);

			sessionObj.getTransaction().commit();
			logger.info("\nProduto With Id?= " + produtoObj.getId() + " Is Successfully Updated In The Database!\n");
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

	public static void deleteRecord(Integer id) {
		try {

			sessionObj = buildSessionFactory().openSession();

			sessionObj.beginTransaction();

			Produto produtoObj = findRecordById(id);
			sessionObj.delete(produtoObj);

			sessionObj.getTransaction().commit();
			logger.info("\nProduto With Id?= " + id + " Is Successfully Deleted From The Database!\n");
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

	public static Produto findRecordById(Integer id) {
		Produto findProdutoObj = null;
		try {

			sessionObj = buildSessionFactory().openSession();

			sessionObj.beginTransaction();

			findProdutoObj = (Produto) sessionObj.load(Produto.class, id);
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		}
		return findProdutoObj;
	}

	public static void deleteAllRecords() {
		try {

			sessionObj = buildSessionFactory().openSession();

			sessionObj.beginTransaction();

			Query queryObj = sessionObj.createQuery("DELETE FROM Produto");
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