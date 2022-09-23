import com.algaworks.ItemPedido;
import com.algaworks.Pedido;
import com.algaworks.QuantidadeItensInvalidaException;
import com.algaworks.desconto.CalculadoraDescontoSegundaFaixa;
import com.algaworks.desconto.CalculadoraFaixaDesconto;
import com.algaworks.desconto.CalculadoraPrimeiraFaixa;
import com.algaworks.desconto.SemDesconto;

public class PedidoBuilder {

	private Pedido instancia;
	
	public PedidoBuilder() {
		CalculadoraFaixaDesconto calculadoraFaixaDesconto =
				new CalculadoraDescontoSegundaFaixa(
						new CalculadoraPrimeiraFaixa(
								new SemDesconto(null)));
		instancia = new Pedido(calculadoraFaixaDesconto);
	}
	
	public PedidoBuilder comItem(double valorUnitario, int quantidade) throws QuantidadeItensInvalidaException {
		instancia.adicionarItem(new ItemPedido("Gerado", valorUnitario, quantidade));
		return this;
	}
	
	public Pedido construir() {
		return instancia;
	}
}
