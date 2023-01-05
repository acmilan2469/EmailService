package com.milan.mn.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.milan.mn.model.EmailModel;
import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;

@Service
@Qualifier("secondService")
public class SparkPostService implements EmailService{
	
	@Value("${SPARKPOST_API_KEY}")
	private String API_KEY;

	@Override
	public String sendEmail(EmailModel email) {
        Client sparky = new Client(API_KEY);

        try {
			sparky.sendMessage(
			        email.from,
			        email.to,
			        email.subject,
			        email.body, "");
			System.out.println(sparky);
		} catch (SparkPostException e) {
			e.printStackTrace();
		}
		return null;
	}

}
