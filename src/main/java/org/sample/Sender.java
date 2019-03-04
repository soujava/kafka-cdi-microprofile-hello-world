package org.sample;

import io.smallrye.reactive.messaging.kafka.KafkaMessage;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@ApplicationScoped
public class Sender {

    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    private static final Logger LOGGER = Logger.getLogger(Sender.class.getName());

    @Outgoing("data")
    public CompletionStage<KafkaMessage<String, String>> send() {
        CompletableFuture<KafkaMessage<String, String>> future = new CompletableFuture<>();
        LOGGER.info("Sending message to kafka with the message hello from MicroProfile");
        delay(() -> future.complete(KafkaMessage.of("kafka", "key", "hello from MicroProfile")));
        return future;
    }

    private void delay(Runnable runnable) {
        executor.schedule(runnable, 5, TimeUnit.SECONDS);
    }

}