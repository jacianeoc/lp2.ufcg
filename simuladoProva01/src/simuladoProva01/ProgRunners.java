package simuladoProva01;

import java.util.ArrayList;
import java.util.List;


public class ProgRunners {
	
	private List<Corredor> corredores;
	
	public ProgRunners() {
		this.corredores= new ArrayList<>();
	}
	
	//cadastrar corredores e treinos, alocar treino a corredor
	//e acompanhar execução do treino.
	
	//O cpf identifica unicamente cada corredor. 
	public void cadastrarProgramador (String nome, String cpf, int anoDeNascimento) {
		// é um Corredor com nome, cpf e ano de nascimento
		Corredor c = new Corredor(nome, cpf, anoDeNascimento);
		
		for(Corredor c1 : corredores) {
			if(cpf.equals(c1.getCpf())){
				throw new IllegalArgumentException("o corredor ja esta cadastrado");
			}
		}
		
			corredores.add(c);
		
	}
	 //Na listagem de um corredor deve aparecer nome-cpf-categoria
	public String listarCorredores() {
		String saida = "";
		
		for(Corredor c : corredores) {
			saida += c.toString() + System.lineSeparator();
		}
		
		return saida;
	}
	
	public String exiberCategoriaCorredor(String cpf) {
		for(Corredor c : corredores) {
			if(cpf.equals(c.getCpf())){
				return c.getCategoria();
			}
		}
		throw new IllegalArgumentException("cpf nao cadastrado");
	}
	
	public String exiberCorredor(String cpf) {
		for(Corredor c : corredores) {
			if(cpf.equals(c.getCpf())){
				return c.toString();
			}
		}
		throw new IllegalArgumentException("cpf nao cadastrado");
	}
	
	public void cadastrarTreinoCorredor(String cpf, double distancia, int tempoEsperado, String descricao) {
		for(Corredor c : corredores) {
			if(cpf.equals(c.getCpf())){
				c.cadastraTreino(distancia,tempoEsperado, descricao);
			}
		}
		throw new IllegalArgumentException("cpf nao cadastrado");
	}
	
	public void finalizarTreino(String cpf, int indice, int tempoGasto) {
		for(Corredor c : corredores) {
			if(cpf.equals(c.getCpf())){
				c.finalizarTreino(indice, tempoGasto);
			}
		}
		throw new IllegalArgumentException("cpf nao cadastrado");
	}
	
	public int contarTreinosFinalizadosCorredor(String cpf){
		for(Corredor c : corredores) {
			if(cpf.equals(c.getCpf())){
				return c.treinosFinalizados();
			}
		}
		throw new IllegalArgumentException("cpf nao cadastrado");
	}
	
	public double resistenciaCorredor(String cpf) {
		for(Corredor c : corredores) {
			if(cpf.equals(c.getCpf())){
				return c.resistenciaCorredor();
			}
		}
		throw new IllegalArgumentException("cpf nao cadastrado");
	}

	// verificacao de duas coisinhas sao iguais ou nao 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corredores == null) ? 0 : corredores.hashCode());
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
		ProgRunners other = (ProgRunners) obj;
		if (corredores == null) {
			if (other.corredores != null)
				return false;
		} else if (!corredores.equals(other.corredores))
			return false;
		return true;
	}
	
}
