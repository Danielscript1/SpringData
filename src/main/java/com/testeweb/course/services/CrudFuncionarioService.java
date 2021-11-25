package com.testeweb.course.services;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.testeweb.course.entities.Cargo;
import com.testeweb.course.entities.Funcionario;
import com.testeweb.course.repositories.CargoRepository;
import com.testeweb.course.repositories.FuncionarioRepository;
@Service
public class CrudFuncionarioService {

	private Boolean system = true;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private final CargoRepository cargoRepository;
	private final FuncionarioRepository funcionarioRepository;
	//private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
	
	
	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, 
			CargoRepository cargoRepository ) {
		this.cargoRepository = cargoRepository;
		this.funcionarioRepository = funcionarioRepository;
		//this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}
	
	public void iniciar(Scanner scanner) {
		while(system) {
			System.out.println("Qual acao de funcionario deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - visualizar");
		
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2: 
				vizualizar(scanner);
				break;
			
			default:
				system = false;
				break;
			}
			
		}
		
	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Digite o nome");
        String nome = scanner.next();


        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);

        funcionarioRepository.save(funcionario);
        System.out.println("Salvo");
	}
   //paginação
	public void vizualizar(Scanner scanner) {
		System.out.println("qual pagina voce deseja consultar");
		Integer page = scanner.nextInt();
		Pageable pageable = PageRequest.of(page, 5, Sort.unsorted());
		Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);
		//tamanho do de pagina
		System.out.println(funcionarios);
		System.out.println("pagina atual "+funcionarios.getNumber());
		System.out.println("quantidade "+funcionarios.getTotalElements());
		funcionarios.forEach(func -> System.out.println(func));
		
	}
	
	
	
	


}
