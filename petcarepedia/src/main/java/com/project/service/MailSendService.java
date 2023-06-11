package com.project.service;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.project.vo.MemberVo;

@Component
public class MailSendService {
	@Autowired
	private JavaMailSenderImpl mailSender;
	private int authNumber; 
	// 난수 발생(여러분들 맘대러)
	
		public void makeRandomNumber() {
			// 난수의 범위 111111 ~ 999999 (6자리 난수)
			Random r = new Random();
			int checkNum = r.nextInt(888888) + 111111;
			authNumber = checkNum;
		}
		
		
				//이메일 보낼 양식! 
		public String joinEmail(String email) {
			makeRandomNumber();
			String setFrom = ".com"; // email-config에 설정한 자신의 이메일 주소를 입력 
			String toMail = email;
			String title = "펫케어피디아 회원 가입 인증 이메일 입니다."; // 이메일 제목 
			String content = 
					"<div style='width:410px; margin:0 auto; padding:30px 0;  text-align: center; '>" + 
					"        <h1 style='display: inline-block; vertical-align: top; color:#636363; '><span style='color:#FFB3BD'>펫</span>캐어<span style='color:#98DFFF'>피디아 </span></h1>" + 
					"        <img style='margin-top: 20px;' src='https://postfiles.pstatic.net/MjAyMzA2MTBfMTg4/MDAxNjg2NDA4OTM5MjE3.xeooMm_uyeWMiVyrIZgDk0YbHnGanlh1hrVfrspq7Xkg.L1aOIomPKf9fdWnDnuGmNGojChaLbGizj84F5nT_G9og.PNG.slee272/foot_blue.png?type=w966' width='30px'>" + 
					"        <div style='width:100%; margin:0 auto; padding:20px 0; border:1px solid #7AB2CC; border-left: none; border-right: none;'>" + 
					"            <h2 style='color:#7AB2CC'>이메일 인증 코드</h2>" + 
					"            <p style='font-size:13px; margin-bottom: 20px;'>" + 
					"                우리 동네 동물병원 리뷰 사전 <strong style='color:#7AB2CC'>펫캐어피디아</strong>에 오신 것을 환영합니다.<br>" + 
					"                아래의 인증코드를 입력하시면 이메일 인증이 정상적으로 완료됩니다." + 
					"            </p>" + 
					"            <h2 style='text-align: center; width:100%; background-color: #7AB2CC; margin: auto; padding: 10px 0; color:white; margin-bottom: 30px;'>"+authNumber+"</h2>" + 
					"        </div>" + 
					"        <div style='width:100%; margin:20px auto; text-align: left;'>" + 
					"            <p style='font-size:10px; color:gray; line-height: 16px;'>" + 
					"                본 메일은 발신 전용이며, 문의에 대한 회신은 처리되지 않습니다." + 
					"                <br>펫캐어피디아와 관련하여 궁금하신 점이나 불편한 사항은 사이트를 참고해주세요." + 
					"                <br>(주)펫캐어피디아 | 대표: 김연주 | 주소: 서울특별시 강남구 강변로 242" + 
					"                <br>문의: <a href='#'>petcarepedia@petcarepedia.com</a>" + 
					"                <br>Copyright <strong>PetCarePedia Inc.</strong> All rights reserved" + 
					"            </p>" + 
					"        </div>" + 
					"    </div>"; //이메일 내용 삽입
			mailSend(setFrom, toMail, title, content);
			return Integer.toString(authNumber);
		}
		
		public String idFindEmail(MemberVo memberVo, String mid) {
			String setFrom = ".com"; // email-config에 설정한 자신의 이메일 주소를 입력 
			String toMail = memberVo.getEmail();
			String title = "펫케어피디아 아이디 확인 이메일 입니다."; // 이메일 제목 
			String content = 
					"<div style='width:410px; margin:0 auto; padding:30px 0;  text-align: center; '>" + 
					"        <h1 style='display: inline-block; vertical-align: top; color:#636363; '><span style='color:#FFB3BD'>펫</span>캐어<span style='color:#98DFFF'>피디아 </span></h1>" + 
					"        <img style='margin-top: 20px;' src='https://postfiles.pstatic.net/MjAyMzA2MTBfMTg4/MDAxNjg2NDA4OTM5MjE3.xeooMm_uyeWMiVyrIZgDk0YbHnGanlh1hrVfrspq7Xkg.L1aOIomPKf9fdWnDnuGmNGojChaLbGizj84F5nT_G9og.PNG.slee272/foot_blue.png?type=w966' width='30px'>" + 
					"        <div style='width:100%; margin:0 auto; padding:20px 0; border:1px solid #7AB2CC; border-left: none; border-right: none;'>" + 
					"            <h2 style='color:#7AB2CC'>아이디 찾기 결과</h2>" + 
					"            <p style='font-size:13px; margin-bottom: 20px;'>" + 
					"                우리 동네 동물병원 리뷰 사전 <strong style='color:#7AB2CC'>펫캐어피디아</strong>에 오신 것을 환영합니다.<br>" + 
					memberVo.getName()+"님께서 회원 가입 시 사용한 아이디는 아래와 같습니다." + 
					"            </p>" + 
					"            <h2 style='text-align: center; width:100%; background-color: #7AB2CC; margin: auto; padding: 10px 0; color:white; margin-bottom: 30px;'>"+mid+"</h2>" + 
					"        </div>" + 
					"        <div style='width:100%; margin:20px auto; text-align: left;'>" + 
					"            <p style='font-size:10px; color:gray; line-height: 16px;'>" + 
					"                본 메일은 발신 전용이며, 문의에 대한 회신은 처리되지 않습니다." + 
					"                <br>펫캐어피디아와 관련하여 궁금하신 점이나 불편한 사항은 사이트를 참고해주세요." + 
					"                <br>(주)펫캐어피디아 | 대표: 김연주 | 주소: 서울특별시 강남구 강변로 242" + 
					"                <br>문의: <a href='#'>petcarepedia@petcarepedia.com</a>" + 
					"                <br>Copyright <strong>PetCarePedia Inc.</strong> All rights reserved" + 
					"            </p>" + 
					"        </div>" + 
					"    </div>"; //이메일 내용 삽입
			mailSend(setFrom, toMail, title, content);
			return Integer.toString(authNumber);
		}
		
		//이메일 전송 메소드
		public void mailSend(String setFrom, String toMail, String title, String content) { 
			MimeMessage message = mailSender.createMimeMessage();
			// true 매개값을 전달하면 multipart 형식의 메세지 전달이 가능.문자 인코딩 설정도 가능하다.
			try {
				MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
				helper.setFrom(setFrom);
				helper.setTo(toMail);
				helper.setSubject(title);
				// true 전달 > html 형식으로 전송 , 작성하지 않으면 단순 텍스트로 전달.
				helper.setText(content,true);
				mailSender.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		
	
}
