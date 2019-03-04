package org.sample;

import io.smallrye.reactive.messaging.kafka.KafkaMessage;
import io.smallrye.reactive.messaging.kafka.MessageHeaders;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

@ApplicationScoped
public class Receiver {

    private static final Logger LOGGER = Logger.getLogger(Receiver.class.getName());

    @Incoming("kafka")
    public CompletionStage<Void> consume(KafkaMessage<String, String> message) {
        String payload = message.getPayload();
        String key = message.getKey();
        MessageHeaders headers = message.getHeaders();
        Integer partition = message.getPartition();
        Long timestamp = message.getTimestamp();
        LOGGER.info("received: " + payload + " from topic " + message.getTopic());
        return message.ack();
    }

}
