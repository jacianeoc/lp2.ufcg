package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Aluno;
import code.Grupo;

class GrupoTest {

	Grupo grupo1;
	
	Aluno aluno1;
	
	Aluno aluno2;
	
	Aluno aluno3;

	@BeforeEach
	void setUp()  {
		grupo1 = new Grupo("artes");
		aluno1 = new Aluno("2", "joao", "design");
		aluno2 = new Aluno("3", "rock", "cc");
		aluno3 = new Aluno("4", "colecionador", "letras");
		
		grupo1.addAluno(aluno1);
		grupo1.addAluno(aluno2);
	}
	
	/**
	 * Teste do contrutor de Grupo.
	 */
	@Test
	void testGrupo() {
		assertThrows(IllegalArgumentException.class, () -> new Grupo(""));
		assertThrows(IllegalArgumentException.class, () -> new Grupo("   "));
		assertThrows(NullPointerException.class, () -> new Grupo(null));
	}
	
	/**
	 * teste do addAluno de grupo. responsavel por adicionar os alunos a colecao presente em grupo
	 */
	@Test 
	void testAddAluno() {
		assertTrue(grupo1.addAluno(aluno1));
		assertTrue(grupo1.addAluno(aluno1));
	}
	/**
	 * Teste do listaAlunos de Grupo. Imprimi todos os alunos cadastrados no grupo.
	 */
	 @Test 
	 void testListaAlunos() {
		 String lista = "3 - rock - cc\n2 - joao - design\n";
		 assertEquals(grupo1.listaAlunos(), lista);
	 }

	 /**
	  * Teste do equals de grupo Compara por nome, e não importa se é maior ou
	  * minusculo.
	  */
	 @Test
	 void testEqualsObject() {

		 Grupo g1 = new Grupo("CC");
		 Grupo g2 = new Grupo("cc");
		 Grupo g3 = new Grupo("AA");
		 Grupo g4 = new Grupo("CC");

		 assertFalse(g1.equals(g2));
		 assertFalse(g1.equals(g3));
		 assertTrue(g1.equals(g4));

		}
}
