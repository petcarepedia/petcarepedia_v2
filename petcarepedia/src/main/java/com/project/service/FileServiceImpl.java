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
	 * multiFileDelete - ���� ������ ���� ����
	 */
	public void multiFileDelete(HttpServletRequest request, String[] oldFileName) throws Exception{
	//������ ������ġ
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
	 * multiFileDelete - ���� ������ ����
	 */
	public void multiFileDelete(ReviewVo reviewVo, HttpServletRequest request, String[] oldFileName) throws Exception{
	//������ ������ġ
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		int count = 0;
		for(CommonsMultipartFile file : reviewVo.getFiles()) {
			if(!file.getOriginalFilename().equals("")) { //���ο� ���� ����
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
	 * multiFileSave - ���� ����
	 */
	public void multiFileSave(ReviewVo reviewVo, HttpServletRequest request) throws Exception {
		
		//������ ������ġ
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		int count = 0;
		System.out.println(root_path + attach_path);
		for(CommonsMultipartFile file : reviewVo.getFiles()) {
			//������ �����ϸ� ������ ����
			if(file.getOriginalFilename() != null && !file.getOriginalFilename().equals("")) {
				File saveFile = new File(root_path + attach_path+ reviewVo.getRsfiles().get(count));
				file.transferTo(saveFile);
			}
			count++;
		}
	}
	/*
	 * multiFileCheck - ���� üũ
	 */
	public ReviewVo multiFileCheck(ReviewVo reviewVo) {
		String[] nfile = {reviewVo.getRfile1(), reviewVo.getRfile2()};
		String[] nsfile = {reviewVo.getRsfile1(), reviewVo.getRsfile2()};
		int count = 0;
		for(CommonsMultipartFile file : reviewVo.getFiles()) {
			if(!file.getOriginalFilename().equals("")) {
				//������ ����
				UUID uuid = UUID.randomUUID();
				reviewVo.getRfiles().add(file.getOriginalFilename());
				reviewVo.getRsfiles().add(uuid+"_"+file.getOriginalFilename());
			}
			else {
				//������ ����
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
