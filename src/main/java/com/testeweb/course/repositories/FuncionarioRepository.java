package com.testeweb.course.repositories;

import org.springframework.data.repository.CrudRepository;

import com.testeweb.course.entities.Funcionario;

public interface FuncionarioRepository extends  CrudRepository<Funcionario, Integer>{

}
