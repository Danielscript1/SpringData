package com.testeweb.course;

import java.util.Locale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.testeweb.course.entities.Cargo;
import com.testeweb.course.entities.Funcionario;
import com.testeweb.course.repositories.CargoRepository;
import com.testeweb.course.repositories.FuncionarioRepository;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	
	private final CargoRepository repository;
	private final FuncionarioRepository funcionarioRepository;
	
	public SpringDataApplication(CargoRepository repository,FuncionarioRepository funcionarioRepository) {
		this.repository = repository;
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// TODO Auto-generated method stub
		Cargo cargo = new Cargo();
		cargo.setDescricao("DESENVOLVEDOR DE SOFTWARE");
		repository.save(cargo);
		Funcionario func = new Funcionario(null, "Daniel sousa", "05439683365", 1.200, null, cargo);
		funcionarioRepository.save(func);
		
	}
	

	

}
