package org.upasx.lichee.server.email.modle;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import org.upasx.lichee.server.email.source.MailAuthenticator;
import org.upasx.lichee.server.email.source.MailProperties;


public class SendMail {
	
    private static String fromUsernameTest = "law01liu@126.com";
    
    private List<String> toList;
    
    public SendMail(List<String> toList) {
    	this.toList = toList;
    }

	public void send(String subject, String content) {
    	
    	Session session = Session.getInstance(MailProperties.getInstance(), MailAuthenticator.INSTANCE);
    	try {
    	    MimeMessage msg = new MimeMessage(session);
    	    msg.setFrom(new InternetAddress(fromUsernameTest));
    	    InternetAddress[] address = new InternetAddress[toList.size()];
    	    for(int i = 0; i < toList.size(); i++)    {
    	    	address[i] = new InternetAddress(toList.get(i));
    	    }
    	    
    	    msg.setRecipients(Message.RecipientType.TO, address);
    	    msg.setSubject(subject);
    	    msg.setSentDate(new Date());
    	    msg.setText(content);
    	    
    	    Transport.send(msg);
    	} catch (MessagingException mex) {
    	    mex.printStackTrace();
    	    Exception ex = mex;
    	    do {
    		if (ex instanceof SendFailedException) {
    		    SendFailedException sfex = (SendFailedException)ex;
    		    Address[] invalid = sfex.getInvalidAddresses();
    		    if (invalid != null) {
    			System.out.println("    ** Invalid Addresses");
    			for (int i = 0; i < invalid.length; i++) 
    			    System.out.println("         " + invalid[i]);
    		    }
    		    Address[] validUnsent = sfex.getValidUnsentAddresses();
    		    if (validUnsent != null) {
    			System.out.println("    ** ValidUnsent Addresses");
    			for (int i = 0; i < validUnsent.length; i++) 
    			    System.out.println("         "+validUnsent[i]);
    		    }
    		    Address[] validSent = sfex.getValidSentAddresses();
    		    if (validSent != null) {
    			System.out.println("    ** ValidSent Addresses");
    			for (int i = 0; i < validSent.length; i++) 
    			    System.out.println("         "+validSent[i]);
    		    }
    		}
    		System.out.println();
    		if (ex instanceof MessagingException)
    		    ex = ((MessagingException)ex).getNextException();
    		else
    		    ex = null;
    	    } while (ex != null);
    	}
    	
    }
    
}
