package com.milan.mn.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mailgun.api.v3.MailgunMessagesApi;
import com.mailgun.client.MailgunClient;
import com.mailgun.model.message.Message;
import com.mailgun.model.message.MessageResponse;
import com.milan.mn.model.EmailModel;

@Service
@Qualifier("firstService")
public class MailGunService implements EmailService{
	@Value("${MAILGUN_API_KEY}")
	private String API_KEY;
	
	@Value("${MAILGUN_DOMAIN_NAME}")
	private String DOMAIN_NAME;
	
	//public static final String DOMAIN_NAME = "sandbox84caec08aee94570a987dc274dfd70ae.mailgun.org";
	//public static final String API_KEY = "71b191ca7993cf64e20433703f7d4b63-cc9b2d04-75c83e57";
	
	@Override
	public String sendEmail(EmailModel email) {
		MessageResponse response = sendSimpleMessage(email);
		if (response != null) {
			return "Success";
		}
		return "Failure";
	}
	
	public MessageResponse sendSimpleMessage(EmailModel email) {
		try {
			MailgunMessagesApi mailgunMessagesApi = MailgunClient.config(API_KEY).createApi(MailgunMessagesApi.class);

			Message message = Message.builder().from(email.fromName + "<" + email.getFrom() + ">").to(email.getTo()).subject(email.getSubject()).text(email.getBody()).build();

			return mailgunMessagesApi.sendMessage(DOMAIN_NAME, message);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}
}
