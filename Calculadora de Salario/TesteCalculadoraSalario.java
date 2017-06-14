package exercicioes2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteCalculadoraSalario {

	CalculadoraSalario calculo;
	Funcionario ger, dev, tes, dba;
	
	@Before
	public void init(){
		
		ger = new Funcionario("gerente", "as", 2500, "GERENTE");
		dev = new Funcionario("deve", "1as", 5000, "DESENVOLVEDOR");
		dba = new Funcionario("dba", "email", 2000, "DBA");
		tes = new Funcionario("tes", "email1", 2000, "TESTADOR");
		
		calculo = new CalculadoraSalario();
	}
	
	@Test
	public void testaFuncionario() {
		assertEquals(ger.getCargo(), "GERENTE");
		
		ger.setCargo("TESTADOR");
		
		assertEquals(ger.getCargo(), "TESTADOR");
		assertNotEquals(ger.getCargo(), "DESENVOLVEDOR");
	}
	
	@Test
	public void testaSalarioFuncionario() {
		ger.setSalario(4000.00);
		assertEquals(4000.0, ger.getSalario(), 0.0);
		
		ger.setSalario(9000.00);
		
		assertEquals(9000.00, ger.getSalario(), 0.0);
		
	}

	@Test
	public void testaSalarioLiquido(){
		
		double salarioGerente = calculo.calculaSalario(ger);
		assertEquals(2000.00, salarioGerente, 0.0);
		
		ger.setSalario(8000);
		salarioGerente = calculo.calculaSalario(ger);
		
		assertEquals(5600.00, salarioGerente, 0.0);
		
		double salarioDesen = calculo.calculaSalario(dev);
		assertEquals(4000.00, salarioDesen, 0.0);
		
		double salarioTest = calculo.calculaSalario(tes);
		assertEquals(1500.00, salarioTest, 0.0);
		
		tes.setSalario(1999.00);
		salarioTest = calculo.calculaSalario(tes);
		
		assertEquals(1699.15, salarioTest, 0.0);
		
		tes.setCargo("DBA");
		
		salarioTest = calculo.calculaSalario(tes);
		
		assertEquals(1699.15, salarioTest, 0.0);
		
		tes.setCargo("GERENTE");
		
		salarioTest = calculo.calculaSalario(tes);
		
		assertNotEquals(1699.15, salarioTest, 0.0);
	}
	
}
