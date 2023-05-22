package com.project.dao;

import java.util.ArrayList;

import com.project.vo.HospitalVo;

public class HospitalDao extends DBConn{
	
	 
	/**
	 *  search - 병원  상세  검색
	 * */
	public ArrayList<HospitalVo> search(String hid){
		ArrayList<HospitalVo> list = new ArrayList<HospitalVo>();
		HospitalVo hospital = new HospitalVo();
		String sql = " SELECT HID, HNAME, GLOC, LOC, TEL, HTIME, NTIME, HOLIDAY, ANIMAL,INTRO, IMG, HRINK  "
				+"  FROM PCP_HOSPITAL WHERE HID=? OR HNAME LIKE %?% )";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1,hospital.getHid());
			pstmt.setString(2,hospital.getHname());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				hospital.setHid(rs.getString(1));
				hospital.setHname(rs.getString(2));
				hospital.setGloc(rs.getString(3));
				hospital.setLoc(rs.getString(4));
				hospital.setTel(rs.getString(5));
				hospital.setHtime(rs.getString(6));
				hospital.setNtime(rs.getString(7));
				hospital.setHoliday(rs.getString(8));
				hospital.setAnimal(rs.getString(9));
				hospital.setIntro(rs.getString(10));
				hospital.setImg(rs.getString(11));
				hospital.setHrink(rs.getString(12));
				
				list.add(hospital);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 *  search - 병원   검색
	 * */
	public ArrayList<HospitalVo> search(){
		ArrayList<HospitalVo> list = new ArrayList<HospitalVo>();
		HospitalVo hospital = new HospitalVo();
		String sql = " SELECT HID, HNAME, GLOC, LOC, TEL, HTIME, NTIME, HOLIDAY, ANIMAL,INTRO, IMG, HRINK  "
					+"  FROM PCP_HOSPITAL WHERE HID=? OR HNAME like %?% )";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1,hospital.getHid());
			pstmt.setString(2,hospital.getHname());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				hospital.setHid(rs.getString(1));
				hospital.setHname(rs.getString(2));
				hospital.setGloc(rs.getString(3));
				hospital.setLoc(rs.getString(4));
				hospital.setTel(rs.getString(5));
				hospital.setHtime(rs.getString(6));
				hospital.setNtime(rs.getString(7));
				hospital.setHoliday(rs.getString(8));
				hospital.setAnimal(rs.getString(9));
				hospital.setIntro(rs.getString(10));
				hospital.setImg(rs.getString(11));
				hospital.setHrink(rs.getString(12));
				
				list.add(hospital);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 *  delete - 병원  삭제
	 * */
	public int delete(String hid) {
		int result = 0;
		String sql = "delete from pcp_hospital where hid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, hid);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 *  update - 병원  수정
	 * */
	public int update(HospitalVo hospitalVo) {
		int result = 0;
		
		String sql = "UPDATE PCP_HOSPITAL SET HNAME = ?, GLOC = ?, LOC=? , TEL =?, "
					+ "HTIME=?, NTIME=?, HOLIDAY=?, ANIMAL=?, INTRO=?, IMG=?, HRINK=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, hospitalVo.getHname());
			pstmt.setString(2, hospitalVo.getGloc());
			pstmt.setString(3, hospitalVo.getLoc());
			pstmt.setString(4, hospitalVo.getTel());
			pstmt.setString(5, hospitalVo.getHtime());
			pstmt.setString(6, hospitalVo.getNtime());
			pstmt.setString(7, hospitalVo.getHoliday());
			pstmt.setString(8, hospitalVo.getAnimal());
			pstmt.setString(9, hospitalVo.getIntro());
			pstmt.setString(10, hospitalVo.getImg());
			pstmt.setString(11, hospitalVo.getHrink());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 *  select - 병원 조회
	 * */
	public ArrayList<HospitalVo> select(){
		ArrayList<HospitalVo> list = new ArrayList<HospitalVo>();
		String sql = "SELECT ROWNUM RNO,  HID, HNAME, GLOC, LOC, TEL, HTIME, NTIME, HOLIDAY, ANIMAL, INTRO, IMG, HRINK" + 
				"	FROM (SELECT HID, HNAME, GLOC, LOC, TEL, HTIME, NTIME, HOLIDAY, ANIMAL, INTRO, IMG, HRINK"
				+ " FROM PCP_HOSPITAL ORDER BY HID DESC)";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				HospitalVo hospital = new HospitalVo();
				hospital.setHid(rs.getString(1));
				hospital.setHname(rs.getString(2));
				hospital.setGloc(rs.getString(3));
				hospital.setLoc(rs.getString(4));
				hospital.setTel(rs.getString(5));
				hospital.setHtime(rs.getString(6));
				hospital.setNtime(rs.getString(7));
				hospital.setHoliday(rs.getString(8));
				hospital.setAnimal(rs.getString(9));
				hospital.setIntro(rs.getString(10));
				hospital.setImg(rs.getString(11));
				hospital.setHrink(rs.getString(12));
				
				list.add(hospital);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * insert - 병원 등록
	 * */
	public  int insert(HospitalVo hospitalVo) {
		int result = 0;
		
		String sql ="INSERT INTO PCP_HOSPITAL VALUES (" + 
				"  'H_'||LTRIM(TO_CHAR(SEQU_PCP_HOSPITAL_HID.NEXTVAL,'0000')),"
			  + "	?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1,hospitalVo.getHname());
			pstmt.setString(2,hospitalVo.getGloc());
			pstmt.setString(3,hospitalVo.getLoc());
			pstmt.setString(4,hospitalVo.getTel());
			pstmt.setString(5,hospitalVo.getHtime());
			pstmt.setString(6,hospitalVo.getNtime());
			pstmt.setString(7,hospitalVo.getHoliday());
			pstmt.setString(8,hospitalVo.getAnimal());
			pstmt.setString(9,hospitalVo.getIntro());
			pstmt.setString(10,hospitalVo.getImg());
			pstmt.setString(11,hospitalVo.getHrink());
			
			result = pstmt.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result; 
	}
}	
