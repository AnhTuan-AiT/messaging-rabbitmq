package com.example.messagingrabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
//    private final Receiver receiver;

    public Runner(
//            Receiver receiver,
            RabbitTemplate rabbitTemplate) {
//        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending messages...");
        for (int i = 0; i < 1000; i++) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.topicExchangeName, "foo.bar.baz", "#" + (i + 1) + ": Hello from RabbitMQ!");
        }
    }
}
