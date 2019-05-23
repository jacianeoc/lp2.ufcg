package code;

public class Produto {
	
	private String nome;
	private double preco;
	private String descricao;
	
	public Produto(double preco, String nome, String descricao) {
		this.preco = preco;
		this.nome = nome;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return  this.nome + " - " + this.descricao + " - " + this.preco;
	}
	
	

}
