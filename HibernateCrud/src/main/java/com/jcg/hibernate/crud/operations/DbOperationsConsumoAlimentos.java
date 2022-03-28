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

public class DbOperationsConsumoAlimentos {

	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

	public final static Logger logger = Logger.getLogger(DbOperationsConsumoAlimentos.class);

	private static SessionFactory buildSessionFactory() {

		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();

		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	public static void createConsumoAlimentos(int animal, int alimento, int quantidade_consumida) {
		logger.info("\n\n.......Função de adicionar registro.......\n");
		ConsumoAlimentos704593e706002 ConsumoAlimentosObj = new ConsumoAlimentos704593e706002();
		try {

			// Seta objeto com dados recebidos da tela
			ConsumoAlimentosObj.setAnimal(animal);
			ConsumoAlimentosObj.setAlimento(alimento);
			ConsumoAlimentosObj.setQuantidadeConsumida(quantidade_consumida);

			sessionObj = buildSessionFactory().openSession();

			sessionObj.beginTransaction();

			sessionObj.save(ConsumoAlimentosObj);

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
}