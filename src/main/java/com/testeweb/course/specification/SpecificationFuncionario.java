package com.testeweb.course.specification;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;


import com.testeweb.course.entities.Funcionario;

//consultar dinamica de nome

public class SpecificationFuncionario {
	//consultar dinamica de nome
	public static Specification<Funcionario> nome(String nome){
		return (root, criteriaQuery, criteriaBuider)->
		criteriaBuider.like(root.get("nome"), "%" + nome+ "%" );
		
	}
	
	//consulta de comparação de cpf
	public static Specification<Funcionario> cpf(String cpf){
		return (root, criteriaQuery, criteriaBuider)->
		criteriaBuider.equal(root.get("cpf"), cpf );
		
	}
	//consulta de comparação
	public static Specification<Funcionario> salario(Double salario){
		return (root, criteriaQuery, criteriaBuider)->
		criteriaBuider.greaterThan(root.get("salario"), salario);
		
	}
	//data de contratação
	//consulta de comparação
		public static Specification<Funcionario> dataContratacao(LocalDate dataContratacao){
			return (root, criteriaQuery, criteriaBuider)->
			criteriaBuider.greaterThan(root.get("dataContratacao"), dataContratacao);
			
		}
}
