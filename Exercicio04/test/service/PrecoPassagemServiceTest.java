package service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Passageiro;
import model.TipoPassageiro;
import model.Voo;

public class PrecoPassagemServiceTest {
	private PrecoPassagemService precoPassagemService;
	
	@Before
	public void setup() {
		precoPassagemService = new PrecoPassagemService();
	}
	
	public void assertValorPassagem(Passageiro passageiro, Voo voo, double valorEsperado) {
		double valor = precoPassagemService.calcularValorPassagem(passageiro, voo);
		
		assertEquals(valorEsperado, valor, 0.0001);
	}
	
	
	@Test
	public void deveCalcularValorPassagemDePassageiroGoldComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		
		assertValorPassagem(passageiro, voo, 90.0);
	}
	
	@Test
	public void deveCalcularValorPassagemDePassageiroGoldComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 600.0);
		
		assertValorPassagem(passageiro, voo, 510.0);
	}
	
	@Test
	public void deveCalcularValorPassagemDePassageiroSilverComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		
		assertValorPassagem(passageiro, voo, 94.0);
	}
	
	@Test
	public void deveCalcularValorPassagemDePassageiroSilverComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 800.0);
		
		assertValorPassagem(passageiro, voo, 720.0);
	}
}
