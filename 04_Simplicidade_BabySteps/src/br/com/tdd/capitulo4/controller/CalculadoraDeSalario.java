package br.com.tdd.capitulo4.controller;

import br.com.tdd.capitulo4.model.Funcionario;

public class CalculadoraDeSalario {
	
	/*
	 * Hora de fazer o teste passar. Mas lembre-se que a idéia é fazer o teste passar da maneira mais
	 * simples possível.
	 */
	public double calculaSalario(Funcionario funcionario){
		return funcionario.getSalario() > 3000 ? funcionario.getSalario() * 0.8: funcionario.getSalario() * 0.9;
	}
}
