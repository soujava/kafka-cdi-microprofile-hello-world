package org.sample;

import io.smallrye.reactive.messaging.kafka.KafkaMessage;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;

@ApplicationScoped
public class Sender {

    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    private static final Logger LOGGER = Logger.getLogger(Sender.class.getName());

    private BlockingQueue<String> messages = new LinkedBlockingQueue<>();

    public void add(String message) {
        messages.add(message);
    }

    @Outgoing("data")
    public CompletionStage<KafkaMessage<String, String>> send() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String message = messages.take();
                LOGGER.info("Sending message to kafka with the message: " + message);
                return KafkaMessage.of("kafka", "key", message);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

}