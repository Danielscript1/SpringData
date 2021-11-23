package com.testeweb.course.services;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.testeweb.course.entities.Cargo;
import com.testeweb.course.entities.Funcionario;
import com.testeweb.course.repositories.CargoRepository;
import com.testeweb.course.repositories.FuncionarioRepository;
@Service
public class CrudFuncionarioService {

	//variavel
		private final FuncionarioRepository funcionarioRepository;
		//constructor
		public CrudFuncionarioService(FuncionarioRepository funcionarioRepository) {
			this.funcionarioRepository = funcionarioRepository; 
		}
		
		//iniciar 
		public void iniciar(Scanner scanner) {
			salvar(scanner);
		}
		//salvar
		public void salvar(Scanner scanner) {
			System.out.println("digite o dados do funcionario!");
			Funcionario func1 = new Funcionario(null, "samuel", null, null, null, null);
			funcionarioRepository.save(func1);
			System.out.println("funcionario salvo!!!");
		}

}
