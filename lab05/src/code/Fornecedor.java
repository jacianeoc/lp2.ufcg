package code;

public class Fornecedor implements Comparable<Fornecedor> {

	private String telefone;
	
	private String email;
	
	private String nome;

	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	

	public String getNome() {
		return nome;
	}

	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	@Override
	public int compareTo(Fornecedor f) {
		return this.nome.compareTo(f.getNome());
	}

}
