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
	 * file delete - 프로필사진 수정할 때 기존 사진 삭제기능
	 */
	public void mfileDelete(MemberVo membmerVo, HttpServletRequest request, String oldFileName)
																				throws Exception{
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//파일이 존재하면 서버에 저장
		if(!membmerVo.getFile1().getOriginalFilename().equals("")) {
			File deleteFile = new File(root_path + attach_path+ oldFileName);
			//boardVo.getFile1().transferTo(deleteFile); //upload 폴더    ->  JVM과 파일이 연결되는 객체를 생성하여 연결해준다. 연결해주는 객체 deleteFile
			System.out.println(root_path + attach_path+ oldFileName);
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
		}
	}
	
	/*
	 * fileSave기능 - 회원프로필사진 저장기능
	 */
	
	public void mfileSave(MemberVo memberVo, HttpServletRequest request) throws Exception{
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//파일이 존재하면 서버에 저장
		if(memberVo.getFile1().getOriginalFilename() != null && !memberVo.getFile1().getOriginalFilename().equals("")) {
			//System.out.println("save file--->" + hospitalVo.getHfile());			
			File saveFile = new File(root_path + attach_path + memberVo.getMsfile());
			
			memberVo.getFile1().transferTo(saveFile);
		}
	}
	
	/*
	 * fileCheck - 회원 프로필 사진 체크
	 */
	public MemberVo mfileCheck(MemberVo memberVo) {
		if(memberVo.getFile1().getOriginalFilename() != null
				&& !memberVo.getFile1().getOriginalFilename().contentEquals("")) {  //파일이 존재하면
			
			//BSFILE 파일 중복 처리
			UUID uuid = UUID.randomUUID();
			String mfile = memberVo.getFile1().getOriginalFilename();
			String msfile = uuid + "_" + mfile;
			memberVo.setMfile(mfile);
			memberVo.setMsfile(msfile);
		}else {
			System.out.println("파일 없음");
//			hospitalVo.setHfile("");
//			hospitalVo.setHsfile("");
		}	
		
		return memberVo;
	}
	
	
	/**
	 * fileDelete- 파일 삭제 기능
	 */
	public void fileDelete(HttpServletRequest request, String oldFileName)
														throws Exception{
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//파일이 존재하면 서버에 저장
		if(oldFileName != null && !oldFileName.equals("")) {
			File deleteFile = new File(root_path + attach_path+ oldFileName);
			
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
		}
	}
	
	/**
	 * fileDelete-  수정할 때 기존 파일 삭제 기능
	 */
	public void fileDelete2(HospitalVo hospitalVo, HttpServletRequest request, String oldFileName)
																				throws Exception{
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//파일이 존재하면 서버에 저장
		if(!hospitalVo.getFile1().getOriginalFilename().equals("")) {
			File deleteFile = new File(root_path + attach_path+ oldFileName);
			//boardVo.getFile1().transferTo(deleteFile); //upload 폴더    ->  JVM과 파일이 연결되는 객체를 생성하여 연결해준다. 연결해주는 객체 deleteFile
			System.out.println(root_path + attach_path+ oldFileName);
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
		}
	}
	
	/**
	 * fileSave 기능
	 */
	public void fileSave(HospitalVo hospitalVo, HttpServletRequest request) throws Exception{
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//파일이 존재하면 서버에 저장
		if(hospitalVo.getHfile() != null && !hospitalVo.getHfile().equals("")) {
			//System.out.println("save file--->" + hospitalVo.getHfile());			
			File saveFile = new File(root_path + attach_path+ hospitalVo.getHsfile());
			
			hospitalVo.getFile1().transferTo(saveFile);
		}
	}
	
	/**
	 * fileCheck 기능
	 */
	public HospitalVo fileCheck(HospitalVo hospitalVo) {
		if(hospitalVo.getFile1().getOriginalFilename() != null
				&& !hospitalVo.getFile1().getOriginalFilename().contentEquals("")) {  //파일이 존재하면
			
			//BSFILE 파일 중복 처리
			UUID uuid = UUID.randomUUID();
			String hfile = hospitalVo.getFile1().getOriginalFilename();
			String hsfile = uuid + "_" + hfile;
			hospitalVo.setHfile(hfile);
			hospitalVo.setHsfile(hsfile);
		}else {
			System.out.println("파일 없음");
//			hospitalVo.setHfile("");
//			hospitalVo.setHsfile("");
		}	
		
		return hospitalVo;
	}
}
