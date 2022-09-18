package com.example.messagingrabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    static final String topicExchangeName = "spring-boot-exchange";

    static final String queueName = "spring-boot-rabbitmq-learning";

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();

        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
//        container.setTaskExecutor(taskExecutor); // may be not necessary, by default, it uses a SimpleAsyncTaskExecutor
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // This config works
        container.setPrefetchCount(2); // This config works
        container.setConcurrentConsumers(4);
        container.setMaxConcurrentConsumers(10);

        // Consider tuning 2 following config
        container.setConsecutiveActiveTrigger(1);
        container.setConsecutiveIdleTrigger(1);

        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(ProgrammingContestReceiver receiver) {
        return new MessageListenerAdapter(receiver);
    }

}
