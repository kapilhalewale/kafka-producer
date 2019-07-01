package kp.iot.kafka.producer.service;


import kp.iot.kafka.producer.model.MessageDto;

import java.util.List;

public interface ProducerService {

    void sendData(MessageDto messageDto);
    void sendData(List<MessageDto> messageDto);
}
