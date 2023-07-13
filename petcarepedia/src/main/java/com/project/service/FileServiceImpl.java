package com.project.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.project.vo.HospitalVo;
import com.project.vo.MemberVo;

import com.project.vo.ReviewVo;


@Service("fileService")
public class FileServiceImpl {
	////////////////////////////Review///////////////////////////////////////
	

	/*
	 * multiFileDelete - 由щ럭 �궘�젣�떆 �뙆�씪 �궘�젣
	 */
	public void multiFileDelete(HttpServletRequest request, String[] oldFileName) throws Exception{
	//�뙆�씪�쓽 �궘�젣�쐞移�
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
	 * multiFileDelete - 由щ럭 �닔�젙�떆 �궘�젣
	 */
	public void multiFileDelete(ReviewVo reviewVo, HttpServletRequest request, String[] oldFileName) throws Exception{
	//�뙆�씪�쓽 �궘�젣�쐞移�
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		int count = 0;
		for(CommonsMultipartFile file : reviewVo.getFiles()) {
			if(!file.getOriginalFilename().equals("")) { //�깉濡쒖슫 �뙆�씪 �꽑�깮
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
	 * multiFileSave - 由щ럭 ���옣
	 */
	public void multiFileSave(ReviewVo reviewVo, HttpServletRequest request) throws Exception {
		
		//�뙆�씪�쓽 ���옣�쐞移�
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		int count = 0;
		System.out.println(root_path + attach_path);
		for(CommonsMultipartFile file : reviewVo.getFiles()) {
			//�뙆�씪�씠 議댁옱�븯硫� �꽌踰꾩뿉 ���옣
			if(file.getOriginalFilename() != null && !file.getOriginalFilename().equals("")) {
				File saveFile = new File(root_path + attach_path+ reviewVo.getRsfiles().get(count));
				file.transferTo(saveFile);
			}
			count++;
		}
	}
	/*
	 * multiFileCheck - �뙆�씪 泥댄겕
	 */
	public ReviewVo multiFileCheck(ReviewVo reviewVo) {
		String[] nfile = {reviewVo.getRfile1(), reviewVo.getRfile2()};
		String[] nsfile = {reviewVo.getRsfile1(), reviewVo.getRsfile2()};
		int count = 0;
		for(CommonsMultipartFile file : reviewVo.getFiles()) {
			if(!file.getOriginalFilename().equals("")) {
				//�뙆�씪�씠 �엳�쓬
				UUID uuid = UUID.randomUUID();
				reviewVo.getRfiles().add(file.getOriginalFilename());
				reviewVo.getRsfiles().add(uuid+"_"+file.getOriginalFilename());
			}
			else {
				//�뙆�씪�씠 �뾾�쓬
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

	
////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
///////////////////////////////////Hospital/////////////////////////////////////////////////////	

	/**
	 * fileDelete- �뙆�씪 �궘�젣 湲곕뒫
	 */
	public void fileDelete(HttpServletRequest request, String oldFileName)
														throws Exception{
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//�뙆�씪�씠 議댁옱�븯硫� �꽌踰꾩뿉 ���옣
		if(oldFileName != null && !oldFileName.equals("")) {
			File deleteFile = new File(root_path + attach_path+ oldFileName);
			
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
		}
	}
	
	/**
	 * fileDelete-  �닔�젙�븷 �븣 湲곗〈 �뙆�씪 �궘�젣 湲곕뒫
	 */
	public void fileDelete2(HospitalVo hospitalVo, HttpServletRequest request, String oldFileName)
																				throws Exception{
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//�뙆�씪�씠 議댁옱�븯硫� �꽌踰꾩뿉 ���옣
		if(!hospitalVo.getFile1().getOriginalFilename().equals("")) {
			File deleteFile = new File(root_path + attach_path+ oldFileName);
			//boardVo.getFile1().transferTo(deleteFile); //upload �뤃�뜑    ->  JVM怨� �뙆�씪�씠 �뿰寃곕릺�뒗 媛앹껜瑜� �깮�꽦�븯�뿬 �뿰寃고빐以��떎. �뿰寃고빐二쇰뒗 媛앹껜 deleteFile
			System.out.println(root_path + attach_path+ oldFileName);
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
		}
	}
	
	/**
	 * fileSave 湲곕뒫
	 */
	public void fileSave(HospitalVo hospitalVo, HttpServletRequest request) throws Exception{
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//�뙆�씪�씠 議댁옱�븯硫� �꽌踰꾩뿉 ���옣
		if(hospitalVo.getHfile() != null && !hospitalVo.getHfile().equals("")) {
			//System.out.println("save file--->" + hospitalVo.getHfile());			
			File saveFile = new File(root_path + attach_path+ hospitalVo.getHsfile());
			
			hospitalVo.getFile1().transferTo(saveFile);
		}
	}
	
	/**
	 * fileCheck 湲곕뒫
	 */
	public HospitalVo fileCheck(HospitalVo hospitalVo) {
		if(hospitalVo.getFile1().getOriginalFilename() != null
				&& !hospitalVo.getFile1().getOriginalFilename().contentEquals("")) {  //�뙆�씪�씠 議댁옱�븯硫�
			
			//BSFILE �뙆�씪 以묐났 泥섎━
			UUID uuid = UUID.randomUUID();
			String hfile = hospitalVo.getFile1().getOriginalFilename();
			String hsfile = uuid + "_" + hfile;
			hospitalVo.setHfile(hfile);
			hospitalVo.setHsfile(hsfile);
		}else {
			System.out.println("�뙆�씪 �뾾�쓬");
//			hospitalVo.setHfile("");
//			hospitalVo.setHsfile("");
		}	
		
		return hospitalVo;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
//////////////////////////////////////////////Mypage/////////////////////////////////////////////////////////////////////////
	
	/*
	* file delete - �봽濡쒗븘�궗吏� �닔�젙�븷 �븣 湲곗〈 �궗吏� �궘�젣湲곕뒫
	*/
	
	public void mfileDelete(MemberVo membmerVo, HttpServletRequest request, String oldFileName) throws Exception{
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";

		//�뙆�씪�씠 議댁옱�븯硫� �꽌踰꾩뿉 ���옣
		if(!membmerVo.getFile1().getOriginalFilename().equals("")) {
			File deleteFile = new File(root_path + attach_path+ oldFileName);
			//boardVo.getFile1().transferTo(deleteFile); //upload �뤃�뜑    ->  JVM怨� �뙆�씪�씠 �뿰寃곕릺�뒗 媛앹껜瑜� �깮�꽦�븯�뿬 �뿰寃고빐以��떎. �뿰寃고빐二쇰뒗 媛앹껜 deleteFile
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
		}
	}
	
	
	/*
	* fileSave湲곕뒫 - �쉶�썝�봽濡쒗븘�궗吏� ���옣湲곕뒫
	*/
	
	public void mfileSave(MemberVo memberVo, HttpServletRequest request) throws Exception{

		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		//�뙆�씪�씠 議댁옱�븯硫� �꽌踰꾩뿉 ���옣
		if(memberVo.getMfile() != null && !memberVo.getMfile().equals("")) {
			//System.out.println("save file--->" + hospitalVo.getHfile());			
			File saveFile = new File(root_path + attach_path+ memberVo.getMsfile());

			memberVo.getFile1().transferTo(saveFile);
		}
	}
	
	
	/*
	 * fileCheck - �쉶�썝 �봽濡쒗븘 �궗吏� 泥댄겕
	 */
	
	public MemberVo mfileCheck(MemberVo memberVo) {
		if(memberVo.getFile1().getOriginalFilename() != null
				&& !memberVo.getFile1().getOriginalFilename().contentEquals("")) {  //�뙆�씪�씠 議댁옱�븯硫�

			//BSFILE �뙆�씪 以묐났 泥섎━
			UUID uuid = UUID.randomUUID();
			String mfile = memberVo.getFile1().getOriginalFilename();
			String msfile = uuid + "_" + mfile;
			memberVo.setMfile(mfile);
			memberVo.setMsfile(msfile);
		}else {
			System.out.println("파일 없음");
		}	

		return memberVo;
	}
	
}
