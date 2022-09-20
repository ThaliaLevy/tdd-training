package controlTestes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import control.Exemplo;

public class ExemploTestes {
	private Exemplo exemplo;

	@Before			//roda antes de cada teste
	public void setup() {
		exemplo = new Exemplo();
	}

	@Test
	public void deveConverterNomeSimples() throws Exception {
		assertEquals("Tesla", exemplo.converterNomeSimples("tesla"));
	}
	
	@Test
	public void deveConverterNomeSimplesMisturadoMaiusculoEMinusculo() throws Exception {
		assertEquals("Tesla", exemplo.converterNomeSimples("tEsLa"));
	}
}
