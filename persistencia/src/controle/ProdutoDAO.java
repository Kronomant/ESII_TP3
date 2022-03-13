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
import modelo.Produto;

import static persistencia.Persistencia.*;

public class ProdutoDAO {
 
public void insert(Produto produto){
 
 /*
 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar
 * na base de dados
 */
 String sql = "INSERT INTO PRODUTOS (nome, quantidade_produzida, preco, animal) VALUES('"+
               produto.getNome()+"','"+
               produto.getQuantidade_produzida()+"','"+
               produto.getPreco()+"','"+
               produto.getAnimal()+"')";
 
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

 String sql = "DELETE FROM PRODUTO WHERE codigo = ?";
 
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
 
 public void update(Produto produto){
 
 String sql = "UPDATE PRODUTO SET nome = ?, quantidade_produzida = ?, preco = ?, animal = ?" +
 " WHERE codigo = ?";
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 //Cria uma conexão com o banco
 conn = createConnectionToMySQL();
 
 //Cria um PreparedStatment, classe usada para executar a query
 pstm = conn.prepareStatement(sql);
 
 
 //Adiciona o valor do primeiro parâmetro da sql
 pstm.setString(1, produto.getNome());
 //Adicionar o valor do segundo parâmetro da sql
 pstm.setInt(2, produto.getQuantidade_produzida());
 //Adiciona o valor do terceiro parâmetro da sql
 pstm.setFloat(3, produto.getPreco());
 // Adiciona o valor para o quarto parâmentro da sql
 pstm.setString(4, produto.getAnimal());
 //Adicionar o valor para o quianto parâmetro da sql
 pstm.setInt(5, produto.getId());
 
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
 
 public List<Produto> getProdutos(){
 
 String sql = "SELECT * FROM PRODUTO";
 
 List<Produto> produtos = new ArrayList<Produto>();
 
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
 
 Produto produto = new Produto();
 
 //Recupera o id do banco e atribui ele ao objeto
 produto.setId(rset.getInt("id"));
 
 //Recupera o nome do banco e atribui ele ao objeto
 produto.setNome(rset.getString("nome"));
 
 //Recupera a do banco e atribui ele ao objeto
 produto.setQuantidade_produzida(rset.getInt("quantidade_produzida"));
 
 //Recupera a data do banco e atribui ela ao objeto
 produto.setPreco(rset.getFloat("preco"));
 
 produto.setAnimal(rset.getString("animal"));

 //Adiciono o contato recuperado, a lista de contatos
 produtos.add(produto);
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
 
 return produtos;
 }


 public Produto select(String nomebusca){
  Produto produto = new Produto();
  String sql = "SELECT * FROM PRODUTO WHERE NOME = '"+nomebusca.trim()+"'";


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
    produto.setId(rset.getInt("codigo"));

    //Recupera o nome do banco e atribui ele ao objeto
    produto.setNome(rset.getString("nome"));

    //Recupera a do banco e atribui ele ao objeto
    produto.setQuantidade_produzida(rset.getInt("quantidade_produzida"));
 
    //Recupera a data do banco e atribui ela ao objeto
    produto.setPreco(rset.getFloat("preco"));
 
    produto.setAnimal(rset.getString("animal"));

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

  return produto;

 }




}