import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.algaworks.ItemPedido;
import com.algaworks.Pedido;
import com.algaworks.ResumoPedido;
import com.algaworks.desconto.CalculadoraDescontoSegundaFaixa;
import com.algaworks.desconto.CalculadoraFaixaDesconto;
import com.algaworks.desconto.CalculadoraPrimeiraFaixa;
import com.algaworks.desconto.SemDesconto;

public class PedidoTeste {
	private Pedido pedido;
	
	@Before
	public void setup() {	
		CalculadoraFaixaDesconto calculadoraFaixaDesconto =
				new CalculadoraDescontoSegundaFaixa(
						new CalculadoraPrimeiraFaixa(
								new SemDesconto(null)));
		pedido = new Pedido(calculadoraFaixaDesconto);
	}
	
	@Test
	public void devePermitirAdicionarItemAoPedido() throws Exception {
		pedido.adicionarItem(new ItemPedido("Shampoo", 15.0, 2));
	}
	
	/*	forma 01:
	@Test
	public void deveCalcularValorTotalEDescontoParaPedidoVazio() throws Exception {
		assertEquals(0.0, pedido.calcularTotalPedido(), 0.0001);
		assertEquals(0.0, pedido.calcularDesconto(), 0.0001);
	}
	
		forma 02:
	*/
	
	public void assertResumoPedido(double valorTotal, double desconto) {
		ResumoPedido resumoPedido = pedido.resumo();
		assertEquals(valorTotal, resumoPedido.getValorTotal(), 0.0001);
		assertEquals(desconto, resumoPedido.getDesconto(), 0.0001);
	}
	
	@Test
	public void deveCalcularValorTotalEDescontoParaPedidoVazio() throws Exception {
		 assertResumoPedido(0.0, 0.0);
	}
	
	@Test
	public void deveCalcularValorTotalSemDescontoParaItem() throws Exception {
		pedido.adicionarItem(new ItemPedido("Condicionador", 12.0, 2));
		assertResumoPedido(24.0, 0.0);
	}
	
	@Test
	public void deveCalcularValorTotalDoisItensSemDesconto() throws Exception {
		pedido.adicionarItem(new ItemPedido("Sabonete", 2.0, 3));
		pedido.adicionarItem(new ItemPedido("Pasta de dente", 5.0, 5));
		assertResumoPedido(31.0, 0.0);
	}
	
	@Test
	public void deveAplicarDescontoNa1aFaixa() throws Exception {
		pedido.adicionarItem(new ItemPedido("Liquidificador", 100.0, 4));
		assertResumoPedido(400.0, 16.0);
	}
	
	@Test
	public void deveAplicarDescontoNa2aFaixa() throws Exception {
		pedido.adicionarItem(new ItemPedido("Máquina de lavar", 1000.0, 1));
		assertResumoPedido(1000.0, 100.0);
	}
}
