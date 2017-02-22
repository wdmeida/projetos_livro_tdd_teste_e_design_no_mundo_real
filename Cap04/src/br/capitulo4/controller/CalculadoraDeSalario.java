package br.capitulo4.controller;

import br.capitulo4.model.Funcionario;

public class CalculadoraDeSalario {
	
	public double calculaSalario(Funcionario funcionario){
		return funcionario.getCargo().getRegra().calcula(funcionario);
	}
	
}
