package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteController {

	private Map<String, Cliente> clientes;
	
	
	public ClienteController() {
		this.clientes = new HashMap<>();
	}
	
	public String cadastraCliente(String cpf, String nome, String email, String local) {
		
		if(clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
		Cliente c = new Cliente(nome,email,local);
		clientes.put(cpf, c);
		return cpf;

	}
	
	public String exibeCliente(String cpf) {
		
		if(clientes.containsKey(cpf)) {
			
			return clientes.get(cpf).toString();
		} else {
			
			return "cliente nao cadastrado";
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
		 
		 if (clientes.containsKey(cpf)) {
			 clientes.get(cpf).atulalizacaoAtributos(atributo, novoValor);
			 
		 } else {
			 throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		 }
		 
	 }
	 // tem a questão de validar as entradas
	 public void removeCliente(String cpf) {
		 
		 if(clientes.containsKey(cpf)) {
			 clientes.remove(cpf);
	
		 } else {
			 throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		 }
		 
	 }
	
}
