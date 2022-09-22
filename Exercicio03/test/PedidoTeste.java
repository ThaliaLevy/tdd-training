import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.algaworks.ResumoPedido;

public class PedidoTeste {
	private PedidoBuilder pedido;
	
	@Before
	public void setup() {	
		pedido = new PedidoBuilder();
	}
	
	@Test
	public void devePermitirAdicionarItemAoPedido() throws Exception {
		pedido.comItem(15.0, 2);
	}
	
	public void assertResumoPedido(double valorTotal, double desconto) {
		ResumoPedido resumoPedido = pedido.construir().resumo();
		assertEquals(valorTotal, resumoPedido.getValorTotal(), 0.0001);
		assertEquals(desconto, resumoPedido.getDesconto(), 0.0001);
	}
	
	@Test
	public void deveCalcularValorTotalEDescontoParaPedidoVazio() throws Exception {
		 assertResumoPedido(0.0, 0.0);
	}
	
	@Test
	public void deveCalcularValorTotalSemDescontoParaItem() throws Exception {
		pedido.comItem(12.0, 2);
		assertResumoPedido(24.0, 0.0);
	}
	
	@Test
	public void deveCalcularValorTotalDoisItensSemDesconto() throws Exception {
		pedido.comItem(2.0, 3)
				.comItem(5.0, 5);
		
		assertResumoPedido(31.0, 0.0);
	}
	
	@Test
	public void deveAplicarDescontoNa1aFaixa() throws Exception {
		pedido.comItem(100.0, 4);
		assertResumoPedido(400.0, 16.0);
	}
	
	@Test
	public void deveAplicarDescontoNa2aFaixa() throws Exception {
		pedido.comItem(1000.0, 1);
		assertResumoPedido(1000.0, 100.0);
	}
}
