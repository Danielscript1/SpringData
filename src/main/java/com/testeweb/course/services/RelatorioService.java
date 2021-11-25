package com.testeweb.course.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
			System.out.println("2 - buscar pensonalizada");
			Integer function = sc.nextInt();
			switch(function) {
			case 1 :
				
				buscar();
				break;
			case 2 :
				buscaFuncionarioNomeSalarioMaiorData();
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
	//buscar pensonalizada buscaFuncionarioNomeSalarioMaiorData
	public void buscaFuncionarioNomeSalarioMaiorData() {
		System.out.println("Digite os filtros desejados");
		System.out.println("nome ");
		String nome = sc.next();
		System.out.println("Data de contratação");
		String dataContratacao = sc.next();
		LocalDate localDate = LocalDate.parse(dataContratacao, formatter);
		System.out.println("salario ");
		Double salario = sc.nextDouble();
		List<Funcionario> list = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome,salario,localDate);
		list.forEach(System.out::println);
	}
	
	
	
}
