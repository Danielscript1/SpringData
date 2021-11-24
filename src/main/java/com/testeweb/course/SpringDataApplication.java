package com.testeweb.course;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.testeweb.course.entities.Cargo;
import com.testeweb.course.entities.Funcionario;
import com.testeweb.course.repositories.CargoRepository;
import com.testeweb.course.repositories.FuncionarioRepository;
import com.testeweb.course.services.CrudCargoService;
import com.testeweb.course.services.CrudFuncionarioService;
import com.testeweb.course.services.RelatorioService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	//declaração das variavies global
	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final RelatorioService relatorioService;
	private Boolean system = true;
	
	//constructor
	public SpringDataApplication(CrudCargoService cargoService,CrudFuncionarioService funcionarioService,RelatorioService relatorioService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.relatorioService = relatorioService;
	}
	//rodar minha aplicação com minhas classes junto com springboot
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		

		//logica do algoritmo
		while(system) {
			System.out.println("qual ação voce deseja realizar: ");
			System.out.println("0 - sair: ");
			System.out.println("1 - Cargo ");
			System.out.println("2 - funcionario");
			System.out.println("3 - relatorio");
			//variavel de comparação
			Integer function = scanner.nextInt();
			switch(function){
			case 1 :
				
				cargoService.iniciar();
				break;
			case 2 :
				funcionarioService.iniciar(scanner);
				break;
			case 3: 
				relatorioService.iniciar();
				break;
			default:
				System.out.println("Finalizando...");
				system = false;
				break;
			}
		}
		
		
		
	}
	

	

}
