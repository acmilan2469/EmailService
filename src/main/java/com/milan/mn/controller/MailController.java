package com.milan.mn.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milan.mn.model.EmailModel;
import com.milan.mn.service.EmailServiceImpl;
import com.milan.mn.service.EmailServiceImpl2;

@RestController
@RequestMapping("/sendMail")
public class MailController {
	
	private final EmailServiceImpl serviceImpl;
	private final EmailServiceImpl2 serviceImpl2;	

	public MailController(EmailServiceImpl serviceImpl, EmailServiceImpl2 serviceImpl2) {
		super();
		this.serviceImpl = serviceImpl;
		this.serviceImpl2 = serviceImpl2;
	}


	@PostMapping("/")
	public String sendEmail(@RequestBody EmailModel email) {
		String msg = serviceImpl.sendEmail(email);
		if(msg.equals("Success")) {
			msg = serviceImpl.sendEmail(email);
		}else {
			msg = serviceImpl2.sendEmail(email);
		}
		return msg;
	}
		
}
