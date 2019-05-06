package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import code.Controller;


class ControllerTest {
	/**
	 * apenas para ser utilizado no test 
	 */
	Controller controller;
	
	@BeforeEach
	void setUp() throws Exception {
		
		controller = new Controller();
			
		controller.cadastraAluno("5", "thanos", "cc");
		controller.cadastraAluno("45", "homem formiga", "engenharia");
		controller.cadastraAluno("6", "hulk", "biologia");
		
		controller.cadastraGrupo("fadas");
			
	}
	
	/**
	 * metodo testCadastraAluno serve para testar o cadastramento de alunos
	 * true e realizar a cadastro com sucesso
	 * false se já existir aluno 
	 * lanca excessao se tiver valores null ou vazios
	 */
	@Test
	void testCadastraAluno() {
		
		assertTrue(controller.cadastraAluno("1", "thor", "cc"));
		assertFalse(controller.cadastraAluno("1", "loki", "historia"));
		
		assertThrows(NullPointerException.class,() -> {controller.cadastraAluno(null,"peter", "ee");});
		assertThrows(NullPointerException.class,() -> {controller.cadastraAluno("2", null, "ee");});
		assertThrows(NullPointerException.class,() -> {controller.cadastraAluno("2","peter", null);});
		
		assertThrows(NullPointerException.class,() -> {controller.cadastraAluno(null,null, "ee");});
		assertThrows(NullPointerException.class,() -> {controller.cadastraAluno("2",null, null);});
		assertThrows(NullPointerException.class,() -> {controller.cadastraAluno(null,null, null);});
		
		assertThrows(IllegalArgumentException.class,() -> {controller.cadastraAluno("","peter", "ee");});
		assertThrows(IllegalArgumentException.class,() -> {controller.cadastraAluno("2","", "ee");});
		assertThrows(IllegalArgumentException.class,() -> {controller.cadastraAluno("2","peter", "");});
		
		assertThrows(IllegalArgumentException.class,() -> {controller.cadastraAluno("  ","peter", "ee");});
		assertThrows(IllegalArgumentException.class,() -> {controller.cadastraAluno("  ","", "ee");});
		assertThrows(IllegalArgumentException.class,() -> {controller.cadastraAluno("","", "  ");});
	}
	
	/**
	 * test para consulta de alunos que tera uma representacao string 
	 * test se  lanca excecao se a matricula for invalida 
	 * 
	 */
	@Test 
	void testConsultaAluno() {
		
		String msg = "\nAluno não cadastrado.\n";
		String msg2 = "\nAluno: 2 - viuva negra - cc\n";
		controller.cadastraAluno("2", "viuva negra", "cc");
		
		assertEquals(controller.consultaAluno("2"), msg2);
		assertEquals(controller.consultaAluno("666"),msg);
		
		assertThrows(IllegalArgumentException.class,() -> {controller.consultaAluno("");});
		assertThrows(NullPointerException.class,() -> {controller.consultaAluno(null);});
		
	}
	/**
	 * test para cadastrar grupos com nomes validos ou nao
	 * 
	 */
	@Test 
	void testCadastraGrupo() {
		assertTrue(controller.cadastraGrupo("leitura"));
		assertFalse(controller.cadastraGrupo("fadas"));
		
		assertThrows(IllegalArgumentException.class, () -> {controller.cadastraGrupo("");});
		assertThrows(IllegalArgumentException.class, () -> {controller.cadastraGrupo("   ");});
		
		assertThrows(NullPointerException.class, () -> {controller.cadastraGrupo(null);});
	}
	/**
	 * test a alocacao de alunos para o determinado grupo
	 */
	@Test 
	void testAlocaAluno() {
		controller.cadastraAluno("12", "nebulosa", "cc");
		controller.cadastraGrupo("rpg");
		
		assertEquals(controller.alocaAluno("rpg", "12"), true);
		assertFalse(controller.alocaAluno("folks", "12"));
		assertFalse(controller.alocaAluno("rpg", "69"));
		
		assertThrows(IllegalArgumentException.class, () -> {controller.alocaAluno("", "  ");});
		assertThrows(IllegalArgumentException.class, () -> {controller.alocaAluno("", "12");});
		assertThrows(IllegalArgumentException.class, () -> {controller.alocaAluno("rpg", "");});
		
		assertThrows(NullPointerException.class, () -> {controller.alocaAluno(null, "12");});
		assertThrows(NullPointerException.class, () -> {controller.alocaAluno("rpg", null);});
		assertThrows(NullPointerException.class, () -> {controller.alocaAluno(null, null);});
	}
	/**
	 * testa o metodo imprimeGrupo
	 */
	@Test
	void testImprimeGrupo() {
		controller.cadastraGrupo("avengers");
		controller.alocaAluno("avengers", "45");
		controller.alocaAluno("avengers", "5");
		controller.alocaAluno("avengers", "6");
		String lista ="Alunos do grupo Listas: \n6 - hulk - biologia\n45 - homem formiga - engenharia\n5 - thanos - cc";
		
		assertEquals(controller.imprimeGrupo("avengers"), lista);
		assertEquals(controller.imprimeGrupo("penauts"), "Grupo não cadastrado.");
		
		assertThrows(NullPointerException.class, () -> {controller.imprimeGrupo(null);});
		assertThrows(IllegalArgumentException.class, () -> {controller.imprimeGrupo("");});
	}
	/**
	 * testa o metodo que add os alunos que respondem questoes e suas  provaveis excecoes
	 */
	 @Test 
	 void testResponderamQuestao() {
		assertTrue(controller.responderamQuestao("45"));
		assertFalse(controller.responderamQuestao("56"));
		assertTrue(controller.responderamQuestao("45"));
		 
		assertThrows(NullPointerException.class, () -> {controller.responderamQuestao(null);});
		assertThrows(IllegalArgumentException.class, () -> {controller.responderamQuestao("");});
	 }
	 /**
	  * testa o metodo de imprimir a lista de alunos que respoderam questoes, onde pode-se um aluno responder
	  * mais de uma questao que será impresso o seu nome
	  */
	@Test
	void testImprimeAlunosQueResponderam() {

		controller.responderamQuestao("5");
		controller.responderamQuestao("6");
		controller.responderamQuestao("5");
		controller.responderamQuestao("45");

		String lista = "1. 5 - thanos - cc\n" +"2. 6 - hulk - biologia\n" +
						"3. 5 - thanos - cc\n" + "4. 45 - homem formiga - engenharia";
		assertEquals(controller.imprimeAlunosQueResponderam(), lista);
	}
}
