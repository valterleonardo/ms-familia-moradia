package ms.familia.moradia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import ms.familia.moradia.models.FamiliasContempladas;

public class SendKafka {
	
	@Autowired
    private static KafkaTemplate<String, List<FamiliasContempladas>> kafkaTemplate;
	
	public void sendKafka(String topic, List<FamiliasContempladas> familias) {
		
		kafkaTemplate.send(topic, familias);
	}

}
