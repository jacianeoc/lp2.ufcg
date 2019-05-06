package code;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * classe controller é a classe controlladora de todo o sistema de controle de alunos 
 * ele também é responvel por criar  alunos e grupos assim como o que irá ser feito 
 * em cada caso
 * @author jaciane Cruz
 *
 */
public class Controller {
	/**
	 * @param interface map  que tem como generics umas string como chave e o objeto aluno como valor
	 */
	private Map<String, Aluno> alunos;
	/**
	 * @param  grupors que é uma interface map que tem como generics uma string como chave e o objeto grupo como valor 
	 */
	private Map <String, Grupo> grupos;
	/**
	 * @param responsavel por guardar uma lista de alunos que respoderam questoes 
	 */
	private List<Aluno> responderamPerguntas;
	
	/**
	 * construtor responsavel por inicializar a classe
	 */
	public Controller() {
		
		alunos = new HashMap<>();
		grupos = new HashMap<>();
		responderamPerguntas = new ArrayList<>();
	}
	/**
	 * metodo responsavel por validar a matricula de aluno 
	 * @param matricula
	 * @return false caso a matricula já exista no sistema e true caso se ela ainda nao for cadastrada
	 */
	public boolean validaMatricula(String matricula) {
		
		if (matricula == null){
            throw new NullPointerException("matricula nao pode ser nula");
        }
        if ("".equals(matricula.trim())){
            throw new IllegalArgumentException("matricula nao pode ser vazia");
        }
		if (alunos.containsKey(matricula)) {
			 return false;
			 
		 } else {
			 return true;
		 }
		
	}
	/**
	 * metodo responsavel por validar se o nome do grupo já existe no sistema 
	 * @param nomeGrupo
	 * @return false caso o grupo já exista no sistema e true caso ainda nao tenha cadastro no sistema
	 */
	public boolean validaGrupo(String nomeGrupo) {
			
		if (nomeGrupo == null){
			throw new NullPointerException("nome do grupo nao pode ser nula");
		}
		if ("".equals(nomeGrupo.trim())){
			throw new IllegalArgumentException("nome do grupo nao pode ser vazia");
		}
		if (grupos.containsKey(nomeGrupo)) {
			return false;
				 
		} else {
			
			return true;
		}
			
	}
	/**
	 * metodo responsavel por criar e guardar um aluno no sistema 
	 * @param matricula
	 * @param nome
	 * @param curso
	 * @return true se a operação for feita com sucesso e false caso algo dê errado
	 */
	 public boolean cadastraAluno(String matricula, String nome, String curso) {
		 
		 Aluno aluno = new Aluno(matricula, nome, curso);
		 
		 if (validaMatricula(matricula)) {
			 
			 alunos.put(matricula, aluno);
			 return true;
			 
		 } else {
			 return false;
		 }
	 }
	 /**
	  *metodo que consulta determinado aluno atravez de sua matricula  
	  * 
	  * @param matricula
	  * @return uma representação textual do aluno pedido , caso não exista retornara falando que nao tem aluno cadastrado
	  */
	 public String consultaAluno(String matricula) {

		 if (validaMatricula(matricula)) {
			 return "\nAluno não cadastrado.\n";
				
		 } else {
			return "\nAluno: " + alunos.get(matricula).toString() + "\n";
				
		 }
	 }
	 /**
	  * metodo responsavel por criar e guardar um grupo
	  * @param nomeGrupo
	  * @return true caso seja cadastrado um grupo com sucesso e false caso aconteca allgo que impossibilite essa operacao
	  */
	 public boolean cadastraGrupo(String nomeGrupo) {
		 // acho que isso da erro quando a entrada for null 
		 nomeGrupo.toLowerCase().trim();
		 
		 Grupo g = new Grupo(nomeGrupo);
		 
		 if(validaGrupo(nomeGrupo)) {
			 grupos.put(nomeGrupo,g);
			 return true;
			 
		 } else {
		 return false;
		 }
	 }
	 /**
	  * metodo que adicional um aluno ao grupo que será passado 
	  * @param nomeGrupo
	  * @param matriculaAluno
	  * @return true caso seja adicionado com sucesso e alguma excessao caso nao seja possivel cadastrar
	  */
	public boolean alocaAluno(String nomeGrupo, String matriculaAluno) {
		
		if(validaMatricula(matriculaAluno)) {
			return false;
		}
		if(validaGrupo(nomeGrupo)) {
			return false;
		}
		Grupo grupo = grupos.get(nomeGrupo);
		Aluno aluno = alunos.get(matriculaAluno);
		
		return grupo.addAluno(aluno);
	}
	 /**
	  * metodo que terá uma reperesentacao string de todos os alunos que fazem parte do grupo passado 
	  * @param nomeGrupo
	  * @return uma string com todos os alunos acossidados a esse grupo, caso nao exista o grupo será informado que não tem 
	  * nenhum grupo cadastrado com aquele nome
	  */
	public String imprimeGrupo(String  nomeGrupo) {
		nomeGrupo.toLowerCase().trim();
		
		if ("".equals(nomeGrupo.trim())) {
			throw new IllegalArgumentException();
		}
		String saida = "";
		
		if(grupos.containsKey(nomeGrupo)) {
			Grupo grupinho = grupos.get(nomeGrupo);
			saida += grupinho.listaAlunos() ;
			
		} else {
			return "Grupo não cadastrado.";
		}
		return "Alunos do grupo Listas: \n" + saida.substring(0 , saida.length() - 1);
	}
	/**
	 * metodo que guardar todos os alunos que responderam perguntas, podendo haver repeticoes de alunos 
	 * @param matricula
	 * @return  true caso o aluno seja adicionado com sucesso e false caso haja alguma complicacao no meio do caminho
	 */
	public boolean responderamQuestao(String matricula) {
		if(validaMatricula(matricula)) {
			return false;
		} else {
			responderamPerguntas.add(alunos.get(matricula));
			return true;
		}
	}
	/**
	 * metodo que imprime todos os alunos que respoderam alguma ppergunta 
	 * @return uma string contendo todos os alunos adicionados na lista que quem respodeu alguma pergunta
	 */
	
	public String imprimeAlunosQueResponderam() {
		String lista = "";
		int num = 1;
		for (Aluno aluno : responderamPerguntas) {
			
			lista += num+ ". " + aluno.toString() + "\n";
			num ++;
		}
		return lista.substring(0, lista.length() - 1);
		
	}
}
