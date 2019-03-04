package org.sample;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        Sender sender = container.select(Sender.class).get();
        sender.add("Hello world");
        sender.add("Otávio");
        sender.add("Poliana");
        sender.add("Clement");
    }
}
