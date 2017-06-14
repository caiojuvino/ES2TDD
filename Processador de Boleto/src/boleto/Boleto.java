package boleto;

import java.util.Date;

public class Boleto {
	public int codigo;
	public String data;
	public double valorPago;
	
	public Boleto(int codigo, String data, double valorPago) {
		this.codigo = codigo;
		this.data = data;
		this.valorPago = valorPago;
	}
}
