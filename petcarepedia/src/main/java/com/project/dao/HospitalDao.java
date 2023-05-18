package com.project.dao;

import com.project.vo.HospitalVo;

public class HospitalDao extends DBConn{
	
	/**
	 * insert - 병원 등록
	 * */
	public  int insert(HospitalVo hospitalVo) {
		int result = 0;
		
		String sql ="INSERT INTO PCP_HOSPITAL VALUES(\r\n" + 
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
			
			/* rs = pstmt.executeUpdate(); */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result; 
	}
}	
