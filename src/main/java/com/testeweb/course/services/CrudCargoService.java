package com.testeweb.course.services;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.testeweb.course.entities.Cargo;
import com.testeweb.course.repositories.CargoRepository;

@Service
public class CrudCargoService {
	//variavel
	private final CargoRepository cargoRepository;
	//constructor
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository; 
	}
	
	//iniciar 
	public void iniciar(Scanner scanner) {
		
	}
	//salvar
	public void salvar(Scanner scanner) {
		System.out.println("digite a descrição do cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("cargo salvo!!!");
	}
	
}
