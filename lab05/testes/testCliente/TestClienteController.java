package testCliente;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.ClienteController;

class TestClienteController {

	private ClienteController cliente;
	
	@BeforeEach
	void setUp() throws Exception {
		cliente = new ClienteController();
		
		cliente.cadastraCliente("124", "sol", "sol@ccc.ufcg.edu.br", "lsd");
	}

	@Test
	void testcadastraCliente() {
		assertEquals(cliente.cadastraCliente("123", "lua", "lua@ccc.ufcg.edu.br", "splab"), "123");
		assertThrows(IllegalArgumentException.class, () -> {
			cliente.cadastraCliente(null, "teodoro", "teodoro_lidinho@gmail.com", "pracinha");
		});
	}

}
