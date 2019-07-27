package com.sekhanov.rabbitmq.producer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Publisher {

    private final static String QUEUE_NAME = "products_queue";

    public static void main(String[]args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("rabbitmq");
        factory.setPassword("rabbitmq");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String message = "";
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        try(Scanner scanner = new Scanner(System.in)) {
           while (!message.equals("exit")) {
            System.out.println("enter the message");
            message = scanner.next();
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
           }
        } catch (Exception e) {
            //TODO: handle exception
        }
        channel.close();
        connection.close();
    }
}
