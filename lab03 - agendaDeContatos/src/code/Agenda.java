package code;
/**
 * class Agenda que representa uma agenda  
 * responsavel por guardar e gerenciar e criar contatos
 * 
 * @author jaci
 *
 */
public class Agenda {
	
	/**
	 * array contatos do tipo contato para aguardar contatos de forma sequencial
	 * @param contatinho do tipo contato 
	 */
	private Contato[] contatos;
	private Contato contatinho;
	
	/**
	 * Construtor agenda, inicializacao da classe agenda
	 * um array contatos do tipo contato de tamanho 100
	 * @return void 
	 */
	public Agenda() {
		
		contatos = new Contato[100];
	
	}
	
	/**
	 * Metodo responsavel por validar a posicao recebida do main
	 * @param posicao
	 * @return um boolean (true para posicao valida entre 1 e 100 e false para invalida maior que 100
	 * e menor que 1)
	 */
	public boolean validaPosicao(int posicao) { 
	
		if (posicao > 0 && posicao <= 100){
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo responsavel pela criacao do objeto e guardar ele na posicao correta no array 
	 * @param nome do tipo string 
	 * @param sobrenome do tipo string 
	 * @param telefone do tipo string 
	 * @param posicao do tipo inteiro
	 * @return um boolean 
	 * true se o cadastro realizar com sucesso
	 * false se aparecer qualquer coisas que imposibilita o instaciamento do objeto
	 */
	public boolean cadastraContato(String nome, String sobrenome, String telefone, int posicao ) {
		
		if (validaPosicao(posicao)) {
			
			contatinho = new Contato(nome,sobrenome, telefone, posicao);
			
			contatos[posicao - 1] = contatinho;
			
			return true;
			
		} else {
			return false;
			
		}
	}
	
	/**
	 * Método que retorna a representação textual de um contato inentificado pela sua posicao. 
	 * @param posicao
	 * @return um string
	 * se for valida a posicao ira retornar uma string com informacoes sobre o contato 
	 * se nao for retornara a frase "posicao invalida"
	 */
	public String pesquisaContato(int posicao) {
		
		if(validaPosicao(posicao) && contatos[posicao - 1] != null) {
			
			return contatos[posicao  - 1].toString();
			
		} else {
			
			return "Posicao invalida";
		}
	}
	
	/**
	 * Metodo que retorna a representacao textual de todos os objetos guardados no array 
	 * 
	 * @return representacao textual de todos os contatos no array
	 */
	public String listaContatos() {
		
		String saida = "";
		
		for (Contato pessoinha : contatos ) {
			if (pessoinha != null) {
				saida += pessoinha.toString2() + "\n";
			}
		}
		return saida;
	}
	
	/**
	 * Metodo responsavel por verificar se duas agendas são iguais, atraves da suas listas 
	 * recebe uma agenda do tipo object e sendo convertida por o tipo mais espefico logo depois
	 * @return true se forem iguais 
	 * @return false se duas agendas nao for iguais 
	 */
	public boolean equals(Object agenda) {
		
		if (this.listaContatos().equals(((Agenda)agenda).listaContatos())){
			
			return true;
			
		} else {
			
			return false;
		}
	
	}

}
