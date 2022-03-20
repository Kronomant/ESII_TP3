package com.jcg.hibernate.crud.operations;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Animal704593e706002")
public class Animal704593e706002 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nome")
	private String Nome;

	@Column(name = "quantidade")
	private int quantidade;

	@Column(name = "alimentos_consumidos")
	private int alimentos_consumidos;

	@Column(name = "produtos_derivados")
	private String produtos_derivados;

	public String getName() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getProdutosDerivados() {
		return produtos_derivados;
	}

	public void setProdutosDerivados(String produtos_derivados) {
		this.produtos_derivados = produtos_derivados;
	}

	public int getAlimentosConsumidos() {
		return alimentos_consumidos;
	}

	public void setAlimentosConsumidos(int alimentos_consumidos) {
		this.alimentos_consumidos = alimentos_consumidos;
	}

	@Override
	public String toString() {
		return "Animal Details?= Nome: " + this.Nome + ", quantidade: " + this.quantidade;
	}
}