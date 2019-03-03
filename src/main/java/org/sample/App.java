package org.sample;

import org.eclipse.microprofile.reactive.messaging.Message;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Sender consumer = container.select(Sender.class).get();
            Message<String> incoming = Message.of("hello");
            consumer.send(incoming);
        }
    }
}
