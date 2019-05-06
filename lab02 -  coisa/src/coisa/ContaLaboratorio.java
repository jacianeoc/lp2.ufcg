package coisa;


public class ContaLaboratorio {
	/**
	 * @param nome  para o nome da conta do laboratorio
	 * @paran cota com tipo intero 
	 * @param espacoUtilizado para servir como acumulador do espaco utilizado por 
	 * conta usuario
	 */
	private String nome;
	
	private int cota;
	
	private int espacoUtilizado;
	
	/*
	 *  construtor ContaLaboratorio utilizado para inicializar a classe 
	 */
	public ContaLaboratorio(String nome) {
		this.nome = nome;
		this.cota = 2000;
	}
	
	/*
	 * metodo para acumular o valor de megaBytes utilizado
	 * colocando no paramentro espacoUtilzado
	 */
	public void consomeEspaco (int mBytes) {
		this.espacoUtilizado += mBytes;  
	}
	
	/*
	 * metodo liberaEspaco para diminuir o valor de referencia
	 *  do paramentro de espacoUtilizado
	 */
	public void liberaEspaco(int mBytes) {
		this.espacoUtilizado -= mBytes;
	}
	
	/*
	 * metodo atingiuCota serve para lancar um valor booleano 
	 * caso a cota seja menor que o espaco utilizado ira lancar 
	 * o boolean true, representando que ele ja atinguiu a cota 
	 * caso a cota seja maior ira lancar o boolean false 
	 * indicando que o valor ainda e menor que a cota, com isso 
	 * ele ainda nao atinguiu e ainda tem espaco
	 */
	public boolean atingiuCota() {
		if (espacoUtilizado >= cota) {
			return true;
		} else {
			return false;
		}
	}
	/*
	 * metodo toString serve para retornar uma representacao 
	 * bonitinha da classe,caso outra classe perca
	 */
	public String toString() {
		return this.nome + " " + this.espacoUtilizado + "/" + this.cota;
	}
}
