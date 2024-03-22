package com.example.my_project;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class sms_message {
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    
    public static void sms_message(String details) { // Send message to my phone number
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+16048038651"),
                new com.twilio.type.PhoneNumber("+14245431565"),
                details)
            .create();
        
    	
    }
    
    
	
	
}
