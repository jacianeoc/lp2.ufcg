package simuladoProva01;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Corredor {

	private int anoDeNascimento;
	private String cpf;
	private String nome;

	public Corredor(String nome, String cpf, int anoDeNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.anoDeNascimento = anoDeNascimento;
	}

	// dá para fazer um enum aqui mais eu nao to  querendo fazer nao 
	//pode ser que ele não se classifique nisso, hahaha vai que ele seja abaixo de 15 anos
	public String getCategoria() {
		String categoria = "";
		
		int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
		int idade = anoAtual - anoDeNascimento;
		if(idade >= 15 && idade <= 24) {
			categoria = "JOVEM";
		}
		if(idade >= 25 && idade <= 40) {
			categoria = "ADULTO";
		}
		if(idade >= 41 && idade <= 64) {
			categoria = "SUPER_ADULTO";
		}
		if(idade >=65) {
			categoria = "MELHOR_IDADE";
		}
		
		return categoria;
	}

	@Override
	public String toString() {
		return  this.nome + " - " + this.cpf + " - " + getCategoria();
	} 
	
	
}
