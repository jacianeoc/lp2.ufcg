package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Contato;
/**
 * Class contato que guardara informacoes de um contato 
 * @author jaci
 *
 */
class ContatoTest {
	/**
	 * @param contato1, contato2, contato3 do tipo contato 
	 */
	Contato contato1;
	Contato contato2;
	Contato contato3;
	/**
	 * Metodo responsavel por rodar todas as vezes que um test sera testado 
	 */
	@BeforeEach	
	public void seUp() {
		/**
		 * criacao de objetos do tipo contato 
		 */
		contato1 = new Contato("decio", "neto", "56554522", 1);
		contato2 = new Contato("sono", "infinito", "215435", 3);
		contato3 = new Contato("decio", "neto", "56554522", 1);
	}
	/**
	 * Metodo test que testar o contrutor de Contato 
	 * caso alguma entrada seja invalida, ira lancar uma excessao
	 * caso nao haja lancamento de excecao , sera crriado novos objetos
	 */
	@Test
	public void testContato() {
		assertThrows(IllegalArgumentException.class, () -> new Contato("  ", "mfkdjlmd", "ojkfdijnfijn", 12));
		assertThrows(IllegalArgumentException.class, () -> new Contato("", "mfkdjlmd", "ojkfdijnfijn",1));
		assertThrows(IllegalArgumentException.class, () -> new Contato("", "", "ojkfdijnfijn",13));
		assertThrows(IllegalArgumentException.class, () -> new Contato("", "   ", "ojkfdijnfijn",54));
		assertThrows(IllegalArgumentException.class, () -> new Contato("", "   ", "   ",65));
		assertThrows(IllegalArgumentException.class, () -> new Contato("", "", "",45));
		assertThrows(IllegalArgumentException.class, () -> new Contato("fesfsd", "   ", "ojkfdijnfijn",5));
		assertThrows(IllegalArgumentException.class, () -> new Contato("sdfsdf", "", "ojkfdijnfijn",2));
		assertThrows(IllegalArgumentException.class, () -> new Contato("sdfsf", "fsdfsdf", "  ",3));
		assertThrows(IllegalArgumentException.class, () -> new Contato("esfsfd", "fsdfsdf", "",87));
		assertThrows(IllegalArgumentException.class, () -> new Contato(null, "fsdfsdf", "",8));
		assertThrows(IllegalArgumentException.class, () -> new Contato("esfsfd", null, "",9));
		assertThrows(IllegalArgumentException.class, () -> new Contato("esfsfd", "fsdfsdf", null,7));
	}
	/**
	 * Metodo que testara o metodo toString da classe Contato 
	 * onde tera uma representacao testual com retorno 
	 */
	@Test 
	public void testToString() {
		
		String saida = "decio neto - 56554522";
		assertEquals(contato1.toString(), saida);
	}

	/**
	 * Metodo que testara o metodo toString2 da classe Contato 
	 * onde tera uma representacao testual com retorno 
	 */
	@Test
	public void testToString2() {
		
		String saideira = "3 - sono infinito";
		assertEquals(contato2.toString2(), saideira);
	}
	
	/**
	 * Metodo responsavel por comparar dois objetos de contato sao iguais
	 */
	@Test
	public void testEqualsVerdadeiro() {
		
		assertTrue(contato1.equals(contato3));
	}
	
	/**
	 * Metodo responsavel por comparar dois objetos de contato sao iguais
	 */
	@Test
	public void testEqualsFalso() {
		
		assertFalse(contato1.equals(contato2));
	}
	
}
