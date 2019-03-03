package org.sample;

import io.smallrye.reactive.messaging.kafka.KafkaMessage;
import io.smallrye.reactive.messaging.kafka.MessageHeaders;
import kafka.utils.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class Consumer {


    @Incoming("kafka")
    public void consume(KafkaMessage<String, JsonObject> message) {
        JsonObject payload = message.getPayload();
        String key = message.getKey();
        MessageHeaders headers = message.getHeaders();
        Integer partition = message.getPartition();
        Long timestamp = message.getTimestamp();
    }

}
