package br.com.zaul.messaging.activmq.receiver;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageReceiver {
	
	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private Destination destination;
	private MessageConsumer messageConsumer;
	
	private void init() throws JMSException {
		connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		connection = connectionFactory.createConnection();
		connection.start();
		
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		destination = session.createQueue("TestQueue");
		
		messageConsumer = session.createConsumer(destination);
	}
	
	public String receiveMessage() throws JMSException {
		init();
		
		Message message = messageConsumer.receive();
		
		if (message instanceof TextMessage) {
            TextMessage text = (TextMessage) message;
            return text.getText();
        }
		
		return "";
	}

}
