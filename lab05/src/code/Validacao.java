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
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
	}
	public void validaEditaCliente(String cpf, String atributo, String novoValor) {
		 if (cpf == null || "".equals(cpf.trim())) {
				throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		}
		 if (atributo == null || "".equals(atributo.trim())) {
			 throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		 }
		 if (novoValor == null || "".equals(novoValor.trim())) {
			 throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		 }
		 if ("cpf".equals(atributo.trim())) {
			 throw new IllegalArgumentException("Erro na edicao do fornecedor: cpf nao pode ser editado.");
		}
	}

// fornecedor
	public void validaNomeFornecedor(String nome) {
		if(nome == null || "".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser "
					+ "vazio ou nulo.");
		}
	}
	
	public void validaEmailFornecedor(String email) {
		if(email == null || "".equals(email.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
	}


	public void validaTelefone(String telefone) {
		if(telefone == null || "".equals(telefone.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
		
	}

	public void validaEditaFornecedor(String nome, String atributo, String novoValor) {
		if (nome == null || "".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if (atributo == null || "".equals(atributo.trim())) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}
		if (novoValor == null || "".equals(novoValor.trim())) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}
		if ("nome".equals(atributo.trim())) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}

		
	}
	

}
