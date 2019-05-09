package code;

public class Cliente implements Comparable<Cliente> {

	private String cpf;
	private String nome;
	private String email;
	private String local;

	public Cliente(String cpf, String nome, String email, String local) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.local = local;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public void setEmail(String novoEmail) {
		this.email = novoEmail;
	}
	
	public void setLocal(String novoLocal) {
		this.local = novoLocal;
	}


	public String toString() {
		return nome + " - " + local + " - " + email;
	}
	//https://blog.alura.com.br/ordenando-uma-lista-de-objetos-em-java/
	
	@Override
	public int compareTo(Cliente o) {
		// ainda ver como isso vai fazer, stack overflow <3 linda jaja te olho
		return 0;
	}

}
