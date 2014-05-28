package br.com.zaul.messaging.activemq.topic;

import javax.jms.JMSException;

import org.junit.Test;

import br.com.zaul.messaging.activemq.topic.publisher.MessagePublisher;
import br.com.zaul.messaging.activemq.topic.subscriber.FirstMessageSubscriber;

public class TopicTest {

	@Test
	public void testMessage() throws JMSException {
		MessagePublisher messagePublisher = new MessagePublisher();
		
		messagePublisher.sendMessage("My Topic");
		
		FirstMessageSubscriber firstMessageSubscriber = new FirstMessageSubscriber();
		firstMessageSubscriber.init();
	}
}
