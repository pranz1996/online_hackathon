package com.openHack;

import com.sendgrid.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SendEmail {
  public static void main(String[] args) throws IOException {
	  
	  List<String> listofemails = new ArrayList<String>();
	  listofemails.add("aakash.alurkar95@gmail.com");
	  listofemails.add("aakash.alurkar@sjsu.edu");
	  
	  for(String s : listofemails) {
		    Email from = new Email("test@example.com");
		    String subject = "email subject";
		    Email to = new Email(s);
		    Content content = new Content("text/plain", "email body");
		    Mail mail = new Mail(from, subject, to, content);
		    SendGrid sg = new SendGrid("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");
		    Request request = new Request();
		    try {
		      request.setMethod(Method.POST);
		      request.setEndpoint("mail/send");
		      request.setBody(mail.build());
		      Response response = sg.api(request);
		    } catch (IOException ex) {throw ex;}
	  }
	 
  }
}