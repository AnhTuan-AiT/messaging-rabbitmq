//package com.example.messagingrabbitmq;
//
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Arrays;
//
//import static com.example.messagingrabbitmq.MessagingRabbitmqApplication.queueName;
//
//@Component
//@EnableAsync
//public class Receiver {
//
////	private CountDownLatch latch = new CountDownLatch(1);
//
//    private final RabbitTemplate rabbitTemplate;
//
//    public Receiver(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
////    @Async
////    @Scheduled(fixedRate = 2000)
//    public void receiveMessage(String message) throws InterruptedException {
////        Message message = rabbitTemplate.receive(queueName, 5000);
//        if (message != null) {
//            System.out.println("Thread " + Thread.currentThread().getName() + ": Received <" + message + ">");
//            Thread.sleep(3000);
//        }
//    }
//
////	public CountDownLatch getLatch() {
////		return latch;
////	}
//
//}
