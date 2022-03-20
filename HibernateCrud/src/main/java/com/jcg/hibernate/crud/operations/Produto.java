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

	@Column(name = "id_animal")
	private int id_animal;

	public Produto(int id, String nome, int quantidade, float preco, int animal) {
		this.id = id;
		this.nome = nome;
		this.quantidade_produzida = quantidade;
		this.preco = preco;
		this.id_animal = animal;
	}

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

	public int getIdAnimal() {
		return id_animal;
	}

	public void setIdAnimal(int id_animal) {
		this.id_animal = id_animal;
	}

	@Override
	public String toString() {
		return "Produto Details?= Id: " + this.id + ", Nome: " + this.nome
				+ ", Quantidade Produzida: " + this.quantidade_produzida
				+ ", Preço: R$" + this.preco
				+ ", animal: R$" + this.id_animal;
	}
}