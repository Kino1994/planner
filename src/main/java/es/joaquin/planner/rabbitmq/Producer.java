package es.joaquin.planner.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import es.joaquin.planner.model.api.EoloPlantResponse;

@Component
public class Producer {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Scheduled(fixedRate = 2000)
	public void received(EoloPlantResponse eoloplantResponse) {
		rabbitTemplate.convertAndSend("eoloplantResponseCreationProgressNotifications", eoloplantResponse);		
	}
}