package br.capitulo4.controller;

import br.capitulo4.model.Cargo;
import br.capitulo4.model.Funcionario;

public class CalculadoraDeSalario {
	
	public double calculaSalario(Funcionario funcionario){
		if(funcionario.getCargo().equals(Cargo.DESENVOLVEDOR))
			return (funcionario.getSalario() > 3000) ? 3200.0 : 1350.0;
		return 425.0;
	}
	
}
