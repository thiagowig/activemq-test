package br.com.zaul.messaging.activmq;

import javax.jms.JMSException;

import junit.framework.Assert;

import org.junit.Test;

import br.com.zaul.messaging.activmq.receiver.MessageReceiver;
import br.com.zaul.messaging.activmq.sender.MessageSender;

public class QueueTest {
   
	@Test
	public void testMessage() throws JMSException {
		MessageSender sender = new MessageSender();
		MessageReceiver receiver = new MessageReceiver();
		
		String sendedMessage = "My Message";
		
		sender.sendMessage(sendedMessage);
		String returnedMessage = receiver.receiveMessage();
		
		Assert.assertEquals(returnedMessage, sendedMessage);
	}
	
}
