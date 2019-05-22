package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FornecedorController {
	
	private Map<String, Fornecedor> fornecedores;
	private Validacao valida;
	public FornecedorController() {
		fornecedores = new HashMap<>();
		valida = new Validacao();
	}
	
	
	public String  adicionaFornecedor(String nome, String email, String telefone) {
		
		valida.validaNomeFornecedor(nome);
		valida.validaEmailFornecedor(email);
		valida.validaTelefone(telefone);
		
		if(fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
		Fornecedor f = new Fornecedor(nome, email, telefone);
		fornecedores.put(nome, f);
		return nome;
	}
	
	public String exibeFornecedor (String nome) {
		valida.validaNomeFornecedor(nome);
		
		if(fornecedores.containsKey(nome)) {
			return fornecedores.get(nome).toString();
			
		} else {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
	}
	private List<Fornecedor> ordenaFornecedores(){
		List<Fornecedor> listinhaFornecedores = new ArrayList<>(fornecedores.values());
		Collections.sort(listinhaFornecedores);
		return listinhaFornecedores;
	}
	
	public String exibeFornecedores() {
		String resultado = "";
		
		List<Fornecedor> list = ordenaFornecedores();
		for (Fornecedor f : list) {
			resultado += f.toString() + " | ";
		}
		if("".equals(resultado)) {
			return resultado;
			
		} else {
			return resultado.substring(0, resultado.length() -3);
		}
	}
	
	public void editaFornecedor (String nome , String atributo, String novoValor) {
		 
		valida.validaEditaFornecedor(nome, atributo, novoValor);
		
		if (fornecedores.containsKey(nome)) {
			 fornecedores.get(nome).atulalizaAtributos(atributo, novoValor);
			 
		} else {
			 throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
		 
	 }
	
	public void removeFornecedor(String nome) {
		if(nome == null || "".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		}
		if (fornecedores.containsKey(nome)) {
			fornecedores.remove(nome);
		} else {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
		
	}

}
