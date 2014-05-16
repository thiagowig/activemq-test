package br.com.zaul.messaging.activmq.topic;

import javax.jms.JMSException;

import org.junit.Test;

import br.com.zaul.messaging.activmq.topic.publisher.MessagePublisher;

public class TopicTest {

	@Test
	public void testMessage() throws JMSException {
		MessagePublisher messagePublisher = new MessagePublisher();
		
		messagePublisher.sendMessage("My Topic");
	}
}
