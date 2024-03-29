package com.Alpha.Alpha.Service;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.Alpha.Alpha.Model.ApprovalMessage;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component
public class SmsService {

	private final String ACCOUNT_SID = "AC4216af2f23546f25bbf03f638972e826";

	private final String AUTH_TOKEN = "844bde20a3c66d68360876f7991409a8";

	private final String FROM_NUMBER = "+12015286219";

	public void send(ApprovalMessage sms) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
				.create();
		System.out.println("here is my id:" + message.getSid());// Unique resource ID created to manage this transaction

	}

	public void receive(MultiValueMap<String, String> smscallback) {
	}

}
