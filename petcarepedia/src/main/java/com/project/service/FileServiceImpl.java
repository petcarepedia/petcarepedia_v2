package com.project.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.project.vo.HospitalVo;

@Service("fileService")
public class FileServiceImpl {
	
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
				&& !hospitalVo.getFile1().getOriginalFilename().equals("")) {  //������ �����ϸ�
			
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
