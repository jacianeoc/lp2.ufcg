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
		
		//se quiser faz com for each que fica até mais bonitinho e legivel 
		for (int i = 0 ; i < corredores.size(); i++){
			if(cpf.equals(corredores.get(i).getCpf())){
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
	
	public String exibirCategoriaCorredor(String cpf) {
		
		for(Corredor c : corredores) { 
			if(cpf.equals(c.getCpf())){ 
				return c.getCategoria(); 
			}
		}
		 
		throw new IllegalArgumentException("cpf nao cadastrado");
	}
	
	public String exibirCorredor(String cpf) {
		for(Corredor c : corredores) {
			if(cpf.equals(c.getCpf())){
				return c.toString();
			}
		}
		throw new IllegalArgumentException("cpf nao cadastrado");
	}
	
	public void cadastrarTreinoCorredor(String cpf, double distancia, int tempoEsperado, String descricao) {
		for (int i = 0 ; i < corredores.size(); i++){
			if(cpf.equals(corredores.get(i).getCpf())){
				corredores.get(i).cadastraTreino(distancia, tempoEsperado, descricao);
			}
		}
		
	}
	
	public void finalizarTreino(String cpf, int indice, int tempoGasto) {
		for (int i = 0 ; i < corredores.size(); i++){
			if(cpf.equals(corredores.get(i).getCpf())){
				corredores.get(i).finalizarTreino(indice, tempoGasto);
			}
		}
	}
	
	public int contarTreinosFinalizadosCorredor(String cpf){
		int total = 0 ;
		for (int i = 0 ; i < corredores.size(); i++){
			if(cpf.equals(corredores.get(i).getCpf())){
				 total =  corredores.get(i).treinosFinalizados();
			}
		}
		return total;
		
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
