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
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	@Override
	public int compareTo(Fornecedor f) {
		return this.nome.compareTo(f.getNome());
	}

	public void atulalizaAtributos(String atributo, String novoValor) {
		String atualizacao = atributo.toLowerCase().trim();
		
		switch (atualizacao) {
		
		case "email":
			setEmail(novoValor);
			break;
			
		case "telefone":
			setTelefone(novoValor);
			break;
			
		default :
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
		
	}

}
