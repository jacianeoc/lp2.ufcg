package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteController {

	private Map<String, Cliente> clientes;
	private Validacao valida;
	
	
	public ClienteController() {
		this.clientes = new HashMap<>();
		valida = new Validacao();
	}
	
	public String cadastraCliente(String cpf, String nome, String email, String localizacao) {
		valida.validaCpf(cpf);
		valida.validaNome(nome);
		valida.validaEmail(email);
		valida.validaLocal(localizacao);
		
		if(clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
		Cliente c = new Cliente(nome,email,localizacao);
		clientes.put(cpf, c);
		return cpf;

	}
	
	public String exibeCliente(String cpf) {
		
		if (cpf == null || "".equals(cpf.trim())) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		}
		if(clientes.containsKey(cpf)) {
			
			return clientes.get(cpf).toString();
		} else {
			
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}

	}
	
		 
	private List<Cliente> ordemClientes(){

		List<Cliente> listinhaOrdenada = new ArrayList<>(clientes.values());
		Collections.sort(listinhaOrdenada); // importando um colletion pela 3 vez, espero ser o certo agora
		return listinhaOrdenada;
	}
		 
	 public String listaClientes () {
		 String saida = ""; 
		 List<Cliente> lista = ordemClientes();
		 
		 for (Cliente cliente : lista) {
			 saida += cliente.toString() + " | ";
		 }
		 
		 if (saida != "".trim()) {
			 return saida.substring(0, saida.length() - 3);
		 }
		 return saida;
	 }

	 
	 public void editaCliente (String cpf , String atributo, String novoValor) {
 
		 if (cpf == null || "".equals(cpf.trim())) {
				throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		}
		 if (atributo == null || "".equals(atributo.trim())) {
			 throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		 }
		 if (novoValor == null || "".equals(novoValor.trim())) {
			 throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		 }
		 if (cpf.equals(atributo.trim())) {
			 throw new IllegalArgumentException("Erro na edicao do fornecedor: cpf nao pode ser editado.");
		}
		 if (clientes.containsKey(cpf)) {
			 clientes.get(cpf).atulalizaAtributos(atributo, novoValor);
			 
		 } else {
			 throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		 }
		 
	 }
	 
	 public void removeCliente(String cpf) {
		
		 if (cpf == null || "".equals(cpf.trim())) {
				throw new IllegalArgumentException("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
			}
		 if(clientes.containsKey(cpf)) {
			 clientes.remove(cpf);
	
		 } else {
			 throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		 }
		 
	 }
}
