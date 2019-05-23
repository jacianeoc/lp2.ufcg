package code;

import java.util.HashMap;
import java.util.Map;

public class Fornecedor implements Comparable<Fornecedor> {

	private String telefone;
	
	private String email;
	
	private String nome;
	
	private Map<IdProduto, Produto> produtos;

	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
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
	public void  cadastraProduto(double preco, String nome, String descricao) {
		
		IdProduto id = new IdProduto(nome, descricao);
		Produto produto = new Produto(preco, nome, descricao);
		
		if(produtos.containsKey(id)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		} else {
			produtos.put(id, produto);
		}
	}
	public String exibeProduto(String nome, String descricao) {
		return null;
	}

}
