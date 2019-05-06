package coisa;


public class ContaCantina {
	/**
	 * @param nomeDaCantina para o nome da cantina que sera cadastrado
	 * @param totalitens tendo o tipo inteiro, para guardar o total de itens que foi consumido
	 * @param gastoTotal tendo como tipo um inteiro para guarda o valor do 
	 * total que o estudante gastou em itens 
	 * @param devendo tando como tipo um inteiro, serve para indicar quanto o estudante ainda estar
	 * faltando pagar para se livrar da conta pendurada 
	 */

	private String NomeDaCantina;
	
	private int totalItens;
	
	private int gastoTotal; 
	
	private int devendo; 
	
	/*
	 * construtor ContaCantina para inicializar a classe  tendo como argumento o nome da cantina 
	 */
	public ContaCantina(String nome) {
		this.NomeDaCantina = nome; 
		
	}
	
	/*
	 * metodo cadastraLanche, ira ter como argumentos a quantidade de itens e o valor em centavos 
	 * tendo tres contadores na qual aumentara de acordo com os valores passados 
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		totalItens += qtdItens;
		devendo += valorCentavos;
		gastoTotal += valorCentavos;
	}
	
	/* 
	 * metodo pagaConta , tendo como argumento o valor centavos assim diminuindo o total que o estudante
	 * estar devendo na cantina 
	 * se o valor for maior que o valor devendo, ele ira lancar uma excessao
	 * se for menor ou igual ele ira descontar do paramentro devendo 
	 */
	public void pagaConta(int valorCentavos) {
		if (valorCentavos > devendo) {
			 throw new IllegalArgumentException("ta querendo pagar demais ¯|_(ツ)_|¯");
		}else {
			devendo -= valorCentavos;
		}
	}
	/*
	 * metodo getFaltaPagar ira retorna o valor do @param devendo 
	 * 
	 */
	public int getFaltaPagar() {
		return this.devendo;
	}
	
	/*
	 * metodo toString para retornar uma representacao em string 
	 */
	public String toString() {
		return this.NomeDaCantina + " " + this.totalItens + " " + this.gastoTotal; 
	}
}
