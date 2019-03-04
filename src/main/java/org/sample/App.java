package org.sample;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Sender sender = container.select(Sender.class).get();
            Consumer consumer = container.select(Consumer.class).get();
            for (int i = 0; i < 1_0000; i++) {
                sender.send();
            }

        }
    }
}
