package br.com.zaul.messaging.activmq.sender;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {
	
	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private Destination destination;
	private MessageProducer messageProducer;
	
	private void init() throws JMSException {
		connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		connection = connectionFactory.createConnection();
		connection.start();
		
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		destination = session.createQueue("TestQueue");
		
		messageProducer = session.createProducer(destination);
	}
	
	public void sendMessage(String message) throws JMSException {
		init();
		
		TextMessage textMessage = session.createTextMessage();
		
		textMessage.setText(message);
		
		messageProducer.send(textMessage);
		
		System.out.println("Sent: " + textMessage.getText());
	}

}
