package teste;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import boleto.Boleto;
import boleto.Fatura;
import boleto.Pagamento;
import boleto.Processador;

public class ProcessadorTeste {

	@Test
	public void testaConstrutores() {
		Pagamento p = new Pagamento(0, null, "");
		Assert.assertTrue(p != null);
		Boleto b = new Boleto(0, null, 0);
		Assert.assertTrue(b != null);
		Fatura f = new Fatura(null, 0, "");
		Assert.assertTrue(f != null);
	}
	
	@Test
	public void testaProcessador() {
		Boleto b1 = new Boleto(1, "10-02-2017", 500);
		Boleto b2 = new Boleto(2, "10-03-2017", 400);
		Boleto b3 = new Boleto(3, "10-04-2017", 600);
		ArrayList<Boleto> boletos = new ArrayList<>();
		boletos.add(b1);
		boletos.add(b2);
		boletos.add(b3);
		Fatura fatura = new Fatura("10-01-2017", 1500, "Cliente 1");
		
		ArrayList<Pagamento> pagamentos = Processador.processar(boletos, fatura);
		Assert.assertTrue(fatura.status.equals("PAGA"));
		Assert.assertTrue(pagamentos != null);
		Assert.assertTrue(pagamentos.size() == boletos.size());
		
		b1.valorPago = 400;
		b2.valorPago = 500;
		b1.valorPago = 300;
		fatura.valorTotal = 2000;
		fatura.status = "NAO PAGA";
		
		Assert.assertFalse(fatura.status.equals("PAGA"));
		Assert.assertTrue(pagamentos != null);
		Assert.assertTrue(pagamentos.size() == boletos.size());
		
		b1.valorPago = 25;
		b2.valorPago = 12;
		b1.valorPago = 70;
		fatura.valorTotal = 0;
		fatura.status = "NAO PAGA";
		
		Assert.assertFalse(fatura.status.equals("PAGA"));
		Assert.assertTrue(pagamentos != null);
		Assert.assertTrue(pagamentos.size() == boletos.size());
		
		b1.valorPago = 0;
		b2.valorPago = 7;
		b1.valorPago = -1;
		fatura.valorTotal = 150;
		fatura.status = "NAO PAGA";
		
		Assert.assertFalse(fatura.status.equals("PAGA"));
		Assert.assertTrue(pagamentos != null);
		Assert.assertTrue(pagamentos.size() == boletos.size());
		
		b1.valorPago = 0;
		b2.valorPago = 0;
		b1.valorPago = 0;
		fatura.valorTotal = -19;
		fatura.status = "NAO PAGA";
		
		Assert.assertFalse(fatura.status.equals("PAGA"));
		Assert.assertTrue(pagamentos != null);
		Assert.assertTrue(pagamentos.size() == boletos.size());
		
		b1.valorPago = 30;
		b2.valorPago = 50;
		b1.valorPago = -700;
		fatura.valorTotal = -1000;
		fatura.status = "NAO PAGA";
		
		Assert.assertFalse(fatura.status.equals("PAGA"));
		Assert.assertTrue(pagamentos != null);
		Assert.assertTrue(pagamentos.size() == boletos.size());
	}
}
