package com.project.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.project.vo.HospitalVo;
import com.project.vo.MemberVo;

@Service("fileService")
public class FileServiceImpl {
	/*
	 * file delete - �����ʻ��� ������ �� ���� ���� �������
	 */
	public void mfileDelete(MemberVo membmerVo, HttpServletRequest request, String oldFileName)
																				throws Exception{
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//������ �����ϸ� ������ ����
		if(!membmerVo.getFile1().getOriginalFilename().equals("")) {
			File deleteFile = new File(root_path + attach_path+ oldFileName);
			//boardVo.getFile1().transferTo(deleteFile); //upload ����    ->  JVM�� ������ ����Ǵ� ��ü�� �����Ͽ� �������ش�. �������ִ� ��ü deleteFile
			System.out.println(root_path + attach_path+ oldFileName);
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
		}
	}
	
	/*
	 * fileSave��� - ȸ�������ʻ��� ������
	 */
	
	public void mfileSave(MemberVo memberVo, HttpServletRequest request) throws Exception{
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//������ �����ϸ� ������ ����
		if(memberVo.getFile1().getOriginalFilename() != null && !memberVo.getFile1().getOriginalFilename().equals("")) {
			//System.out.println("save file--->" + hospitalVo.getHfile());			
			File saveFile = new File(root_path + attach_path + memberVo.getMsfile());
			
			memberVo.getFile1().transferTo(saveFile);
		}
	}
	
	/*
	 * fileCheck - ȸ�� ������ ���� üũ
	 */
	public MemberVo mfileCheck(MemberVo memberVo) {
		if(memberVo.getFile1().getOriginalFilename() != null
				&& !memberVo.getFile1().getOriginalFilename().contentEquals("")) {  //������ �����ϸ�
			
			//BSFILE ���� �ߺ� ó��
			UUID uuid = UUID.randomUUID();
			String mfile = memberVo.getFile1().getOriginalFilename();
			String msfile = uuid + "_" + mfile;
			memberVo.setMfile(mfile);
			memberVo.setMsfile(msfile);
		}else {
			System.out.println("���� ����");
//			hospitalVo.setHfile("");
//			hospitalVo.setHsfile("");
		}	
		
		return memberVo;
	}
	
	
	/**
	 * fileDelete- ���� ���� ���
	 */
	public void fileDelete(HttpServletRequest request, String oldFileName)
														throws Exception{
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//������ �����ϸ� ������ ����
		if(oldFileName != null && !oldFileName.equals("")) {
			File deleteFile = new File(root_path + attach_path+ oldFileName);
			
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
		}
	}
	
	/**
	 * fileDelete-  ������ �� ���� ���� ���� ���
	 */
	public void fileDelete2(HospitalVo hospitalVo, HttpServletRequest request, String oldFileName)
																				throws Exception{
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//������ �����ϸ� ������ ����
		if(!hospitalVo.getFile1().getOriginalFilename().equals("")) {
			File deleteFile = new File(root_path + attach_path+ oldFileName);
			//boardVo.getFile1().transferTo(deleteFile); //upload ����    ->  JVM�� ������ ����Ǵ� ��ü�� �����Ͽ� �������ش�. �������ִ� ��ü deleteFile
			System.out.println(root_path + attach_path+ oldFileName);
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
		}
	}
	
	/**
	 * fileSave ���
	 */
	public void fileSave(HospitalVo hospitalVo, HttpServletRequest request) throws Exception{
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//������ �����ϸ� ������ ����
		if(hospitalVo.getHfile() != null && !hospitalVo.getHfile().equals("")) {
			//System.out.println("save file--->" + hospitalVo.getHfile());			
			File saveFile = new File(root_path + attach_path+ hospitalVo.getHsfile());
			
			hospitalVo.getFile1().transferTo(saveFile);
		}
	}
	
	/**
	 * fileCheck ���
	 */
	public HospitalVo fileCheck(HospitalVo hospitalVo) {
		if(hospitalVo.getFile1().getOriginalFilename() != null
				&& !hospitalVo.getFile1().getOriginalFilename().contentEquals("")) {  //������ �����ϸ�
			
			//BSFILE ���� �ߺ� ó��
			UUID uuid = UUID.randomUUID();
			String hfile = hospitalVo.getFile1().getOriginalFilename();
			String hsfile = uuid + "_" + hfile;
			hospitalVo.setHfile(hfile);
			hospitalVo.setHsfile(hsfile);
		}else {
			System.out.println("���� ����");
//			hospitalVo.setHfile("");
//			hospitalVo.setHsfile("");
		}	
		
		return hospitalVo;
	}
}
