package code;

import java.util.Scanner;

public class Main {
	static Controller c = new Controller();
	static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		
		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistrar Aluno que Respondeu");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!");

	}
	
	public static void cadastraAluno() {
		System.out.print("Matricula: ");
		String matricula = sc.nextLine() + "\n";
		System.out.print("Nome:");
		String nome = sc.nextLine() + "\n";
		System.out.print("Curso: ");
		String curso = sc.nextLine() + "\n";
		
		if (!c.validaMatricula(matricula)) {
			System.out.println("MATRÍCULA JÁ CADASTRADA!\n");
		} else {
			c.cadastraAluno(matricula, nome, curso);
			System.out.println("CADASTRO REALIZADO!\n");
			
		}
	}
	public static void consultaAluno() {
		System.out.print("Matricula: ");
		String matricula = sc.nextLine() + "\n";
		
		System.out.print(c.consultaAluno(matricula));
		
	}
	public static void cadastraGrupo() {
		System.out.print("Grupo: ");
		String grupo = sc.nextLine() + "\n";
		
		if(c.cadastraGrupo(grupo)) {
			c.cadastraGrupo(grupo);
			System.out.println("CADASTRO REALIZADO!\n");
		} else {
			System.out.println("GRUPO JÁ CADASTRADO!\n");
		}
	}
	public static void alocaoOuImpressao() {
		System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
		String escolha = sc.nextLine().toLowerCase();
		
		if("a".equals(escolha)) {
			System.out.print("Matricula: ");
			String matricula = sc.nextLine();
			System.out.print("Grupo: ");
			String grupo = sc.nextLine().toLowerCase();
			
			if(!c.validaMatricula(matricula)) {
				System.out.println("Aluno não cadastrado.");
				
			} else if(!c.validaGrupo(grupo)) {
				System.out.println("Grupo não cadastrado.");
			} else {
				System.out.println("ALUNO ALOCADO!");
			}
		} else if ("i".equals(escolha)) {
			System.out.print("Grupo: ");
			String grupo = sc.nextLine().toLowerCase();

			System.out.println(c.imprimeGrupo(grupo));
			
		}
	}
	public static void registaAlunosQueResponderam() {
		System.out.print("Matricula: ");
		String matricula = sc.nextLine();
		
		if(!c.responderamQuestao(matricula)) {
			System.out.println("Aluno não cadastrado.");
		} else {
			if(c.responderamQuestao(matricula)) {
				c.responderamQuestao(matricula);
				System.out.println("ALUNO REGISTRADO!\n");
			}
		}
	}
	public static void alunosQueResponderam() {
		System.out.println(c.imprimeAlunosQueResponderam());
	}
 
	public static void main(String[] args) {
	
		boolean condicao = true; 
		
		while (condicao) {
			menu();
			System.out.print("Opcao> ");
			String opcao = sc.nextLine().toLowerCase().trim();
			
			if(opcao.equals("c")) {
				cadastraAluno();
				
			} else if(opcao.equals("e")) {
				consultaAluno();
								
			} else if(opcao.equals("n")){
				cadastraGrupo();
			} else if(opcao.equals("a")){
				alocaoOuImpressao();
			} else if(opcao.equals("r")){
				registaAlunosQueResponderam();
			} else if(opcao.equals("i")){
				alunosQueResponderam();
			} else if(opcao.equals("o")){
				condicao = false;
			} else {
				throw new IllegalArgumentException("entrada invalida, nao deu :)");
			}	
		
		}
		
		sc.close();
	}


}