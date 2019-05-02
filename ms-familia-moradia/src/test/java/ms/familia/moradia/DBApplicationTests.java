package ms.familia.moradia;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ms.familia.moradia.models.Familias;
import ms.familia.moradia.models.Pessoas;
import ms.familia.moradia.models.Rendas;
import ms.familia.moradia.repository.TodasFamilias;
import ms.familia.moradia.repository.TodasPessoas;
import ms.familia.moradia.repository.TodasRendas;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBApplicationTests {

	@Autowired
	TodasFamilias todasFamilias;
	@Autowired
	TodasPessoas todasPessoas;
	@Autowired
	TodasRendas todasRendas;
	
	@Test
	public void testaFamilias() {
		List<Familias> familias = todasFamilias.findAll();
		assertTrue(familias.size()>0);
	}
	
	@Test
	public void testaPessoas() {
		List<Pessoas> pessoas = todasPessoas.findAll();
		assertTrue(pessoas.size()>0);
	}
	
	@Test
	public void testaRendas() {
		List<Rendas> rendas = todasRendas.findAll();
		assertTrue(rendas.size()>0);
	}
}