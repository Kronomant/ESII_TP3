package com.jcg.hibernate.crud.operations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ConsumoAlimentos704593e706002")
public class ConsumoAlimentos704593e706002 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "animal")
	private int animal;

	@Column(name = "alimento")
	private int alimento;

	@Column(name = "quantidade_consumida")
	private int quantidade_consumida;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnimal() {
		return animal;
	}

	public void setAnimal(int animal) {
		this.animal = animal;
	}

	public int getAlimento() {
		return alimento;
	}

	public void setAlimento(int alimento) {
		this.alimento = alimento;
	}

	public int getQuantidadeConsumida() {
		return quantidade_consumida;
	}

	public void setQuantidadeConsumida(int quantidade_consumida) {
		this.quantidade_consumida = quantidade_consumida;
	}

	@Override
	public String toString() {
		return this.id + "-" + this.animal + "-" + this.alimento;
	}

	public String imprimir() {
		return "ConsumoAlimento Details?= Id: " + this.id + ", animal: " + this.animal + ", alimento: " + this.alimento
				+ ", quantidade consumida: " + this.quantidade_consumida;
	}
}