package kp.iot.kafka.producer;

import kp.iot.kafka.producer.model.MessageDto;
import kp.iot.kafka.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableScheduling
public class EventScheduler {

    @Autowired
    private ProducerService producerService;


//    @Autowired
//    private SimpMessagingTemplate template;


    @Scheduled(fixedDelay = 10000, initialDelay = 10000)
    public void scheduleFixedRateWithInitialDelayTask() {
        MessageDto messageDto = new MessageDto();
        messageDto.setMessage("Message to test 1");
        producerService.sendData(messageDto);


        MessageDto messageDto2 = new MessageDto();
        messageDto2.setMessage("Message to test 2");

        List<MessageDto> dtos = new ArrayList<>();

        dtos.add(messageDto);
        dtos.add(messageDto2);
        producerService.sendData(dtos);
    }
}