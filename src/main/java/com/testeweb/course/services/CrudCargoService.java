package com.testeweb.course.services;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.testeweb.course.entities.Cargo;
import com.testeweb.course.repositories.CargoRepository;

@Service
public class CrudCargoService {
	//variavel
	private final CargoRepository cargoRepository;
	private Boolean system = true;
	
	Scanner scanner = new Scanner (System.in); 
	//constructor
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository; 
	}
	
	//iniciar 
	public void iniciar() {
		while(system) {
		System.out.println("0 - sair ");
		System.out.println("1 - visualizar");
		System.out.println("2 - salvar");
		System.out.println("3 - atualizar  ");
		System.out.println("4 - pesquisar ");
		System.out.println("5 - deletar ");
		
		Integer opc = scanner.nextInt();
		switch(opc) {
		case 1:
			vizualizar(scanner);
			break;
		case 2: 
			
			salvar();
			break;
		case 3 :
			atualizar();
			break;
		case 4:
			pesquisar();
			break;
		case 5:
			deletar();
			break;
		default:
			system = false;
		   }	
		 }	
	}
	
	public void deletar() {
		//Deletar
		System.out.println("digite o Id");
		Integer id = scanner.nextInt();
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.getId();
		cargoRepository.delete(cargo);
		System.out.println("dados deletados!");
	}

	public void vizualizar(Scanner scanner) {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
		
	}
	//pesquisar
	public void pesquisar() {
		System.out.println("digite o Id ");
		Integer id = scanner.nextInt();
		Cargo cargo = new Cargo();
		cargo.setId(id);
		Optional<Cargo> cargos = cargoRepository.findById(cargo.getId());
		System.out.println(cargos);
}
	//atualizar
	public Cargo atualizar() {
		//entrada de dados
		System.out.println("digite o Id");
		Integer id = scanner.nextInt();
		System.out.println("digite a descrição ");
		String descricao = scanner.next();
		//logica de atulização
		//instancia do objeto
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		System.out.println("dados atualizados!");
		return cargoRepository.save(cargo);
		
		
	}

	

	//salvar
	public void salvar() {
		System.out.println("digite a descrição do cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("cargo salvo!!!");
	}
	
	
	
	
}
