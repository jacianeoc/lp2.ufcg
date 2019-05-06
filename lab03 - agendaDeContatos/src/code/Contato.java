package code;
/**
 * Class responsavel por guarda informacoes sobre um determinado contato e montar a sua representacao 
 * textual sobre ela 
 * @author jaci
 *
 */
public class Contato {
	/**
	 * @param nome  guardara a informacao de um nome recebido.
	 */
	private String nome;
	/**
	 * @param sobrenome do tipo string, guardara a informacao do sobrenome recebido.
	 */
	private String sobrenome;
	/**
	 * @param telefone do tipo string, guardara a informacao do telefone recebido em forma de um texto
	 */
	private String telefone;
	/**
	 * @param posicao do tipo string, para ser usado na representacao textual 
	 */
	private int posicao; 
	 /**
	  * Metodo privado e usado somente na sua propria classe, responsavel por validar as entradas 
	  * recebidas para a contracao do objeto, retornando um boolean
	  * @param nome
	  * @param sobrenome
	  * @param telefone
	  * @return true caso as entradas forem todas corretas, false caso alguma entrada imposibilite o codigo rodar de forma correta 
	  */
	private boolean validaEntradas(String nome, String sobrenome, String telefone) {
			
			if (nome == null || "".equals(nome.trim())) {
				return false;
				
			} else if (sobrenome == null || "".equals(sobrenome.trim())) {
				return false;
				
			} else if (telefone  == null || "".equals(telefone.trim())) {
				return false;
				
			} else {
				return true;
			}
			
	}
	/**
	 * Construtor contato com a funcao de inicializar a classe 
	 * caso tenha alguma entrada inviavel o construtor ira lancar uma excecao do tipo 
	 * illegal argument exception
	 * @param nome
	 * @param sobrenome
	 * @param telefone
	 * @param posicao
	 * @return uma excecao caso tenha alguma entrada invalida
	 */
	public Contato(String nome, String sobrenome, String telefone, int posicao) {
		
		if (validaEntradas(nome, sobrenome, telefone)) {
			
			this.nome = nome;
			this.telefone= telefone;
			this.sobrenome = sobrenome;
			this.posicao = posicao;
			
		} else {
			throw new IllegalArgumentException("entrada nao pode ser vazia ou nula");
		}
		
	}
	/**
	 * Metodo que retorna o nome do contato 
	 * @return nome do contato 
	 */
	public String getNome() {
		return this.nome;
	}
	/**
	 * Metodo que retorna o sobrenome do contato
	 * @return sobrenome do contato
	 */
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	/**
	 * Metodo que retorna uma representacao textual sobre o contato 
	 * @return uma representacao textal contendo o nome, sobrenome e o telefone do 
	 * contato
	 */
	public String toString() {
		return this.nome + " " + this.sobrenome  + " - " + this.telefone;
		
	}
	
	/**
	 * Metodo que retorna uma reprensentacao textual sobre o contato 
	 * @return uma representacao textual contendo a posicao, nome e sobrenome do contato
	 */
	public String toString2() {
		
		return this.posicao + " - " + this.nome + " " + this.sobrenome;
		
	}
	
	/**
	 * Metodospara comparar dois objetos do tipo contatos iguais 
	 *  um contato é igual ao outro se o nome e sobrenome forem iguais 
	 *  @return true caso existir dois contatos iguais e false se nao existir dois contatos iguais  
	 * 
	 */
	public boolean equals(Object contato) {

	     if (this.nome.equals(((Contato) contato).getNome())
	          && this.sobrenome.equals (((Contato) contato).getSobrenome())){
	          return true;

	     } else {
	    	 return false;		 
	     }
	}

}
