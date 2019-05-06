package coisa;


public class Disciplina {
	
	/**
	 * @param disciplina do tipo String, guardara o nome da disciplina
	 * @param horasDeEstudo do tipo inteiro , guardara a quantidade de horas que o aluno estar estudado 
	 * nessa determinada disciplina, que sera inicializada com valor zero
	 * @param notas sendo um array de doubles, onde guardara as notas
	 * @param media sera para a media das notas mesmo com o tipo double
	 */
	private String disciplina;
	
	private int horasDeEstudo;
	
	private double[] notas;
	
	private double media;
	
	/*
	 * construtor Disciplina: para inicializar a classe tendo como argumento o nome da disciplina 
	 * e a criacao do array  
	 */
	public Disciplina(String disciplina) {
		this.disciplina = disciplina;
		this.notas = new double[4];
		
	}
	
	/*
	 * metodo cadastraHoras com argumento horas ira contabilizar a quantidades de horas 
	 * estudadas nessa determinada disciplina
	 */
	public void cadastraHoras(int horas) {
		this.horasDeEstudo += horas;
	}
	/*
	 * metodo cadastraNota  com os argumentos nota e valornota, onde a nota faz referencia 
	 * ao qual nota é que estar pegando e volarNota é o valor que ela colocara na nota
	 */
	public void cadastraNota(int nota, double valorNota) {
		notas[nota- 1] = valorNota; 
	}
	
	/*
	 * metodo bloolean aprovado que retornara o boolean true caso o aluno tenha a media 
	 * maior ou igua a 7 
	 * e false se a media do aluno for menor que 7
	 */
	public boolean aprovado () {
		
		media = (notas[0] + notas[1] + notas[2] + notas[3])/ 4;
		
		 if (media >= 7.0) {
			 return true;
			 
		 }else {
			 return false; 
		 }
	}
	/*
	 * metodo String toString para fazer a representacao textual bonitinha da classe basicamente 
	 */
	public String toString () {
		return this.disciplina + " " + this.horasDeEstudo + " " + this.media + " [" +
				notas[0] + ", " + notas[1] + ", " + notas[2] + ", " + notas[3] + "]";
	}
	
}
