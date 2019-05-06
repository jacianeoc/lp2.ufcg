package code;

import java.util.Scanner;

public class Main {
	
	public static void menu() {
		
		System.out.println("(C)adastrar Contato");
		System.out.println("(L)istar Contatos");
		System.out.println("(E)xibir Contato");
		System.out.println("(S)air");
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean condicao = true;
		Agenda agenda = new Agenda();
		String opcao = "";
		
		while(condicao){
			
			menu();
			System.out.print("Opcao> ");
			opcao = sc.nextLine().toLowerCase().trim();
			
			if(opcao.equals("c")) {

				System.out.println("Posição: ");
				int posicao = sc.nextInt();
				sc.nextLine();
				
				if (!agenda.validaPosicao(posicao)) {
					
					System.out.println("\nPOSICAO INVALIDA!\n");
					
				}else {
					
					System.out.println("Nome: ");
					String nome = sc.nextLine();
					System.out.println("Sobrenome: ");
					String sobrenome = sc.nextLine();
					System.out.println("Telefone: ");
					String telefone = sc.nextLine();
					
					agenda.cadastraContato(nome, sobrenome, telefone, posicao);
					System.out.println("CADASTRO REALIZADO!\n");
				}
				
			} else if(opcao.equals("l")) {
				
				System.out.println("\n" + agenda.listaContatos() + "\n");
				
			} else if(opcao.equals("e")) {
				
				System.out.print("Contato> ");
				int posicao = Integer.parseInt(sc.nextLine());
				
				if (!(agenda.validaPosicao(posicao)) || agenda.pesquisaContato(posicao) == null) {
					System.out.println("\nPOSICAO INVALIDA!\n");
					
				} else {
				System.out.println("\n" + agenda.pesquisaContato(posicao) + "\n");
				}
				
			}else if (opcao.equals("s")){
				condicao = false;
			} else {
				System.out.println("POSICAO INVALIDA!\n");
			}
		
		}
		
		sc.close();
	}


}


