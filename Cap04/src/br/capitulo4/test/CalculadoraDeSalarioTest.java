package br.capitulo4.test;

import org.junit.Test;

import br.capitulo4.controller.CalculadoraDeSalario;
import br.capitulo4.model.Cargo;
import br.capitulo4.model.Funcionario;

import static org.junit.Assert.*;

public class CalculadoraDeSalarioTest {
	/*
	 * O primeiro cenário a ser testado será de desenvolvedores com salário
	 * menor do que R$ 3000,00. O Desconto será de 10%. Portanto, se o desenvolvedor
	 * ganhar R$ 1500,00, seu salário com o desconto deve ser de R$ 1350,00. (1500 * 90%).
	 */
	@Test
	public void deveCalcularSalarioParaDesenvolvedoresComSalarioAbaixoDoLimite() {
		
		CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
		Funcionario desenvolvedor = new Funcionario("Wagner", 1500.00, Cargo.DESENVOLVEDOR);
		
		double salario = calculadora.calculaSalario(desenvolvedor);
		
		assertEquals(1500.00 * 0.9, salario, 0.00001);
	}//deveCalcularSalarioParaDesenvolvedoresComSalarioAbaixoDoLimite()
	
	//Testa agora desenvolvedores que recebem acima do limite (R$ 3500,00) e tem desconto de 20%.
	@Test
	public void deveCalcularSalarioParaDesenvolvedoresComSalarioAcimaDoLimite() {
		
		CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
		Funcionario desenvolvedor = new Funcionario("Wagner", 4000.00, Cargo.DESENVOLVEDOR);
		
		double salario = calculadora.calculaSalario(desenvolvedor);
		
		assertEquals(4000.00 * 0.8, salario, 0.00001);
	}//deveCalcularSalarioParaDesenvolvedoresComSalarioAcimaDoLimite()
	
	//Testa agora dbas que recebem abaixo do limite (R$ 1500,00) e tem desconto de 15%.
	@Test
	public void deveCalcularSalarioParaDBAsComSalariosAbaixoDoLimite() {

		CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
		Funcionario desenvolvedor = new Funcionario("Wagner", 500.00, Cargo.DBA);
		
		double salario = calculadora.calculaSalario(desenvolvedor);
		
		assertEquals(500.00 * 0.85, salario, 0.00001);
	}//deveCalcularSalarioParaDBAsComSalariosAbaixoDoLimite()
}//class CalculadoraDeSalarioTest
