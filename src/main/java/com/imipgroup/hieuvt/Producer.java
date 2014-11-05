package com.imipgroup.hieuvt;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created by hieu.vutrong on 11/5/2014.
 */
public class Producer {

    public void sendMessage(String message) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.HOST);
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(Constants.QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", Constants.QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
