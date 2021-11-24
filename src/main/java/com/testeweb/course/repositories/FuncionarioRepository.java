package com.testeweb.course.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.testeweb.course.entities.Funcionario;

public interface FuncionarioRepository extends  CrudRepository<Funcionario, Integer>{
	//listaFuncionario
	List<Funcionario> findByNome(String nome);
}
