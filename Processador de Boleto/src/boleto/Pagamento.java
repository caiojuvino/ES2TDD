package boleto;

import java.util.Date;

public class Pagamento {
	double valorPago;
	String data;
	String tipo;
	
	public Pagamento(double valorPago, String data, String tipo) {
		this.valorPago = valorPago;
		this.data = data;
		this.tipo = tipo;
	}
}
