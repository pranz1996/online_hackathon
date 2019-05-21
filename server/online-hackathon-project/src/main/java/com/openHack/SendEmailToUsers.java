package com.openHack;

import com.sendgrid.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SendEmailToUsers 
{
	public boolean sendMail(String email, String subject, String body) throws IOException
	{
		//String url = "http://localhost:3000/results";
		String url = Config_url.url + "/results";
		
		
		Email from = new Email("results@hackathon.com");
	    Email to = new Email(email);

		Content content = new Content();
		content.setType("text/html");
		content.setValue("<html><body><b>"+body+" : "+"</b><a href = "+url+">here</a></body></html>");
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
