package simuladoProva01;

import java.util.HashMap;
import java.util.Map;

public class ProgRunners {
	
	private Map<String, Corredor>corredores;
	
	public ProgRunners() {
		this.corredores= new HashMap<>();
	}
	
	//cadastrar corredores e treinos, alocar treino a corredor
	//e acompanhar execução do treino.
	
	//O cpf identifica unicamente cada corredor. 
	public void cadastraProgramador (String nome, String cpf, int anoDeNascimento) {
		// é um Corredor com nome, cpf e ano de nascimento
		if(corredores.containsKey(cpf)) {
			throw new IllegalArgumentException("o corredor ja esta cadastrado");
		} else {
			Corredor c = new Corredor(nome, cpf, anoDeNascimento);
			corredores.put(cpf, c);
		}
		
	}
	 //Na listagem de um corredor deve aparecer nome-cpf-categoria
	public String listarCorredores() {
		String saida = "";
		
		for(Corredor c : corredores.values()) {
			
		}
	}
}
