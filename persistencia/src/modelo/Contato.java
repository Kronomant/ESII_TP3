/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

 
public class Contato {
 
private int codigo;
 private String nome;
 private String telefone;
 private String endereco;
 
 public int getId() {
 return codigo;
 }
 
 public void setId(int codigo) {
 this.codigo = codigo;
 }
 
 public String getNome() {
 return nome;
 }
 
 public void setNome(String nome) {
 this.nome = nome;
 }
 
 public String getTelefone() {
 return telefone;
 }
 
 public void setTelefone(String tel) {
 this.telefone = tel;
 }
 
 public String getEndereco() {
 return endereco;
 }
 
 public void setEndereco(String endereco) {
 this.endereco = endereco;
 }
}