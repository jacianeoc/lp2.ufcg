package code;

import java.util.HashSet;
import java.util.Set;
/**
 * classe grupo cuja funcao será criar objetos do tipo grupo 
 * e guardará uma lista de alunos que fazem parte desse grupo
 * @author jaciane
 *
 */
public class Grupo {
	/**
	 * @param nome, reponsavel por guardar o nome do grupo
	 */
	private String nome;
	
	/**
	 * @param alunosNoGrupo , uma coleção de alunos que seram adicionados no grupo
	 */
	private Set<Aluno> alunosNoGrupo;
	
	/**
	 * metodo responvavel por verificar se o nome do grupo é valido
	 * @param nome
	 * @return true se o nome for valido e lancara uma excecao se nao
	 */
	private boolean validaEntrada(String nome) {
		if("".equals(nome.trim())) {
			throw new IllegalArgumentException("nome do grupo nao pode ser vazio");
		}
		if (nome == null) {
			throw new NullPointerException("nome do grupo nao pode ser nulo");
		} else {
			return true;
		}
		
	}
	/**
	 * contrustor responvel por inicializar a classe
	 * @param nome
	 */
	public Grupo(String nome) {
		if(validaEntrada(nome)) {
			alunosNoGrupo = new HashSet<>();
			this.nome = nome;
			
		}
	}
	/**
	 * metodo que adiciona alunos na colecao de alunosNoGrupo, onde não há repeticao 
	 * de alunos
	 * @param aluno
	 * @return true , caso o aluno for adicionado
	 */
	public boolean addAluno(Aluno aluno) {
		if(aluno == null) {
			throw new NullPointerException("nao existe aluno aqui :)"); // <- até parece que nao ta quase quebrando 
		} else {
			this.alunosNoGrupo.add(aluno);
			return true;
		}
			
	}
	/**
	 * metodo que lista todos os alunos presentes no grupo 
	 * @return string de alunos
	 */
	public String listaAlunos() {
		String saida = "";
		for (Aluno sofredores : alunosNoGrupo) {
			saida += sofredores.toString() + "\n";
		}
		return saida;
	}
	
	/**
	 * hash code para  termos umas representacao mumerica de onde se localiza em sua memoria 
	 * com o intuito de não haver repediçoes de mesmos objectos 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	/**
	 * metodo equals para que não aja repedicao do mesmo objeto grupo na memoria
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
