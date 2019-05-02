package ms.familia.moradia.controllers;

import java.util.List;

import ms.familia.moradia.dict.StatusFamilias;
import ms.familia.moradia.models.Familias;
import ms.familia.moradia.models.FamiliasContempladas;
import ms.familia.moradia.repository.TodasFamilias;
import ms.familia.moradia.repository.TodasFamiliasContempladas;
import ms.familia.moradia.services.ProcessarPontuacaoPattern;
import ms.familia.moradia.services.SendKafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class FamiliasResource {
	
	private final static Logger log = LoggerFactory.getLogger(FamiliasResource.class);
	
	@Autowired
	private TodasFamilias todasFamilias;
	@Autowired
	private TodasFamiliasContempladas todasFamiliasContempladas;
	@Autowired
	private static ProcessarPontuacaoPattern processarPontuacaoPattern;
	@Autowired
	private static SendKafka sendKafka;	
	private static final String TOPIC_FAMILIAS_CONTEMPLADAS = "FamiliasContempladas";
	
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping() {	
		log.info("RequestService: /ping");
	    return new ResponseEntity<>("Pong!", HttpStatus.OK);
	}
	
	@GetMapping("/familias")
	public ResponseEntity<List<Familias>> familiasTodas() {		
		List<Familias> familias = todasFamilias.findAll();
		log.info("RequestService: /familias - Familias: {}", familias.size());
		return new ResponseEntity<>(familias, HttpStatus.OK);
	}
	
	@GetMapping("/familias/{id}")
	public ResponseEntity<Familias> familiaBy(@PathVariable(value = "id") long id) {		
		try {
			Familias familia = todasFamilias.findById(id);
			log.info("RequestService: /familias/{} - Familia: {} com {} integrantes", id, familia.getNome(), familia.getPessoas().size());
			return new ResponseEntity<>(familia, HttpStatus.OK);
		} catch (Exception e) {
			log.info("RequestService: /familias/{} - objeto não encontrado", id);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}	
	
	@GetMapping("/familias/Contempladas")
	public ResponseEntity<List<FamiliasContempladas>> familiasContempadasTodas() {		
		try {
			List<FamiliasContempladas> familias = todasFamiliasContempladas.findAll();
			log.info("RequestService: /familias - Familias: {}", familias.size());
			//sendKafka.sendKafka(TOPIC_FAMILIAS_CONTEMPLADAS, familias);
			return new ResponseEntity<>(familias, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/familias/chain")
	public List<FamiliasContempladas> familiasPossiveisPontuacao2() throws  NoSuchBeanDefinitionException {		
		List<Familias> familias = todasFamilias.findByStatus(StatusFamilias.CADASTRO_VALIDO.ordinal());		
		List<FamiliasContempladas> familiasContempladas = processarPontuacaoPattern.processaFamilias(familias);
		todasFamiliasContempladas.saveAll(familiasContempladas);		
		
		//sendKafka.sendKafka(TOPIC_FAMILIAS_CONTEMPLADAS, familiasContempladas);	
		
		log.info("RequestService: /familias/pontuacao. Familias selecionadas: {} - FamiliasContempladas: {}",familias.size(), familiasContempladas.size());
		return familiasContempladas;
	}
}