package ms.familia.moradia;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ms.familia.moradia.controllers.FamiliasResource;
import ms.familia.moradia.repository.TodasFamilias;
import ms.familia.moradia.repository.TodasPessoas;
import ms.familia.moradia.repository.TodasRendas;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
	TodasFamilias todasFamilias;
	@Autowired
	TodasPessoas todasPessoas;
	@Autowired
	TodasRendas todasRendas;
	@Autowired
	FamiliasResource familiasResource;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(familiasResource).build();
	}
	
	@Test
	public void testeApiPing() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/ping")).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
	
