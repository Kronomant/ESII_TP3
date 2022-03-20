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

public class DbOperationsAnimal {

	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

	public final static Logger logger = Logger.getLogger(DbOperationsAnimal.class);

	private static SessionFactory buildSessionFactory() {
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();

		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	public static void createRecord(String nomeDigitado, String quantidadeDigitada) {
		Animal704593e706002 AnimalObj = new Animal704593e706002();
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			System.out.println(nomeDigitado + quantidadeDigitada);
			AnimalObj = new Animal704593e706002();
			AnimalObj.setQuantidade(Integer.parseInt(quantidadeDigitada));
			AnimalObj.setProdutosDerivados("");
			AnimalObj.setAlimentosConsumidos(1);
			AnimalObj.setNome(nomeDigitado);
			sessionObj.save(AnimalObj);

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
	public static List<Animal704593e706002> displayRecords() {
		List<Animal704593e706002> AnimalsList = new ArrayList<Animal704593e706002>();
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			AnimalsList = sessionObj.createQuery("FROM Animal704593e706002").list();
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
		return AnimalsList;
	}

	public static void updateRecord(String nomeDigitado, String novoNome, String novaQuantidade) {
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			Animal704593e706002 AnimalObj = (Animal704593e706002) sessionObj.get(Animal704593e706002.class,
					nomeDigitado);
			AnimalObj.setNome(novoNome);
			AnimalObj.setQuantidade(Integer.parseInt(novaQuantidade));
			AnimalObj.setProdutosDerivados("");
			AnimalObj.setAlimentosConsumidos(1);
			sessionObj.getTransaction().commit();
			logger.info("\nAnimal With Nome?= " + nomeDigitado + " Is Successfully Updated In The Database!\n");
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

	public static void deleteRecord(String nome) {
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			Animal704593e706002 AnimalObj = findRecordByName(nome);
			sessionObj.delete(AnimalObj);
			sessionObj.getTransaction().commit();
			logger.info("\nAnimal With Nome?= " + nome + " Is Successfully Deleted From The Database!\n");
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

	public static Animal704593e706002 findRecordByName(String nome) {
		Animal704593e706002 findAnimalObj = null;
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			findAnimalObj = (Animal704593e706002) sessionObj.load(Animal704593e706002.class, nome);
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		}
		return findAnimalObj;
	}

	public static void deleteAllRecords() {
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			Query queryObj = sessionObj.createQuery("DELETE FROM Animal704593e706002");
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