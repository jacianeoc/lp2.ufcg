package code;

import java.util.HashMap;
import java.util.Map;

public class FornecedorController {
	
	private Map<String, Fornecedor> fornecedores;
	
	public FornecedorController() {
		fornecedores = new HashMap<>();
	}
	// TODO classe de validacao para fornecedores que é mais facil do que ficar repetindo coisas
	public void adicionaFornecedor(String nome, String email, String teleforne) {
		if(fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
	}

}
