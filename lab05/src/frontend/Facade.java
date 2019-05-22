package frontend;

import code.ClienteController;
import code.FornecedorController;
import easyaccept.EasyAccept;

public class Facade {
	private ClienteController cc;
	private FornecedorController fc;
	
	public Facade () {
		cc = new ClienteController();
		fc = new FornecedorController();
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
	
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return fc.adicionaFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return fc.exibeFornecedor(nome);
	}
	
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		fc.editaFornecedor(nome, atributo, novoValor);
	}
	
	public void removeFornecedor(String nome) {
		fc.removeFornecedor(nome);
	}
	
	public static void main(String[] args) {
		args = new String[] {"frontend.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt"};
		EasyAccept.main(args);
	}
}
