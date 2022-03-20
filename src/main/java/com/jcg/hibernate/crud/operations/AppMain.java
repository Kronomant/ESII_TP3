package com.jcg.hibernate.crud.operations;

import java.util.List;

import org.apache.log4j.Logger;

public class AppMain {

	public final static Logger logger = Logger.getLogger(AppMain.class);

	public static void main(String[] args) {
		logger.info(".......Hibernate Crud Operations Example.......\n");

		// Produto obj = new Produto(1, "leite", 4, 5, 1);

		// logger.info("\n=======CREATE RECORDS=======\n");
		// DbOperationsProduto.createRecord(obj);

		logger.info("\n=======READ RECORDS=======\n");
		List<Produto> viewContatos = DbOperationsProduto.displayRecords();
		if (viewContatos != null & viewContatos.size() > 0) {
			for (Produto contatoObj : viewContatos) {
				logger.info(contatoObj.toString());
			}
		}

		// logger.info("\n=======UPDATE RECORDS=======\n");
		// int updateId = 1;
		// DbOperationsProduto.updateRecord(updateId);
		// logger.info("\n=======READ RECORDS AFTER UPDATION=======\n");
		// List<Produto> updateContato = DbOperationsProduto.displayRecords();
		// if (updateContato != null & updateContato.size() > 0) {
		// for (Produto contatoObj : updateContato) {
		// logger.info(contatoObj.toString());
		// }
		// }

		// logger.info("\n=======DELETE RECORD=======\n");
		// int deleteId = 5;
		// DbOperationsProduto.deleteRecord(deleteId);
		// logger.info("\n=======READ RECORDS AFTER DELETION=======\n");
		// List<Produto> deleteContatoRecord = DbOperationsProduto.displayRecords();
		// for (Produto contatoObj : deleteContatoRecord) {
		// logger.info(contatoObj.toString());
		// }

		System.exit(0);
	}
}