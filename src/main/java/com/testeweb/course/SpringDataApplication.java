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

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	//declaração das variavies global
	private final CargoRepository repository;
	private final FuncionarioRepository funcionarioRepository;
	private final CrudCargoService cargoService;
	private final Boolean system = true; 
	
	public SpringDataApplication(CargoRepository repository,FuncionarioRepository funcionarioRepository,CrudCargoService cargoService) {
		this.repository = repository;
		this.funcionarioRepository = funcionarioRepository;
		this.cargoService = cargoService;
	}
	
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
		}
		
		Cargo cargo = new Cargo();
		cargo.setDescricao("DESENVOLVEDOR DE SOFTWARE");
		repository.save(cargo);
		Funcionario func = new Funcionario(null, "Daniel sousa", "05439683365", 1.200, null, cargo);
		funcionarioRepository.save(func);
		
	}
	

	

}
