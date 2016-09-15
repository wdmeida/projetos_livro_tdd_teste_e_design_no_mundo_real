package br.com.tdd.capitulo4.teste;

import static org.junit.Assert.*;
import org.junit.Test;

import br.com.tdd.capitulo4.controller.CalculadoraDeSalario;
import br.com.tdd.capitulo4.model.Cargo;
import br.com.tdd.capitulo4.model.Funcionario;

/*
 * Regras de negócios:
	 * Desenvolvedores possuem 20% de desconto caso seu salário seja maior do que R$ 3000,00.
	   Caso contrário, o desconto é de 10%.
	 * DBAs e testadores possuem desconto de 25% se seus salários forem maiores do que R$ 2500,00.
	   15%, em caso contrário.
 */
public class CalculadoraDeSalarioTest {
	
	/*
	 * O primeiro cenário a ser testado será o de desenvolvedores com salários menor do que R$ 3000,00.
	 * Sabemmos que o desconto é de 10%. Portanto, se o desenvolvedor ganhar R$ 1500,00, seu sálário
	 * menos desconto deve ser de R$ 1350,00 (1500 * 90%):
	 */
	@Test
	public void deveCalcularSalarioParaDesenvolvedoresComSalarioAbaixoDoLimite() {
		
		CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
		Funcionario desenvolvedor = new Funcionario("Wagner", 1500.0, Cargo.DESENVOLVEDOR);
		
		double salario = calculadora.calculaSalario(desenvolvedor);
		
		assertEquals(1500.0 * 0.9, salario, 0.00001);
	}
	
	/*
	 * Vamos ao próximo cenário: desenvolvedores que ganham mais do que R$ 3000,0. O teste é bem
	 * similar ao anterior:
	 */
	@Test
	public void deveCalcularSalarioParaDesenvolvedoresComSalarioAcimaDoLimite() {
		
		CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
		Funcionario desenvolvedor = new Funcionario("Wagner", 4000.0, Cargo.DESENVOLVEDOR);
		
		double  salario = calculadora.calculaSalario(desenvolvedor);
		
		assertEquals(4000.0 * 0.8, salario, 0.00001);
	}
	
	/*
	 * O príxmo teste agora garante que DBAS com salários inferioes a R$ 1500,00 recebem 15%
	 * de desconto:
	 */
	@Test
	public void deveCalcularSalarioParaDBAsComSalarioAbaixoDoLimite() {
		
		CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
		Funcionario desenvolvedor = new Funcionario("Wagner", 500.0, Cargo.DBA);
		
		double salario = calculadora.calculaSalario(desenvolvedor);
		
		assertEquals(500.0 * 0.85, salario, 0.00001);
	}
	
}//class CalculadoraDeSalarioTest
