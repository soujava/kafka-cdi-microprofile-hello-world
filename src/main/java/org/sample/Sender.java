package org.sample;

import io.smallrye.reactive.messaging.kafka.KafkaMessage;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Sender {

    @Outgoing("kafka")
    public KafkaMessage<String, String> send(Message<String> incoming) {
        return KafkaMessage.of("topic", "key", incoming.getPayload());
    }
}
