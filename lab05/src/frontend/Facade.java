package frontend;

import code.ClienteController;
import easyaccept.EasyAccept;

public class Facade {
	private ClienteController cc;
	
	
	public Facade () {
		cc = new ClienteController();
	}
	
	
	public String adicionaCliente(String cpf, String nome, String email,String local ) {
		return cc.cadastraCliente(cpf, nome, email, local);
	}
	
	public String exibeCliente(String cpf) {
		return cc.exibeCliente(cpf);
	}
	
	public void editaCliente(String cpf, String atributo, String novoValor) {
		cc.editaCliente(cpf, atributo, novoValor);
	}
	
	public void removeCliente(String cpf) {
		cc.removeCliente(cpf);
	}
	
	public static void main(String[] args) {
		args = new String[] {"frontend.Facade", "acceptance_test/use_case_1.txt"};
		EasyAccept.main(args);
	}
}
