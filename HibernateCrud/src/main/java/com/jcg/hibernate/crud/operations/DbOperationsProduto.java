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

	public static void createRecord(String nome, String quantidade, String preco, int animal) {
		logger.info("\n\n.......Função de adicionar registro.......\n");
		Produto704593e706002 produtoObj = new Produto704593e706002();
		try {

			// Seta objeto com dados recebidos da tela
			produtoObj.setNome(nome);
			produtoObj.setQuantidadeProduzida(Integer.parseInt(quantidade));
			produtoObj.setPreco(Float.parseFloat(preco));
			produtoObj.setAnimal(animal);

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
			// sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Produto704593e706002> displayRecords() {
		List<Produto704593e706002> produtosList = new ArrayList<Produto704593e706002>();
		try {

			sessionObj = buildSessionFactory().openSession();

			sessionObj.beginTransaction();

			produtosList = sessionObj.createQuery("FROM Produto704593e706002").list();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				sessionObj.getTransaction().rollback();
			}
			// sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
		return produtosList;
	}

	public static void updateRecord(int id, String novoNome, String quantidade, String preco, String animal) {
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			Produto704593e706002 produtoObj = (Produto704593e706002) sessionObj.get(Produto704593e706002.class, id);

			produtoObj.setNome(novoNome);
			produtoObj.setQuantidadeProduzida(Integer.parseInt(quantidade));
			produtoObj.setPreco(Float.parseFloat(preco));
			produtoObj.setAnimal(Integer.parseInt(animal));

			sessionObj.getTransaction().commit();

			logger.info(
					"\nProduto With nome?= " + produtoObj.getNome() + " Is Successfully Updated In The Database!\n");
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
			Produto704593e706002 produtoObj = findRecordByName(id);
			sessionObj.delete(produtoObj);

			sessionObj.getTransaction().commit();
			logger.info("\nProduto With Nome?= " + id + " Is Successfully Deleted From The Database!\n");
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

	public static Produto704593e706002 findRecordByName(int id) {
		Produto704593e706002 findProdutoObj = null;
		try {

			sessionObj = buildSessionFactory().openSession();

			sessionObj.beginTransaction();

			findProdutoObj = (Produto704593e706002) sessionObj.load(Produto704593e706002.class, id);
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

			Query queryObj = sessionObj.createQuery("DELETE FROM Produto704593e706002");
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