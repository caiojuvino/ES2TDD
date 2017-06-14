package boleto;

import java.util.ArrayList;

public class Processador {

	 public static ArrayList<Pagamento> processar(ArrayList<Boleto> boletos, Fatura fatura) {
		double soma = 0;
		ArrayList<Pagamento> pagamentos = new ArrayList<>();

		for (Boleto boleto : boletos) {
			soma += boleto.valorPago;
			pagamentos.add(new Pagamento(boleto.valorPago, boleto.data, "BOLETO"));
		}

		if (soma >= fatura.valorTotal) {
			fatura.status = "PAGA";
		}

		return pagamentos;
	}
}
