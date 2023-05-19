package com.project.dao;

import java.util.ArrayList;

import com.project.vo.HospitalVo;

public class HospitalDao extends DBConn{
	
	/**
	 *  search - ����   �˻�
	 * */
	public ArrayList<HospitalVo> search(){
		ArrayList<HospitalVo> list = new ArrayList<HospitalVo>();
		String sql = " SELECT HID, HNAME, GLOC, LOC, TEL, HTIME, NTIME, HOLIDAY, ANIMAL,INTRO, IMG, HRINK  "
					+"  FROM PCP_HOSPITAL WHERE HNAME=?";
		getPreparedStatement(sql);
		
		try {
			while(rs.next()) {
				HospitalVo hospital = new HospitalVo();
				hospital.setHname(rs.getString(1));
				hospital.setGloc(rs.getString(2));
				hospital.setLoc(rs.getString(3));
				hospital.setTel(rs.getString(4));
				hospital.setHtime(rs.getString(5));
				hospital.setNtime(rs.getString(6));
				hospital.setHoliday(rs.getString(7));
				hospital.setAnimal(rs.getString(8));
				hospital.setIntro(rs.getString(9));
				hospital.setImg(rs.getString(10));
				hospital.setHrink(rs.getString(11));

				list.add(hospital);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 *  delete - ����  ����
	 * */
	public int delete(String hid) {
		int result = 0;
		String sql = "delete from mycgv_board where nid=?";
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
	 *  update - ����  ����
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
	 *  select - ���� ��ȸ
	 * */
	public ArrayList<HospitalVo> select(){
		ArrayList<HospitalVo> list = new ArrayList<HospitalVo>();
		String sql = "SELECT ROWNUM RNO,  HID, HNAME, GLOC, LOC, TEL, HTIME, NTIME, HOLIDAY, ANIMAL, INTRO, IMG, HRINK, X, Y" + 
				"	FROM (SELECT HID, HNAME, GLOC, LOC, TEL, HTIME, NTIME, HOLIDAY, ANIMAL, INTRO, IMG, HRINK, X, Y "
				+ " FROM PCP_HOSPITAL ORDER BY HID DESC);";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				HospitalVo hospitalVo = new HospitalVo();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * insert - ���� ���
	 * */
	public  int insert(HospitalVo hospitalVo) {
		int result = 0;
		
		String sql ="INSERT INTO PCP_HOSPITAL VALUES (" + 
				"  'H_'||LTRIM(TO_CHAR(SEQU_PCP_HOSPITAL_HID.NEXTVAL,'0000')),"
			  + "	?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1,hospitalVo.getHname());
			pstmt.setString(1,hospitalVo.getGloc());
			pstmt.setString(1,hospitalVo.getLoc());
			pstmt.setString(1,hospitalVo.getTel());
			pstmt.setString(1,hospitalVo.getHtime());
			pstmt.setString(1,hospitalVo.getNtime());
			pstmt.setString(1,hospitalVo.getHoliday());
			pstmt.setString(1,hospitalVo.getAnimal());
			pstmt.setString(1,hospitalVo.getIntro());
			pstmt.setString(1,hospitalVo.getImg());
			pstmt.setString(1,hospitalVo.getHrink());
			pstmt.setString(1,hospitalVo.getX());
			pstmt.setString(1,hospitalVo.getY());
			
			result = pstmt.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result; 
	}
}	
