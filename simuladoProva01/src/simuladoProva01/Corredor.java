package simuladoProva01;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

public class Corredor {

	private int anoDeNascimento;
	private String cpf;
	private String nome;
	private List<Treino> treinos;

	public Corredor(String nome, String cpf, int anoDeNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.anoDeNascimento = anoDeNascimento;
		this.treinos = new ArrayList<>();
	}

	public void cadastraTreino(double distancia, int tempoEsperado, String descricao) {
		Treino t = new Treino(distancia, tempoEsperado, descricao);
		treinos.add(t);
	} 
	
	public void finalizarTreino(int indice, int tempoGasto) {
		treinos.get(indice).finalizarTreino(tempoGasto);
	}

	public int treinosFinalizados() {
		int contador = 0;
		
		for(Treino t : treinos) {
			if("terminado".equals(t.getStatus())) {
				contador ++;
			}
		}
		return contador;
		
	}

	public double resistenciaCorredor() {
		int geralResistencia = 0;
		int cont = 0;
		
		for(int i = 0; i < treinos.size(); i++) {
			if("terminado".equals(treinos.get(i).getStatus())) {
				geralResistencia += treinos.get(i).GetResistencia();
				cont+= 1;
			}
		}
		if(cont == 0) {
			return 0;
			
		}else {
			double media = geralResistencia / cont;
			return media;
		
		}
	}

	// dá para fazer um enum aqui mais eu nao to  querendo fazer nao 
	//pode ser que ele não se classifique nisso, hahaha vai que ele seja abaixo de 15 anos
	public String getCategoria() {
		String categoria = "";
					
		int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
		int idade = anoAtual - anoDeNascimento;
					
		if(idade >= 15 && idade <= 24) {
			categoria = "JOVEM";
			
		} else if(idade >= 25 && idade <= 40) {
			categoria = "ADULTO";
			
		} else if(idade >= 41 && idade <= 64) {
			categoria = "SUPER_ADULTO";
			
		} else if(idade >= 65) {
			categoria = "MELHOR_IDADE";
			
		} else {
			throw new IllegalArgumentException("ou eh super genio por esta antes dos 15 na uni, ou eh do futuro");
		}
		
		return categoria;
	}
				
	public String getCpf() {
		return cpf;
	}
	
	@Override
	public String toString() {
		return  this.nome + " - " + this.cpf + " - " + getCategoria();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corredor other = (Corredor) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	
}
