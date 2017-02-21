package br.capitulo4.controller;

import br.capitulo4.model.Cargo;
import br.capitulo4.model.Funcionario;

public class CalculadoraDeSalario {
	
	public double calculaSalario(Funcionario funcionario){
		if(funcionario.getCargo().equals(Cargo.DESENVOLVEDOR))
			return (funcionario.getSalario() > 3000) ? 
									funcionario.getSalario() * 0.8: 
									funcionario.getSalario() * 0.9;
		return 425.0;
	}
	
}
