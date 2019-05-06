package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Agenda;
/**
 * Class teste da classe agenda :)
 * @author jaci
 *
 */
class AgendaTest {
	/**
	 * @param agenda1, agenda2, agenda3 do tipo agenda 
	 */
	Agenda agenda1;
	Agenda agenda2;
	Agenda agenda3;
	/**
	 * criacao do metodo que sera todas as vezes que um metodo test for rodado
	 */
	@BeforeEach
	public void setUp() {
		/**
		 * criacao de ojetos do tipo agenda
		 */
		agenda1 = new Agenda();
		agenda2 = new Agenda();
		agenda3 = new Agenda();
		
		/*
		 * cadastramento de varios objetos do tipo contato
		 */
		agenda1.cadastraContato("castor", "falantes", "666-616", 1);
		agenda1.cadastraContato("poneis", "malditos", "4236-5684", 10);
		agenda1.cadastraContato("mc", "latino", "365-56", 100);
		
		agenda2.cadastraContato("castor", "falantes", "666-616", 1);
		agenda2.cadastraContato("poneis", "malditos", "4236-5684", 10);
		agenda2.cadastraContato("mc", "latino", "365-56", 100);
		
		agenda3.cadastraContato("decio", "neto", "8922", 20);
		agenda3.cadastraContato("angemon", "melhor", "458-965", 78);
		agenda3.cadastraContato("agumon", "barfo de pimenta", "784", 65);
	}
	/**
	 * Metodo test que testara a validade da posicao validas 
	 * (verdadeiras)
	 */
	@Test 
	public void testValidaPosicaoVerdadeiras() {
		
		assertEquals(agenda1.validaPosicao(69), true);
		assertEquals(agenda1.validaPosicao(1), true);
		assertEquals(agenda1.validaPosicao(100), true);	

	}
	/**
	 * Metodo test que testara a validade das posicoes nao validas 
	 * (falsas)
	 */
	@Test 
	public void testValidaPosicaofalsas() {
		
		assertEquals(agenda1.validaPosicao(-5), false);
		assertEquals(agenda1.validaPosicao(0), false);
		assertEquals(agenda1.validaPosicao(101), false);
	}
	/**
	 * Metodo que testa o cadastramento validos para a agenda
	 */
	@Test
	public void testCadastraContatosVerdadeiros() {
		
		assertEquals(agenda1.cadastraContato("jurema", "carvalho", "123-456", 1), true);
		assertEquals(agenda1.cadastraContato("valeria", "centaro", "654-654", 100), true);
		assertEquals(agenda1.cadastraContato("gloria","groove" , "456-887", 37), true);
	}
	/**
	 * Metodo que testa o cadastramento invalidos
	 * mas ja que a posicao e invalida, por questao de construção isso nunca podera ser 
	 * possivell , mas isso e seguranca 
	 */
	@Test 
	public void testCadastraCantatosFalsos() {
		
		assertEquals(agenda2.cadastraContato("mc", "kevinho", "7854-658", -55), false);
		assertEquals(agenda2.cadastraContato("luisa", "winderson", "120-0023", 101),false);
		assertEquals(agenda2.cadastraContato("test", "quero passar", "000-000", 0), false);
	}
	/**
	 * Metodo que testa o metodo que pesquisa um contato apartir da posicao de um contato ja existente
	 * 
	 */
	@Test
	public void testPesquisaContato() {
		
		agenda1.cadastraContato("homer", "simpson", "4002-8922", 56);
		String comparacao = "homer" + " " + "simpson" + " - "+ "4002-8922";
		
		assertEquals(agenda1.pesquisaContato(56),comparacao);
	}
	/**
	 * Metodo que testa o metodo de pesquisa contato que recebe uma posicao 
	 * que não foi cadastrado
	 */
	@Test
	public void testPesquisaContatoInvalido() {
		
		agenda1.cadastraContato("homer", "simpson", "4002-8922", 56);
		String comparacao = "Posicao invalida";
		
		assertEquals(agenda1.pesquisaContato(7),comparacao);
	}
	/**
	 * Metodo responsavel por testar se a respresentacao textual do metodo listaContato estar 
	 * representado corretamente 
	 */
	@Test
	public void testListaContato() {

		String comparacao =  "1" + " - " + "castor" + " " + "falantes" + "\n" 
						+ "10" + " - " + "poneis"+ " " + "malditos" + "\n"
						+ "100"+" - " + "mc" + " " + "latino" + "\n";
		assertEquals(agenda1.listaContatos(),comparacao);
		
	}
	/**
	 * Metodo que testa o metodo equals verdadeiro
	 * ou seja, duas agendas iguais 
	 */
	@Test
	public void testEqualsVerdadeiro() {
		assertTrue(agenda1.equals(agenda2));
	}
	/**
	 * Metodo que testa o metodo equals falso
	 * ou seja, duas agendas diferentes 
	 */
	@Test
	public void testEqualsFalso() {
		assertFalse(agenda1.equals(agenda3));
	}
	 // the end :)
}
