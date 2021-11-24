package com.testeweb.course.services;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.testeweb.course.entities.Cargo;
import com.testeweb.course.entities.Funcionario;
import com.testeweb.course.repositories.CargoRepository;
import com.testeweb.course.repositories.FuncionarioRepository;
@Service
public class RelatorioService {
	//declaração da variavel
	private Boolean system = true;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	Scanner sc = new Scanner(System.in);
	private final FuncionarioRepository funcionarioRepository;
	
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
	//buscar por nome
	public void buscar() {
		
		System.out.println("Qual nome deseja pesquisar");
		String nome = sc.next();
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		list.forEach(System.out::println);


		
		
	}
	
	
	
}
