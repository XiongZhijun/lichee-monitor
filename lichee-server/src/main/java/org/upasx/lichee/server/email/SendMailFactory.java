package org.upasx.lichee.server.email;

import java.util.*;

import org.upasx.lichee.server.email.modle.SendMail;

public class SendMailFactory {
    
    public static SendMail getSendMailModel(String to) {
    	return new SendMail(Arrays.asList(to));
    }
    
    public static SendMail getSendMailModel(List<String> to) {
    	return new SendMail(to);
    }
    
}
