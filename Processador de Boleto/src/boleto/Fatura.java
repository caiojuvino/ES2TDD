package boleto;

import java.util.Date;

public class Fatura {
	public String data;
	public double valorTotal;
	public String nomeDoCliente;
	public String status = "NAO PAGA";
	
	public Fatura(String data, double total, String nomeDoCliente) {
		this.data = data;
		this.valorTotal = total;
		this.nomeDoCliente = nomeDoCliente;
	}

}
