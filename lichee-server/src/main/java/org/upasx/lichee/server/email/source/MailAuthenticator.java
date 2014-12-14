package org.upasx.lichee.server.email.source;

import javax.mail.*;

public class MailAuthenticator extends Authenticator {

    private String username;
    private String password;
    
    public static MailAuthenticator INSTANCE = new MailAuthenticator();
    
    public MailAuthenticator() {
    	this.username = "law01liu@126.com";
    	this.password = "a1234567";
    }
    
    protected PasswordAuthentication getPasswordAuthentication() {
	    return new PasswordAuthentication(this.username, this.password);
    }
    
}
