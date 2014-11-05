package com.imipgroup.hieuvt;

import junit.framework.TestCase;

public class AppTest extends TestCase {
    public void testComponents(){
        Producer producer = new Producer();
        producer.sendMessage("Test message");
        Consumer consumer = new Consumer();
        consumer.receive();
    }
}