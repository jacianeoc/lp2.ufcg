package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Aluno;
import code.Grupo;

class AlunoTest {
	Aluno aluno1;
	Aluno aluno2;
	Aluno aluno3;
	
	@BeforeEach
	void setUp() throws Exception {
		aluno1 = new Aluno("1", "john", "fisio");
		aluno2 = new Aluno("2", "mario", "gamer");
		aluno3 = new Aluno("1", "john", "fisio");
	}
	/**
	 * testando o construtor 
	 * 
	 */
	@Test
	void testAluno() {
		// resumao mesmo porque falta coragem de fazer 
		assertThrows(IllegalArgumentException.class, () -> new Aluno("", "johny", ""));
		assertThrows(IllegalArgumentException.class, () -> new Aluno(" ","   ", "engenharia" ));
		assertThrows(NullPointerException.class, () -> new Aluno(null, null, null));
	}
	/**
	 * testa a respresentacao textual do Aluno
	 */
	@Test 
	void testToString () {
		String msg = "1 - john - fisio";
		assertEquals(aluno1.toString(), msg);
	}
	/**
	 * testa se dois objetos alunos sao iguais
	 */
	@Test 
	void testEquals() {
		assertFalse(aluno1.equals(aluno2));
		assertTrue(aluno1.equals(aluno3));
	}

	

}
