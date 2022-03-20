package com.jcg.hibernate.crud.operations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "quantidade_produzida")
	private int quantidade_produzida;

	@Column(name = "preco")
	private float preco;

	@Column(name = "animal")
	private String animal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidadeProduzida() {
		return quantidade_produzida;
	}

	public void setQuantidadeProduzida(int quantidade_produzida) {
		this.quantidade_produzida = quantidade_produzida;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getIdAnimal() {
		return this.animal;
	}

	public void setIdAnimal(String id_animal) {
		this.animal = id_animal;
	}

	@Override
	public String toString() {
		return "Produto Details?= Id: " + this.id + ", Nome: " + this.nome
				+ ", Quantidade Produzida: " + this.quantidade_produzida
				+ ", Preço: R$" + this.preco
				+ ", animal: " + this.animal;
	}
}