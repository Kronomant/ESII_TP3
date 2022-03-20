// package com.jcg.hibernate.crud.operations;

// import java.util.List;

// import org.apache.log4j.Logger;

// public class AppMain {

// public final static Logger logger = Logger.getLogger(AppMain.class);

// public static void main(String[] args) {
// logger.info(".......Hibernate Crud Operations Example.......\n");

// logger.info("\n=======CREATE RECORDS=======\n");
// DbOperationsAlimento.createRecord();

// logger.info("\n=======READ RECORDS=======\n");
// List<Alimento> viewAliemntos = DbOperationsAlimento.displayRecords();
// if (viewAliemntos != null & viewAliemntos.size() > 0) {
// for (Alimento alimentoObj : viewAliemntos) {
// logger.info(alimentoObj.toString());
// }
// }

// logger.info("\n=======UPDATE RECORDS=======\n");
// int updateId = 1;
// DbOperationsAlimento.updateRecord(updateId);
// logger.info("\n=======READ RECORDS AFTER UPDATION=======\n");
// List<Alimento> updateAlimento = DbOperationsAlimento.displayRecords();
// if (updateAlimento != null & updateAlimento.size() > 0) {
// for (Alimento alimentoObj : updateAlimento) {
// logger.info(alimentoObj.toString());
// }
// }

// logger.info("\n=======DELETE RECORD=======\n");
// int deleteId = 5;
// DbOperationsAlimento.deleteRecord(deleteId);
// logger.info("\n=======READ RECORDS AFTER DELETION=======\n");
// List<Alimento> deleteAlimentoRecord = DbOperationsAlimento.displayRecords();
// for (Alimento alimentoObj : deleteAlimentoRecord) {
// logger.info(alimentoObj.toString());
// }

// System.exit(0);
// }
// }