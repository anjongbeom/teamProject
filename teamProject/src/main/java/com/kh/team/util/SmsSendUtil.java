package com.kh.team.util;

import java.util.HashMap;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

/**
 * @class ExampleSend
 * @brief This sample code demonstrate how to send sms through CoolSMS Rest API
 *        PHP
 */

// run as > java application
@Component
public class SmsSendUtil {
	public void sendSms(String reciever, String content) {
		String api_key = "NCSSXOI2LYFRNU6U";
		String api_secret = "6M8BHGPVUJDSXBF1M6JDTQXHLB4T0BEF";
		Message coolsms = new Message(api_key, api_secret);

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", reciever);
		params.put("from", "01056605209"); // 무조건 자기번호 (인증)
		params.put("type", "SMS");
		params.put("text", content);
		
		
		params.put("app_version", "test app 1.2"); // application name and version

		try {
			// send() 는 메시지를 보내는 함수
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		} 
	}	
}