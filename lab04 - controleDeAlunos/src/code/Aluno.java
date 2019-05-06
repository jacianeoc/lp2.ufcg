package code;
/**
 * classe aluno sera responsavel por guardar nome , maticula e curso
 * e será resposavel por fazer a sua propria retresentacao textual 
 * @author jaci
 *
 */
public class Aluno {
	/**
	 * @param nome equivalente ao nome do aluno
	 */
	private String nome;
	/**
	 * @param matricula , equivalente a matricula do aluno
	 */
	private String matricula;
	/**
	 * @param curso , equivalene ao curso do aluno 
	 */
	private String curso;
	 
	/**
	 * metodo responsavel por validar as entradas
	 * @param matricula
	 * @param nome
	 * @param curso
	 * @return true se todas as entradas forem validas e false caso alguma seja nula 
	 */
	private boolean validaEntradasNull(String matricula, String nome, String curso) {
		
		if(matricula == null || nome == null || curso == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * metodo responsavel por validar as entradas 
	 * @param matricula
	 * @param nome
	 * @param curso
	 * @return true caso se todas as entradas forem validas e false caso alguma tenha o valor vazio 
	 */
	private boolean validaEntradas(String matricula, String nome, String curso) {
			
			if("".equals(nome.trim()) || "".equals(matricula.trim()) || "".equals(curso.trim())) {
				return false;
			}
			return true;
	}
	/**
	 * construtor que será responsavel por inicializar a classe 
	 * @param matricula
	 * @param nome
	 * @param curso
	 */
	public Aluno(String matricula, String nome, String curso) {
		
		if(validaEntradas(matricula, nome, curso) && validaEntradasNull(matricula, nome, curso)) {
			this.matricula = matricula;
			this.nome = nome; 
			this.curso = curso; 
			
		} else if (!(validaEntradas(matricula, nome, curso)) && validaEntradasNull(matricula, nome, curso)) {
			throw new IllegalArgumentException("nao pode ter espaco vazio");
			
		} else {
			throw new NullPointerException("nao pode ter entrada nula");
		}	
	}
	/**
	 * metodo toString que sera responsavel por criar a respresentacao textual da classe aluno
	 */
	public String toString () {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}
	/**
	 * para ver se não tem ninguem igual pelo o seu numero na memoria
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
		}

	/**
	 * para ver se nao tem niguem igual por comparacao de seus valores (nome , matricula e curso)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
			} else if (!matricula.equals(other.matricula))
				return false;
		return true;
		}
		
}
	
	


