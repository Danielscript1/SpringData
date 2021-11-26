package com.testeweb.course.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.testeweb.course.entities.Funcionario;
import com.testeweb.course.repositories.FuncionarioRepository;
import com.testeweb.course.specification.SpecificationFuncionario;
@Service
public class FuncionarioRelatorioDinamico {
	private final FuncionarioRepository funcionarioRepository;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public FuncionarioRelatorioDinamico(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void iniciar(Scanner scanner) {
		
		System.out.println("digite o nome");
		String nome = scanner.next();
		
		if(nome.equalsIgnoreCase("null")) {
			nome = null;
		}
		System.out.println("digite o cpf");
		String cpf = scanner.next();
		
		if(cpf.equalsIgnoreCase("null")) {
			cpf = null;
		}
		System.out.println("digite o salario");
		Double salario = scanner.nextDouble();
		
		if(salario == 0) {
			salario = null;
		}
		System.out.println("digite a data de contratação");
		String date = scanner.next();
		LocalDate dataContratacao;
		
		
		if(date.equalsIgnoreCase("null")) {
			dataContratacao = null;
		}else {
			dataContratacao = LocalDate.parse(date,formatter);
		}
		
		
		List <Funcionario> funcionarios = funcionarioRepository.findAll(Specification.where(
				SpecificationFuncionario.nome(nome)
				.or(SpecificationFuncionario.cpf(cpf))
				 .or(SpecificationFuncionario.salario(salario))
				.or(SpecificationFuncionario.dataContratacao(dataContratacao))
				)
				
				);
		 funcionarios.forEach(System.out::println);
	
		
		
	}
	
	
	
	
	
}
