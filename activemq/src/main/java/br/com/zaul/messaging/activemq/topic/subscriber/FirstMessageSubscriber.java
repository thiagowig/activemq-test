package br.com.zaul.messaging.activemq.topic.subscriber;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class FirstMessageSubscriber {

	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private Topic topic;
	private MessageConsumer messageConsumer;
	private MessageListener messageListener;
	
	public void init() throws JMSException {
		connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		connection = connectionFactory.createConnection();
		connection.start();
		
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		topic = session.createTopic("TestTopic");
		
		messageConsumer = session.createConsumer(topic);
		
		messageListener = new MessageListener() {
			
			public void onMessage(Message message) {
				try {
					TextMessage textMessage = (TextMessage) message;
					System.out.println("First Subscriber: " + textMessage.getText());
					
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		};
		
		messageConsumer.setMessageListener(messageListener);
		
	}
	
}
