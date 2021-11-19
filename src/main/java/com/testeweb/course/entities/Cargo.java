package com.testeweb.course.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_cargos")
public class Cargo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Basic entity checklist:
	 Basic attributes
	 Associations (instantiate collections)
	 
	 Getters & Setters (collections: only get)
	 hashCode & equals
	 Serializable
	 * 
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
	
	//Constructors
	public Cargo() {
		
	}

	public Cargo(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	// Getters & Setters (collections: only get)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	 //hashCode & equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		return Objects.equals(id, other.id);
	}
	

	
	
	
	
	
	
	
	
	
	
}
