package exercicioes2;

public class Funcionario {

	String nome, email, cargo;
	double salarioBase;
	
	public Funcionario(String nome, String email, double salarioBase, String cargo) {
		this.cargo = cargo;
		this.nome = nome;
		this.email = email;
		this.salarioBase = salarioBase;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
		
	}

	public String getCargo() {
		return cargo;
	}

	public double getSalario() {
		return salarioBase;
	}

	public void setSalario(double salario) {
		this.salarioBase = salario;
		
	}

	
}
