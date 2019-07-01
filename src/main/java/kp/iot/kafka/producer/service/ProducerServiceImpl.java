package kp.iot.kafka.producer.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import kp.iot.kafka.producer.model.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService{


    private static final String TOPIC = "Kafka_Topic";
    private static final String TOPIC_ARRAY = "Kafka_Topic_Array";

    @Autowired
    public KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendData(MessageDto messageDto) {
        Gson gson = new Gson();
        String messageJson = gson.toJson(messageDto);
        System.out.println("Sending Json Packet :  " + messageJson);
        kafkaTemplate.send(TOPIC, messageJson);
    }

    @Override
    public void sendData(List<MessageDto> messageDto) {
        Gson gson = new GsonBuilder().create();
         JsonArray messageJson = gson.toJsonTree(messageDto).getAsJsonArray();
        kafkaTemplate.send(TOPIC_ARRAY, messageJson.toString());
    }
}