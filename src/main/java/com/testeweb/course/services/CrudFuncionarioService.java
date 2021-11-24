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
	private Boolean system = true;
		private final FuncionarioRepository funcionarioRepository;
		private final RelatorioService relatorioService;
		Scanner scanner = new Scanner(System.in);
		//constructor
		public CrudFuncionarioService(FuncionarioRepository funcionarioRepository,RelatorioService relatorioService) {
			this.funcionarioRepository = funcionarioRepository; 
			this.relatorioService = relatorioService;
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
				System.out.println("6 - buscar pensonalizada ");
				
				Integer opc = scanner.nextInt();
				switch(opc) {
				case 1:
					//vizualizar();
					
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
				case 6 :
					
					buscaPensonalizada();
					break;
				default:
					system = false;
				   }	
				 }	
		}
		public void buscaPensonalizada() {
			
			relatorioService.iniciar();
		}

		private void deletar() {
			// TODO Auto-generated method stub
			
		}

		private void pesquisar() {
			// TODO Auto-generated method stub
			
		}

		private void atualizar() {
			// TODO Auto-generated method stub
			
		}

		private void vizualizar(Scanner scanner) {
			// TODO Auto-generated method stub
			
		}

		//salvar
		public void salvar() {
			System.out.println("digite o dados do funcionario!");
			Funcionario func1 = new Funcionario(null, "samuel", null, null, null, null);
			funcionarioRepository.save(func1);
			System.out.println("funcionario salvo!!!");
		}

}
