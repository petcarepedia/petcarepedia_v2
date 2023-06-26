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
	// ���� �߻�(�����е� ���뷯)
	
		public void makeRandomNumber() {
			// ������ ���� 111111 ~ 999999 (6�ڸ� ����)
			Random r = new Random();
			int checkNum = r.nextInt(888888) + 111111;
			authNumber = checkNum;
		}
		
		
				//�̸��� ���� ���! 
		public String joinEmail(String email) {
			makeRandomNumber();
			String setFrom = ".com"; // email-config�� ������ �ڽ��� �̸��� �ּҸ� �Է� 
			String toMail = email;
			String title = "���ɾ��ǵ�� ȸ�� ���� ���� �̸��� �Դϴ�."; // �̸��� ���� 
			String content = 
					"<div style='width:410px; margin:0 auto; padding:30px 0;  text-align: center; '>" + 
					"        <h1 style='display: inline-block; vertical-align: top; color:#636363; '><span style='color:#FFB3BD'>��</span>ĳ��<span style='color:#98DFFF'>�ǵ�� </span></h1>" + 
					"        <img style='margin-top: 20px;' src='https://postfiles.pstatic.net/MjAyMzA2MTBfMTg4/MDAxNjg2NDA4OTM5MjE3.xeooMm_uyeWMiVyrIZgDk0YbHnGanlh1hrVfrspq7Xkg.L1aOIomPKf9fdWnDnuGmNGojChaLbGizj84F5nT_G9og.PNG.slee272/foot_blue.png?type=w966' width='30px'>" + 
					"        <div style='width:100%; margin:0 auto; padding:20px 0; border:1px solid #7AB2CC; border-left: none; border-right: none;'>" + 
					"            <h2 style='color:#7AB2CC'>�̸��� ���� �ڵ�</h2>" + 
					"            <p style='font-size:13px; margin-bottom: 20px;'>" + 
					"                �츮 ���� �������� ���� ���� <strong style='color:#7AB2CC'>��ĳ���ǵ��</strong>�� ���� ���� ȯ���մϴ�.<br>" + 
					"                �Ʒ��� �����ڵ带 �Է��Ͻø� �̸��� ������ ���������� �Ϸ�˴ϴ�." + 
					"            </p>" + 
					"            <h2 style='text-align: center; width:100%; background-color: #7AB2CC; margin: auto; padding: 10px 0; color:white; margin-bottom: 30px;'>"+authNumber+"</h2>" + 
					"        </div>" + 
					"        <div style='width:100%; margin:20px auto; text-align: left;'>" + 
					"            <p style='font-size:10px; color:gray; line-height: 16px;'>" + 
					"                �� ������ �߽� �����̸�, ���ǿ� ���� ȸ���� ó������ �ʽ��ϴ�." + 
					"                <br>��ĳ���ǵ�ƿ� �����Ͽ� �ñ��Ͻ� ���̳� ������ ������ ����Ʈ�� �������ּ���." + 
					"                <br>(��)��ĳ���ǵ�� | ��ǥ: �迬�� | �ּ�: ����Ư���� ������ ������ 242" + 
					"                <br>����: <a href='#'>petcarepedia@petcarepedia.com</a>" + 
					"                <br>Copyright <strong>PetCarePedia Inc.</strong> All rights reserved" + 
					"            </p>" + 
					"        </div>" + 
					"    </div>"; //�̸��� ���� ����
			mailSend(setFrom, toMail, title, content);
			return Integer.toString(authNumber);
		}
		
		public String idFindEmail(MemberVo memberVo, String mid) {
			String setFrom = ".com"; // email-config�� ������ �ڽ��� �̸��� �ּҸ� �Է� 
			String toMail = memberVo.getEmail();
			String title = "���ɾ��ǵ�� ���̵� Ȯ�� �̸��� �Դϴ�."; // �̸��� ���� 
			String content = 
					"<div style='width:410px; margin:0 auto; padding:30px 0;  text-align: center; '>" + 
					"        <h1 style='display: inline-block; vertical-align: top; color:#636363; '><span style='color:#FFB3BD'>��</span>ĳ��<span style='color:#98DFFF'>�ǵ�� </span></h1>" + 
					"        <img style='margin-top: 20px;' src='https://postfiles.pstatic.net/MjAyMzA2MTBfMTg4/MDAxNjg2NDA4OTM5MjE3.xeooMm_uyeWMiVyrIZgDk0YbHnGanlh1hrVfrspq7Xkg.L1aOIomPKf9fdWnDnuGmNGojChaLbGizj84F5nT_G9og.PNG.slee272/foot_blue.png?type=w966' width='30px'>" + 
					"        <div style='width:100%; margin:0 auto; padding:20px 0; border:1px solid #7AB2CC; border-left: none; border-right: none;'>" + 
					"            <h2 style='color:#7AB2CC'>���̵� ã�� ���</h2>" + 
					"            <p style='font-size:13px; margin-bottom: 20px;'>" + 
					"                �츮 ���� �������� ���� ���� <strong style='color:#7AB2CC'>��ĳ���ǵ��</strong>�� ���� ���� ȯ���մϴ�.<br>" + 
					memberVo.getName()+"�Բ��� ȸ�� ���� �� ����� ���̵�� �Ʒ��� �����ϴ�." + 
					"            </p>" + 
					"            <h2 style='text-align: center; width:100%; background-color: #7AB2CC; margin: auto; padding: 10px 0; color:white; margin-bottom: 30px;'>"+mid+"</h2>" + 
					"        </div>" + 
					"        <div style='width:100%; margin:20px auto; text-align: left;'>" + 
					"            <p style='font-size:10px; color:gray; line-height: 16px;'>" + 
					"                �� ������ �߽� �����̸�, ���ǿ� ���� ȸ���� ó������ �ʽ��ϴ�." + 
					"                <br>��ĳ���ǵ�ƿ� �����Ͽ� �ñ��Ͻ� ���̳� ������ ������ ����Ʈ�� �������ּ���." + 
					"                <br>(��)��ĳ���ǵ�� | ��ǥ: �迬�� | �ּ�: ����Ư���� ������ ������ 242" + 
					"                <br>����: <a href='#'>petcarepedia@petcarepedia.com</a>" + 
					"                <br>Copyright <strong>PetCarePedia Inc.</strong> All rights reserved" + 
					"            </p>" + 
					"        </div>" + 
					"    </div>"; //�̸��� ���� ����
			mailSend(setFrom, toMail, title, content);
			return Integer.toString(authNumber);
		}
		
		//�̸��� ���� �޼ҵ�
		public void mailSend(String setFrom, String toMail, String title, String content) { 
			MimeMessage message = mailSender.createMimeMessage();
			// true �Ű����� �����ϸ� multipart ������ �޼��� ������ ����.���� ���ڵ� ������ �����ϴ�.
			try {
				MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
				helper.setFrom(setFrom);
				helper.setTo(toMail);
				helper.setSubject(title);
				// true ���� > html �������� ���� , �ۼ����� ������ �ܼ� �ؽ�Ʈ�� ����.
				helper.setText(content,true);
				mailSender.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		
	
}
