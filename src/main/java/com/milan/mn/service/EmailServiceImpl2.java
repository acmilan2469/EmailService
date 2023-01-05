package com.milan.mn.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.milan.mn.model.EmailModel;

@Component
public class EmailServiceImpl2 {
	
	private final EmailService service;

	public EmailServiceImpl2(@Qualifier("secondService") EmailService service) {
		this.service = service;
	}
	
	public String sendEmail(EmailModel email) {
		return service.sendEmail(email);
	}

}
