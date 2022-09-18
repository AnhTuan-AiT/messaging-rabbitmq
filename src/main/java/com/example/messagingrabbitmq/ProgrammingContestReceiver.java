package com.example.messagingrabbitmq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Component
public class ProgrammingContestReceiver implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        byte[] body = message.getBody();
        System.out.println("Thread " + Thread.currentThread().getName() + ": Received <" + new String(body) + ">");
        Thread.sleep(1000);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
