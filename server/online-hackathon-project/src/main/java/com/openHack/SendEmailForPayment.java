package com.openHack;

import java.io.IOException;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class SendEmailForPayment {
	
	public boolean sendMail(String email, String subject, String body, String url) throws IOException
	{
		
//		Email from = new Email("results@hackathon.com");
		Email from = new Email("test@example.com");
	    Email to = new Email(email);

		Content content = new Content();
		content.setType("text/html");
		content.setValue("<html><body><b>"+body+" : "+"</b><a href = '"+url+"'>here</a></body></html>");
		Mail mail = new Mail(from, subject, to, content);
		SendGrid sg = new SendGrid("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");
		Request request = new Request();
		try 
		{
		    request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			} catch (IOException ex) {throw ex;}
		  
		return false;
	}
}
