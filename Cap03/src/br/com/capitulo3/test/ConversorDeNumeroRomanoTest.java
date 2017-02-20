package br.com.capitulo3.test;

import org.junit.Test;
import static org.junit.Assert.*;
import br.com.capitulo3.model.ConversorDeNumeroRomano;

public class ConversorDeNumeroRomanoTest {
	
	@Test
	public void deveEntenderOSimboloI(){
		ConversorDeNumeroRomano romano = new ConversorDeNumeroRomano();
		int numero = romano.converte("I");
		assertEquals(1, numero);
	}//deveEntenderOSimboloI()
	
	@Test
	public void deveEntenderOSimboloV() {
		ConversorDeNumeroRomano romano = new ConversorDeNumeroRomano();
		int numero = romano.converte("V");
		assertEquals(5, numero);
	}//deveEntenderOSimboloV()
	
	@Test
	public void deveEntenderDoisSimbolosComoII() {
		ConversorDeNumeroRomano romano = new ConversorDeNumeroRomano();
		int numero = romano.converte("II");
		assertEquals(2, numero);
	}//deveEntenderDoisSimbolosComoII()
	
	@Test
	public void deveEntenderQuatroSimbolosDoisADoisComoXXII(){
		ConversorDeNumeroRomano romano = new ConversorDeNumeroRomano();
		int numero = romano.converte("XXII");
		assertEquals(22, numero);
	}//deveEntenderQuatroSimbolosDoisADoisComoXXII()
	
	@Test
	public void deveEntenderNumerosComoIX(){
		ConversorDeNumeroRomano romano = new ConversorDeNumeroRomano();
		int numero = romano.converte("IX");
		assertEquals(9, numero);
	}//deveEntenderNumerosComoIX()
	
	@Test
	public void deveEntenderNumerosComplexosComoXXIV() {
		ConversorDeNumeroRomano romano = new ConversorDeNumeroRomano();
		int numero = romano.converte("XXIV");
		assertEquals(24, numero);
	}//deveEntenderNumerosComplexosComoXXIV()
}//class ConversorDeNumeroRomanoTest
