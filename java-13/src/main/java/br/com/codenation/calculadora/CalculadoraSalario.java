package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		double salariob = salarioBase;
		double salarioinss;
		double salarioirpf;

		if(salariob < 1039) {
			salarioirpf = 0;
		}else{
			salarioinss = calcularInss(salariob);
			salarioirpf = calcularIrpf(salarioinss);
		}
		return Math.round(salarioirpf);
	}

	private double calcularInss(double salarioBase) {
		double salariob1 = salarioBase;
		double salarioinss;

		if(salariob1 <= 1500){
			salarioinss = salariob1-(salariob1*0.08);
		}else if (salariob1 > 1500 && salariob1 <= 4000){
			salarioinss = salariob1-(salariob1*0.09);
		}else{
			salarioinss = salariob1-(salariob1*0.11);
		}

		return salarioinss;
	}

	private double calcularIrpf(double salarioBase) {

		double salariob2 = salarioBase;
		double salarioirpf;

		if(salariob2 <= 3000){
			salarioirpf = salariob2;
		}else if (salariob2 > 3000 && salariob2 <= 6000){
			salarioirpf = salariob2 -(salariob2 *0.075);
		}else{
			salarioirpf = salariob2 -(salariob2 *0.15);
		}

		return salarioirpf;
	}

}
