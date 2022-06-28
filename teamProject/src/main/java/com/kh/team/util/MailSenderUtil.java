package com.kh.team.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Component
public class MailSenderUtil {
	
	private static final String FROM = "kerk0214@gmail.com";

	@Autowired
	private JavaMailSender mailSender;
	

	// MailSendUtil 구현
	
	public void sendMail(String subject, String content, String to) {
		sendMail(subject, content, to, FROM);
	}
	
	public void sendMail(String subject, String content, String to, String from) {
//		 subject = "메일 테스트 제목1 입니다.";
//		 content = "메일 테스트 내용1 입니다." + "<img src=\"/product/displayImage?filename=C:/z_product/Dalmore.jpg\">";
//		 from = "kerk0214@gmail.com";
//		 to = "ajb5209@naver.com";
//			String subject = "메일 테스트 제목1 입니다.";
//			String content = "메일 테스트 내용1 입니다." + "<img src=\"/product/displayImage?filename=C:/z_product/Dalmore.jpg\">";
//			String  from = "kerk0214@gmail.com";
//			String  to = "ajb5209@naver.com";
		try {
			MimeMessage mail = mailSender.createMimeMessage();

			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
			// true는 멀티파트 메세지를 사용하겠다는 의미
			// 빈에 아이디 설정한 것은 단순히 smtp 인증을 받기 위해 사용 따라서 보내는이(setFrom())반드시 필요
			// 보내는이와 메일주소를 수신하는이가 볼때 모두 표기 되게 원하신다면 아래의 코드를 사용하시면 됩니다.
			// mailHelper.setFrom("보내는이 이름 <보내는이 아이디@도메인주소>");
			mailHelper.setFrom("김용현 <kerk0214@gmail.com>");
			mailHelper.setTo(to);
			mailHelper.setSubject(subject);
			mailHelper.setText(content, true);
			mailSender.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // mailSender

}
