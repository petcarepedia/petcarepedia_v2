package com.project.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.project.vo.HospitalVo;
import com.project.vo.ReviewVo;

@Service("fileService")
public class FileServiceImpl {
	
	/*
	 * multiFileDelete - 리뷰 삭제시 파일 삭제
	 */
	public void multiFileDelete(HttpServletRequest request, String[] oldFileName) throws Exception{
	//파일의 삭제위치
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
	
		int count = 0;
		for(String list : oldFileName) {
			if(!list.equals("")) {
				File deleteFile = new File(root_path + attach_path+ oldFileName[count]);
				System.out.println(root_path + attach_path+ oldFileName[count]);			
				if(deleteFile.exists()) {
					deleteFile.delete();
				}
			}
			count++;
		}
	}	
	
	/*
	 * multiFileDelete - 리뷰 수정시 삭제
	 */
	public void multiFileDelete(ReviewVo reviewVo, HttpServletRequest request, String[] oldFileName) throws Exception{
	//파일의 삭제위치
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		int count = 0;
		for(CommonsMultipartFile file : reviewVo.getFiles()) {
			if(!file.getOriginalFilename().equals("")) { //새로운 파일 선택
				File deleteFile = new File(root_path + attach_path+ oldFileName[count]);
				System.out.println(root_path + attach_path+ oldFileName[count]);			
				if(deleteFile.exists()) {
					deleteFile.delete();
				}
			}
			count++;
		}
	}
	
	/*
	 * multiFileSave - 리뷰 저장
	 */
	public void multiFileSave(ReviewVo reviewVo, HttpServletRequest request) throws Exception {
		
		//파일의 저장위치
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		int count = 0;
		System.out.println(root_path + attach_path);
		for(CommonsMultipartFile file : reviewVo.getFiles()) {
			//파일이 존재하면 서버에 저장
			if(file.getOriginalFilename() != null && !file.getOriginalFilename().equals("")) {
				File saveFile = new File(root_path + attach_path+ reviewVo.getRsfiles().get(count));
				file.transferTo(saveFile);
			}
			count++;
		}
	}
	/*
	 * multiFileCheck - 파일 체크
	 */
	public ReviewVo multiFileCheck(ReviewVo reviewVo) {
		String[] nfile = {reviewVo.getRfile1(), reviewVo.getRfile2()};
		String[] nsfile = {reviewVo.getRsfile1(), reviewVo.getRsfile2()};
		int count = 0;
		for(CommonsMultipartFile file : reviewVo.getFiles()) {
			if(!file.getOriginalFilename().equals("")) {
				//파일이 있음
				UUID uuid = UUID.randomUUID();
				reviewVo.getRfiles().add(file.getOriginalFilename());
				reviewVo.getRsfiles().add(uuid+"_"+file.getOriginalFilename());
			}
			else {
				//파일이 없음
				reviewVo.getRfiles().add(nfile[count]);
				reviewVo.getRsfiles().add(nsfile[count]);
			}
			count++;
		}
		reviewVo.setRfile1(reviewVo.getRfiles().get(0));
		reviewVo.setRsfile1(reviewVo.getRsfiles().get(0));
		reviewVo.setRfile2(reviewVo.getRfiles().get(1));
		reviewVo.setRsfile2(reviewVo.getRsfiles().get(1));
		
		
		return reviewVo;
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
