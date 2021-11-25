package com.testeweb.course.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.web.PageableArgumentResolver;

import com.testeweb.course.entities.Funcionario;
//metodo de paginação -> para listar numeros desejados de arquivos
public interface FuncionarioRepository extends  PagingAndSortingRepository<Funcionario, Integer>{
	//listaFuncionario -> QueryCreate
	List<Funcionario> findByNome(String nome);
	
	//JPQL CRIANDO QUERY ->PENSONALIZADAS
	/*fizéssemos um novo relatório para eles que informado o nome,
	 *  a data de contratação e um salário maior do que o informado no filtro,
	 *   deve-se retornar todos os funcionários que se encaixarem nessa filtragem.
	 * */
	@Query("SELECT f FROM Funcionario f WHERE f.nome = :nome "
			+ "AND f.salario >= :salario AND f.dataContratacao = :dataContratacao")
	List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate dataContratacao);
	
}
