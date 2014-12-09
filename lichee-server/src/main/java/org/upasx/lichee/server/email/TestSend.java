package org.upasx.lichee.server.email;

public class TestSend {
	
	public static void main(String[] args) {
		
		String toMail = "705205250@qq.com";
		String subject = "Test Subject";
		String content = "Test Content";
		
		SendMailFactory.getSendMailModel(toMail)
						.send(subject, content);
		
	}
}
