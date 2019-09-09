package simuladoProva01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProgRunnersTest {

	ProgRunners p;
	
	@BeforeEach
	void setUp() throws Exception {
		p = new ProgRunners();
		
		p.cadastrarProgramador("Mark Zuckerberg", "123456789-98", 1984);
		p.cadastrarProgramador("Bill gates", "987654321-23", 1955);
		p.cadastrarProgramador("Ada Lovelace", "987456321-65", 1954);
		p.cadastrarProgramador("Livia M", "987456321-78", 1995);
		 
		
	}

	//exibirCategoriaCorredor, resistenciaCorredor e contarTreinosFinalizadosCorredor
	@Test
	void testExibirCategoriaCorredor() {
		//testando os extremos de cada categoria que faltaram 
		//menor que 15 anos
		p.cadastrarProgramador("vacuo", "456987123- 56", 2015);
		//15 anos
		p.cadastrarProgramador("htgf", "456987123- 12", 2004);
		//41 anos 
		p.cadastrarProgramador("gdfg", "456987123- 13", 1978);
		//40 anos 
		p.cadastrarProgramador("gdgt", "456987123- 14", 1979);
		
		assertEquals(p.exibirCategoriaCorredor("123456789-98"), "ADULTO");
		assertEquals(p.exibirCategoriaCorredor("987654321-23"), "SUPER_ADULTO");
		assertEquals(p.exibirCategoriaCorredor("987456321-65"), "MELHOR_IDADE");
		assertEquals(p.exibirCategoriaCorredor("987456321-78"), "JOVEM");
		
		assertEquals(p.exibirCategoriaCorredor("456987123- 12"), "JOVEM");
		assertEquals(p.exibirCategoriaCorredor("456987123- 13"), "SUPER_ADULTO");
		assertEquals(p.exibirCategoriaCorredor("456987123- 14"), "ADULTO");
		assertThrows(IllegalArgumentException.class, () -> p.exibirCategoriaCorredor("456987123- 56"));
		assertThrows(IllegalArgumentException.class, () -> p.exibirCategoriaCorredor("1254697632-26"));
	}
	@Test 
	void testLista() {
		String msg = "Mark Zuckerberg - 123456789-98 - ADULTO\n"
				+ "Bill gates - 987654321-23 - SUPER_ADULTO\n"
				+ "Ada Lovelace - 987456321-65 - MELHOR_IDADE\n"
				+ "Livia M - 987456321-78 - JOVEM\n"; 
		assertEquals(p.listarCorredores(), msg);
	}
	@Test 
	void testExiberCorredor () {
		String msg = "Mark Zuckerberg - 123456789-98 - ADULTO";
		
		assertEquals(p.exibirCorredor("123456789-98"), msg);
	}
	 @Test
	 void testResistenciaCorredor() {
		p.cadastrarProgramador("Mark Zuckerberg", "123456789-96", 1984);
		
		p.cadastrarTreinoCorredor("123456789-96", 5.0, 2, "projeto correr igual o flash");// id 0
		//  p.cadastrarTreinoCorredor("987654321-23", 4, 2,"idade chegando e a hipertensao tambem");
		 // p.cadastrarTreinoCorredor("987456321-65", 3, 4,"corre 1h, caminha 30mim e descanca 1min");
		p.cadastrarTreinoCorredor("123456789-96", 2.2, 1, "maratona de sao paulo");//id1
		p.cadastrarTreinoCorredor("123456789-96", 40.2, 4, "virar atleta");// id 2
		p.cadastrarTreinoCorredor("123456789-96", 20.2, 6, "lalalalalalalala");// id 3
		
		p.finalizarTreino("123456789-96", 0, 2); 
		p.finalizarTreino("123456789-96", 1, 1);
		p.finalizarTreino("123456789-96", 2, 1);
		p.finalizarTreino("123456789-96", 3, 1); 
			
		assertEquals(p.resistenciaCorredor("123456789-98"), 0.25);
	  }
	 @Test
	 void conta() {
		 			
			p.cadastrarTreinoCorredor("123456789-96", 5.0, 2, "projeto correr igual o flash");// id 0
			//  p.cadastrarTreinoCorredor("987654321-23", 4, 2,"idade chegando e a hipertensao tambem");
			 // p.cadastrarTreinoCorredor("987456321-65", 3, 4,"corre 1h, caminha 30mim e descanca 1min");
			p.cadastrarTreinoCorredor("123456789-96", 2.2, 1, "maratona de sao paulo");//id1
			p.cadastrarTreinoCorredor("123456789-96", 40.2, 4, "virar atleta");// id 2
			p.cadastrarTreinoCorredor("123456789-96", 20.2, 6, "lalalalalalalala");// id 3
			
			p.finalizarTreino("123456789-96", 0, 2); 
			p.finalizarTreino("123456789-96", 1, 1);
			p.finalizarTreino("123456789-96", 2, 1);
			p.finalizarTreino("123456789-96", 3, 1); 
			
			assertEquals(p.contarTreinosFinalizadosCorredor("123456789-96"),4);
		 
	 }
	 
}
