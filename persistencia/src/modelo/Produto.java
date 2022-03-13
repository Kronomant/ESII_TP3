/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

 
public class Produto {
 
private int id;
 private String nome;
 private int quantidade_produzida;
 private float preco;
 private String animal;
 
 public int getId() {
 return id;
 }
 
 public void setId(int id) {
 this.id = id;
 }
 
 public String getNome() {
 return nome;
 }
 
 public void setNome(String nome) {
 this.nome = nome;
 }
 
 public int getQuantidade_produzida() {
 return quantidade_produzida;
 }
 
 public void setQuantidade_produzida(int quantidade_produzida) {
 this.quantidade_produzida = quantidade_produzida;
 }
 
 public float getPreco() {
 return preco;
 }
 
 public void setPreco(float preco) {
 this.preco = preco;
 }

 public String getAnimal(){
    return animal;
 }

 public void setAnimal(String animal){
this.animal = animal;
 }

}