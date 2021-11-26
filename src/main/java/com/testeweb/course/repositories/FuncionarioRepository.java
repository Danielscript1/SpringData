package com.testeweb.course.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.testeweb.course.entities.Funcionario;
import com.testeweb.course.entities.FuncionarioProjecao;
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
	
	/* Agora que nós já estamos entregando bastante coisa para o pessoal da Recrutei
	 *  e bastante coisa bem rápida graças ao Spring Data, 
	 *  eles solicitaram mais algumas coisas aqui para nós. 
	 *  Solicitaram mais um relatório. 
	 *  E no que esse relatório tem de apresentar para o pessoal da Recrutei? 
	 *  Pelo funcionário eles querem saber quais são os funcionários que recebem o maior salário dentro da companhia.
	 * */
	@Query(value = "select f.id ,f.nome,f.salario from tb_funcionario f ",nativeQuery = true)
	List<FuncionarioProjecao> findFuncionaroSalario();
	
}
