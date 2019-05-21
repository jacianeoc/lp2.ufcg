package code;

public class Cliente implements Comparable<Cliente> {

	private Validacao valida;
	private String nome;
	private String email;
	private String local;

	public Cliente( String nome, String email, String localizacao) {
		valida = new Validacao();
		valida.validaNome(nome);
		valida.validaEmail(email);
		valida.validaLocal(localizacao);
		
		this.nome = nome;
		this.email = email;
		this.local = localizacao;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setEmail(String novoEmail) {
		this.email = novoEmail;
	}
	
	public void setLocal(String novoLocal) {
		this.local = novoLocal;
	}

	
	public void atulalizaAtributos(String atributo, String novoValor) {
		String atualizacao = atributo.toLowerCase().trim();
		
		switch (atualizacao) {
		
			case "nome":
				setNome(novoValor);
				
			case "email":
				setEmail(novoValor);
				
			case "localizacao":
				setLocal(novoValor);
			default :
				throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
	}

	public String toString() {
		return nome + " - " + local + " - " + email;
	}
	//https://blog.alura.com.br/ordenando-uma-lista-de-objetos-em-java/
	
	public int compareTo(Cliente c) {
		return this.nome.compareTo(c.getNome());
	}

	
}
