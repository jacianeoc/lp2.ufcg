package code;

public class Validacao {
	
//clientes 	
	public void validaNome(String nome) {
		if(nome == null || "".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
	}
	
	public void validaEmail(String email) {
		if(email == null || "".equals(email.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
	}


	public void validaLocal(String local) {
		if(local == null || "".equals(local.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
		
	}

	public void validaCpf(String cpf) {
		if(cpf == null || "".equals(cpf.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}
		
	}

// fornecedor
	public void validaNomeFornecedor(String nome) {
		if(nome == null || "".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
	}
	
	public void validaEmailFornecedor(String email) {
		if(email == null || "".equals(email.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
	}


	public void validaTelefone(String telefone) {
		if(telefone == null || "".equals(telefone.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: local nao pode ser vazio ou nulo.");
		}
		
	}
	

}
