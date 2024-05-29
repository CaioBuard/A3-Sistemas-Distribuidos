package br.com.unicuritiba.listatelefonica.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	private String nome;
	private String cpfOuCnpj;
	private float taxaTelefonePagamento;
	
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}
	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	public float getTaxaTelefonePagamento() {
		return taxaTelefonePagamento;
	}
	public void setTaxaTelefonePagamento(float taxaTelefonePagamento) {
		this.taxaTelefonePagamento = taxaTelefonePagamento;
	}
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
