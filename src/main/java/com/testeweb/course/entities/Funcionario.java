package com.testeweb.course.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tb_funcionarios")
public class Funcionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Basic entity checklist:
	 Basic attributes
	 Associations (instantiate collections)
	 Constructors
	 Getters & Setters (collections: only get)
	 hashCode & equals
	 Serializable
	 * 
	 * */
	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private Date dataNascimento;
	private String cpf;
	
	
	
	//Constructors
	public Funcionario() {
		
	}

	public Funcionario(Long id, String name, String email, Date dataNascimento, String cpf) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		
	}
	
	//Getters & Setters (collections: only get)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	// hashCode & equals

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
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}
	

	
	
	
	
	
	
	
	
	
}
