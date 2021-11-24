package com.testeweb.course.services;

import java.util.List;
import java.util.Scanner;

import com.testeweb.course.entities.Cargo;
import com.testeweb.course.entities.Funcionario;
import com.testeweb.course.repositories.CargoRepository;
import com.testeweb.course.repositories.FuncionarioRepository;

public class RelatorioService {
	//declaração da variavel
	private Boolean system = true;
	private final FuncionarioRepository funcionarioRepository;
	Scanner sc = new Scanner (System.in); 
	
	
	
	
	public RelatorioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	

	public void iniciar() {
		
		while(system) {
			System.out.println("Qual ação você deseja executar!!");
			System.out.println("0 - sair");
			System.out.println("1 - buscar");
			Integer function = sc.nextInt();
			switch(function) {
			case 1 :
				
				buscar();
				break;
			default:
				system = false;
				System.out.println("finalizando...");
			}
			
		}
	}

	public void buscar() {
		System.out.println("Digite o nome do funcionario");
		String nome = sc.next();
		Iterable<Funcionario> funcionario = funcionarioRepository.findByNome(nome);
		funcionario.forEach(cargo -> System.out.println(cargo));
		
		
	}
	
}
