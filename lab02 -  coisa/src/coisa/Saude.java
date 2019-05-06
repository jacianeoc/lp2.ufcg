package coisa;

public class Saude {
	/**
	 * @param saudeMental com o tipo String que representa a saude mental do aluno
	 * @param saudefisica com o tipo String que representa a saude fisica do aluno
	 */
	private String saudeMental;
	
	private String saudeFisica;
	
	/*
	 * construtor Saude que ira inicializar a classe , com os paramentros comecando com 
	 * o valor string "boa", sem a necessidade que ter argumentos para ser inicializada
	 */
	public Saude() {
		this.saudeFisica = "boa";
		this.saudeMental = "boa";
	}
	
	/*
	 * metodo que nao lanca nenhum retorno, mas define como estar a saude 
	 * mental do aluno
	 */
	public void defineSaudeMental(String valor) {
		saudeMental = valor.toLowerCase();
	}
	
	/*
	 * metodo que nao lancara nenhum retorno, mas define como estar a saude 
	 * fisica do aluno
	 */
	public void defineSaudeFisica(String valor) {
		saudeFisica = valor.toLowerCase();
	}
	/*
	 * metodo que retorna uma String mostrando a saude geral do aluno
	 * se for ambas boa o geralzao sera que o aluno estar bem 
	 * se ambas forem fracas , entende-se que o aluno esta derrotado
	 * se uma delas forem fracas so retornar que a string "ok"
	 */
	public String getStatusGeral() {
		if (saudeFisica.equals("boa") && saudeMental.equals("boa")) {
			return "boa"; 
		} else if (saudeFisica.equals("fraca") && saudeMental.equals("fraca")) {
			return "fraca";
		} else {
			return "ok";
		}
	}
	
}
