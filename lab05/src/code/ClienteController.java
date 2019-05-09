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
			throw new IllegalArgumentException("cliente ja cadastrado");
		}
		Cliente c = new Cliente(cpf, nome,email,local);
		clientes.put(cpf, c);
		return cpf;

	}
	
	// fazer uma classe de validacao para jogar todo mundo lá e facilitar a  minha vida nessa merda :)
	public String exibeCliente(String cpf) {
		
		if(clientes.containsKey(cpf)) {
			
			return clientes.get(cpf).toString();
		} else {
			
			return "cliente nao cadastrado";
		}

	}
	// o list é para facilitar a minha vida mesmo 
		 
	private List<Cliente> ordemClientes(){
		// isso tá um pouquinho errado, só acho 
		List<Cliente> listinhaOrdenada = new ArrayList<>(clientes.values());
		Collections.sort(listinhaOrdenada); // importando um colletion pela 3 vez, espero ser o certo agora
		return listinhaOrdenada;
	}
		 
	// i am felling in my bonesss, i dont know what i am listening now haha o my god man

	// ainda sem entender os numerozinhos do compateTo que coloquei mas fime e forte finguindo demencia 
	// hora da gamiarra e vou chorar muito ordemando essa coisinha aqui
	 public String listaClientes () {
		 String saida = ""; // tu vai esperar jaja te faco 
		 List<Cliente> lista = ordemClientes();
		 
		 for (Cliente cliente : lista) {
			 saida += cliente.toString() + " | ";
		 }
		 
		 if (saida != "".trim()) {
			 return saida.substring(0, saida.length() - 3);
		 }
		 return saida;
	 }
	 // i want a dick 
	 // day a dead <- this is some song , i dont remember now  
	 public void editaNome(String cpf, String novoNome) {
		 if(clientes.containsKey(cpf)) {
			 clientes.get(cpf).setNome(novoNome);
			 
		 } else {
			 throw new IllegalArgumentException("cliente nao exite, é uma alma penada");
		 }
	 }
	 
	 public void editaEmail(String cpf, String novoEmail) {
		 if(clientes.containsKey(cpf)) {
			 clientes.get(cpf).setEmail(novoEmail);
			 
		 } else {
			 throw new IllegalArgumentException("cliente nao exite, é uma alma penada");
		 }
	 }
	 
	 public void editaLocal(String cpf, String novoLocal) {
		 if(clientes.containsKey(cpf)) {
			 clientes.get(cpf).setLocal(novoLocal);
			 
		 } else {
			 throw new IllegalArgumentException("cliente nao exite, é uma alma penada");
		 }
		 
	 }
	 // tem a questão de validar as entradas
	 public void removeCliente(String cpf) {
		 if(clientes.containsKey(cpf)) {
			 clientes.remove(cpf);
			 
		 } else {
			 throw new IllegalArgumentException("cliente nao exite, é uma alma penada");
		 }
		 
	 }
	
}
