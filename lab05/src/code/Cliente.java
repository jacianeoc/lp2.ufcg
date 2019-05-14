package code;

public class Cliente implements Comparable<Cliente> {

	
	private String nome;
	private String email;
	private String local;

	public Cliente( String nome, String email, String local) {
		
		this.nome = nome;
		this.email = email;
		this.local = local;
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

	
	public void atulalizacaoAtributos(String atributo, String novoValor) {
		String atualizacao = atributo.toLowerCase().trim();
		
		switch (atualizacao) {
		
			case "nome":
				setNome(novoValor);
				
			case "email":
				setEmail(novoValor);
				
			case "localizacao":
				setLocal(novoValor);
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
