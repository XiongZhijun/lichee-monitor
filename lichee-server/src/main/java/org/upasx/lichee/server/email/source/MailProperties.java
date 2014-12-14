package org.upasx.lichee.server.email.source;

import java.util.Properties;

public class MailProperties {

    private static String host = "smtp.126.com";
    private static String port = "25";
    
	public static Properties instance;
	
	public static Properties getInstance() {
		if(instance == null) {
	    	Properties props = new Properties();
	    	props.put("mail.smtp.host", host);
	    	props.put("mail.smtp.port", port);
	    	props.put("mail.smtp.auth", "true");
	    	instance = props;
		} 
		return instance;
	}
}
