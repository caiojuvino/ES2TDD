package exercicioes2;

public class CalculadoraSalario {
	
	
	
	public CalculadoraSalario() {
		// TODO Auto-generated constructor stub
	}
	
	public double calculaSalario(Funcionario funcionario){
		double salario = funcionario.getSalario();
		double salarioLiquido = 0.0;
		String cargo = funcionario.getCargo().toLowerCase();
		
		if(cargo.equals("desenvolvedor")){
			if(salario >= 3000.00)
				salarioLiquido = salario-(salario * 0.2);
			else{
				salarioLiquido = salario-(salario * 0.1);
			}
		}
		
		if(cargo.equals("dba") || cargo.equals("testador")){
			if(salario >= 2000.00)
				salarioLiquido = salario-(salario * 0.25);
			else{
				salarioLiquido = salario-(salario * 0.15);
			}
		}
		
		if(cargo.equals("gerente")){
			if(salario >= 5000.00)
				salarioLiquido = salario-(salario * 0.3);
			else{
				salarioLiquido = salario-(salario * 0.2);
			}
		}
		return salarioLiquido;
	}
	
	
	
}
