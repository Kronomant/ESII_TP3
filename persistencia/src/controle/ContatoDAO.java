/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
import persistencia.Persistencia;
import modelo.Contato;

import static persistencia.Persistencia.*;

public class ContatoDAO {
 
public void insert(Contato contato){
 
 /*
 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar
 * na base de dados
 */
 String sql = "INSERT INTO CONTATOS_110068(endereco, nome, telefone) VALUES('"+
               contato.getEndereco()+"','"+
               contato.getNome()+"','"+
               contato.getTelefone()+"')";
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 //Cria uma conexão com o banco
 conn = createConnectionToMySQL();
 
 //Cria um PreparedStatment, classe usada para executar a query

 pstm = conn.prepareStatement(sql);



 
 //Executa a sql para inserção dos dados
 pstm.execute();
 
 } catch (Exception e) {
 
 e.printStackTrace();
 }finally{
 
 //Fecha as conexões
 
 try{
 if(pstm != null){
 
 pstm.close();
 }
 
 if(conn != null){
 conn.close();
 }
 
 }catch(Exception e){
 
 e.printStackTrace();
 }
 }
 }
 
 public void delete(int id){

 String sql = "DELETE FROM CONTATOS_110068 WHERE codigo = ?";
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 conn = createConnectionToMySQL();
 
 pstm = conn.prepareStatement(sql);
 
 pstm.setInt(1, id);
 
 pstm.execute();
 
 } catch (Exception e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }finally{
 
 try{
 if(pstm != null){
 
 pstm.close();
 }
 
 if(conn != null){
 conn.close();
 }
 
 }catch(Exception e){
 
 e.printStackTrace();
 }
 }
 }
 
 public void update(Contato contato){
 
 String sql = "UPDATE CONTATOS_110068 SET nome = ?, telefone = ?, endereco = ?" +
 " WHERE codigo = ?";
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 //Cria uma conexão com o banco
 conn = createConnectionToMySQL();
 
 //Cria um PreparedStatment, classe usada para executar a query
 pstm = conn.prepareStatement(sql);
 
 
//Adiciona o valor do primeiro parâmetro da sql
pstm.setInt(4, contato.getId());
 
pstm.setString(1, contato.getNome());
 //Adicionar o valor do segundo parâmetro da sql
 pstm.setString(2, contato.getTelefone());
 //Adiciona o valor do terceiro parâmetro da sql
 pstm.setString(3, contato.getEndereco());
 
 
 //Executa a sql para inserção dos dados
 pstm.execute();
 
 } catch (Exception e) {
 
 e.printStackTrace();
 }finally{
 
 //Fecha as conexões
 
 try{
 if(pstm != null){
 
 pstm.close();
 }
 
 if(conn != null){
 conn.close();
 }
 
 }catch(Exception e){
 
 e.printStackTrace();
 }
 }
 }
 
 public List<Contato> getContatos(){
 
 String sql = "SELECT * FROM CONTATOS_110068";
 
 List<Contato> contatos = new ArrayList<Contato>();
 
 Connection conn = null;
 PreparedStatement pstm = null;
 //Classe que vai recuperar os dados do banco de dados
 ResultSet rset = null;
 
 try {
 conn = createConnectionToMySQL();
 
 pstm = conn.prepareStatement(sql);
 
 rset = pstm.executeQuery();
 
 //Enquanto existir dados no banco de dados, faça
 while(rset.next()){
 
 Contato contato = new Contato();
 
 //Recupera o id do banco e atribui ele ao objeto
 contato.setId(rset.getInt("codigo"));
 
 //Recupera o nome do banco e atribui ele ao objeto
 contato.setNome(rset.getString("nome"));
 
 //Recupera a do banco e atribui ele ao objeto
 contato.setTelefone(rset.getString("telefone"));
 
 //Recupera a data do banco e atribui ela ao objeto
 contato.setEndereco(rset.getString("endereco"));
 
 //Adiciono o contato recuperado, a lista de contatos
 contatos.add(contato);
 }
 } catch (Exception e) {
 
 e.printStackTrace();
 }finally{
 
 try{
 
 if(rset != null){
 
 rset.close();
 }
 
 if(pstm != null){
 
 pstm.close();
 }
 
 if(conn != null){
 conn.close();
 }
 
 }catch(Exception e){
 
 e.printStackTrace();
 }
 }
 
 return contatos;
 }


 public Contato select(String nomebusca){
  Contato contato = new Contato();
  String sql = "SELECT * FROM CONTATOS_110068 WHERE NOME = '"+nomebusca.trim()+"'";


  Connection conn = null;
  PreparedStatement pstm = null;
  //Classe que vai recuperar os dados do banco de dados
  ResultSet rset = null;

  try {
   conn = createConnectionToMySQL();

   pstm = conn.prepareStatement(sql);

   rset = pstm.executeQuery();

   //Enquanto existir dados no banco de dados, faça
   while(rset.next()){



    //Recupera o id do banco e atribui ele ao objeto
    contato.setId(rset.getInt("codigo"));

    //Recupera o nome do banco e atribui ele ao objeto
    contato.setNome(rset.getString("nome"));

    //Recupera a do banco e atribui ele ao objeto
    contato.setTelefone(rset.getString("telefone"));

    //Recupera a data do banco e atribui ela ao objeto
    contato.setEndereco(rset.getString("endereco"));

   }
  } catch (Exception e) {

   e.printStackTrace();
  }finally{

   try{

    if(rset != null){

     rset.close();
    }

    if(pstm != null){

     pstm.close();
    }

    if(conn != null){
     conn.close();
    }

   }catch(Exception e){

    e.printStackTrace();
   }
  }

  return contato;

 }




}