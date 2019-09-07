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
		
		p.cadastrarTreinoCorredor("123456789-98", 5, 10, "projeto correr igual o flash");
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
		
		assertEquals(p.exiberCategoriaCorredor("123456789-98"), "ADULTO");
		assertEquals(p.exiberCategoriaCorredor("987654321-23"), "SUPER_ADULTO");
		assertEquals(p.exiberCategoriaCorredor("987456321-65"), "MELHOR_IDADE");
		assertEquals(p.exiberCategoriaCorredor("987456321-78"), "JOVEM");
		
		assertEquals(p.exiberCategoriaCorredor("456987123- 12"), "JOVEM");
		assertEquals(p.exiberCategoriaCorredor("456987123- 13"), "SUPER_ADULTO");
		assertEquals(p.exiberCategoriaCorredor("456987123- 14"), "ADULTO");
		assertThrows(IllegalArgumentException.class, () -> p.exiberCategoriaCorredor("456987123- 56"));
		assertThrows(IllegalArgumentException.class, () -> p.exiberCategoriaCorredor("1254697632-26"));
	}
	
	@Test
	void testResistenciaCorredor() {
		
	}

}
