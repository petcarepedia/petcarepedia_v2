package com.project.dao;

import java.util.ArrayList;

import com.project.vo.HospitalVo;

public class HospitalDao extends DBConn {
	/**
	 * selectStat - 병원 별점
	 */
	public HospitalVo selectStar(String hid) {
		HospitalVo list = new HospitalVo();
		String sql = "SELECT ROUND(AVG(RSTAR),1) RSTAR FROM" + 
				" (SELECT * FROM PCP_HOSPITAL h, PCP_REVIEW R WHERE H.HID=R.HID AND H.HID=?)";
		getPreparedStatement(sql);

		try {
			pstmt.setString(1, hid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.setRstar(rs.getFloat(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	/**
	 * searchGloc - 구별 병원 검색
	 */
	public ArrayList<HospitalVo> searchGloc(String gloc) {
		ArrayList<HospitalVo> list = new ArrayList<HospitalVo>();
		String sql = "SELECT HID, HNAME, GLOC, LOC, TEL, HTIME, NTIME, HOLIDAY, ANIMAL, INTRO, IMG, HRINK,X,Y\r\n"
				+ "FROM PCP_HOSPITAL\r\n" + "where gloc=?";
		getPreparedStatement(sql);

		try {
			pstmt.setString(1, gloc);

			rs = pstmt.executeQuery();

			while (rs.next()) {
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
				hospital.setX(rs.getString(13));
				hospital.setY(rs.getString(14));

				list.add(hospital);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * search - 병원 상세 검색
	 */
	public ArrayList<HospitalVo> search(String hname) {
		ArrayList<HospitalVo> list = new ArrayList<HospitalVo>();
		String sql = "SELECT HID, HNAME, GLOC, LOC, TEL, HTIME, NTIME, HOLIDAY, ANIMAL,INTRO, IMG, HRINK, X, Y  " +
					 "	FROM PCP_HOSPITAL WHERE HNAME LIKE ?";
		getPreparedStatement(sql);

		try {
			pstmt.setString(1, "%"+ hname + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
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
				hospital.setX(rs.getString(13));
				hospital.setY(rs.getString(14));

				list.add(hospital);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}		 

	/**
	 * delete - 병원 삭제
	 */
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
	 * update - 병원 수정
	 */
	public int update(HospitalVo hospitalVo) {
		int result = 0;

		String sql = "UPDATE PCP_HOSPITAL SET HNAME=? , GLOC=?, LOC =? , TEL=?, "+
					 " HTIME=? , NTIME=? , HOLIDAY=?, ANIMAL=?, INTRO=? ,HRINK=? WHERE HID = ? ;";
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
			pstmt.setString(11, hospitalVo.getHrink());
			pstmt.setString(12, hospitalVo.getHid());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * select - 병원 하나만 조회
	 */
	public HospitalVo select(String hid) {
		HospitalVo hospitalVo = new HospitalVo();
		String sql = "SELECT  HID, HNAME, GLOC, LOC, TEL, HTIME, NTIME, HOLIDAY, ANIMAL, INTRO, IMG, HRINK,X,Y"
					+ " FROM PCP_HOSPITAL WHERE HID = ?";
		getPreparedStatement(sql);

		try {
			pstmt.setString(1, hid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				hospitalVo.setHid(rs.getString(1));
				hospitalVo.setHname(rs.getString(2));
				hospitalVo.setGloc(rs.getString(3));
				hospitalVo.setLoc(rs.getString(4));
				hospitalVo.setTel(rs.getString(5));
				hospitalVo.setHtime(rs.getString(6));
				hospitalVo.setNtime(rs.getString(7));
				hospitalVo.setHoliday(rs.getString(8));
				hospitalVo.setAnimal(rs.getString(9));
				hospitalVo.setIntro(rs.getString(10));
				hospitalVo.setImg(rs.getString(11));
				hospitalVo.setHrink(rs.getString(12));
				hospitalVo.setX(rs.getString(13));
				hospitalVo.setY(rs.getString(14));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hospitalVo;
	}// 123

	/**
	 * select - 병원 조회
	 */
	public ArrayList<HospitalVo> select() {
		ArrayList<HospitalVo> list = new ArrayList<HospitalVo>();
		String sql = "SELECT H.RNO, H.HID, H.HNAME, H.GLOC, H.LOC, H.TEL, H.HTIME, SUBSTR(H.HTIME, 0, 5) AS STARTTIME, SUBSTR(H.HTIME, 7, 6) AS ENDTIME, H.NTIME, H.HOLIDAY, H.ANIMAL, H.INTRO, H.IMG, H.HRINK, H.X, H.Y, ROUND(AVG(RSTAR),1) AS RSTAR\r\n" + 
				" FROM (SELECT ROWNUM RNO, HID, HNAME, GLOC, LOC, TEL, HTIME, SUBSTR(HTIME, 0, 5) STARTTIME, SUBSTR(HTIME, 7, 6) ENDTIME, NTIME, HOLIDAY, ANIMAL, INTRO, IMG, HRINK, X, Y\r\n" + 
				"      FROM PCP_HOSPITAL\r\n" + 
				"      ORDER BY HID DESC) H\r\n" + 
				" LEFT JOIN PCP_REVIEW R ON H.HID = R.HID\r\n" + 
				" GROUP BY H.RNO, H.HID, H.HNAME, H.GLOC, H.LOC, H.TEL, H.HTIME, SUBSTR(H.HTIME, 0, 5), SUBSTR(H.HTIME, 7, 6), H.NTIME, H.HOLIDAY, H.ANIMAL, H.INTRO, H.IMG, H.HRINK, H.X, H.Y\r\n" + 
				" ORDER BY H.HID DESC";
		getPreparedStatement(sql);

		try {
			rs = pstmt.executeQuery();

			while (rs.next()) {
				HospitalVo hospital = new HospitalVo();
				hospital.setRno(rs.getInt(1));
				hospital.setHid(rs.getString(2));
				hospital.setHname(rs.getString(3));
				hospital.setGloc(rs.getString(4));
				hospital.setLoc(rs.getString(5));
				hospital.setTel(rs.getString(6));
				hospital.setHtime(rs.getString(7));
				hospital.setStarttime(rs.getString(8));
				hospital.setEndtime(rs.getString(9));
				hospital.setNtime(rs.getString(10));
				hospital.setHoliday(rs.getString(11));
				hospital.setAnimal(rs.getString(12));
				hospital.setIntro(rs.getString(13));
				hospital.setImg(rs.getString(14));
				hospital.setHrink(rs.getString(15));
				hospital.setX(rs.getString(16));
				hospital.setY(rs.getString(17));
				hospital.setRstar(rs.getFloat(18));

				list.add(hospital);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	
	
	public HospitalVo selectTime(String hid) {
		HospitalVo hospitalVo = new HospitalVo();
		
		String sql= "SELECT HID, HNAME, SUBSTR(HTIME, 0,5 ) STARTTIME,  SUBSTR(HTIME, 7,6 ) ENDTIME" + 
				" FROM PCP_HOSPITAL WHERE HID=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, hid);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				hospitalVo.setHid(rs.getString(1));
				hospitalVo.setHname(rs.getString(2));
				hospitalVo.setStarttime(rs.getString(3));
				hospitalVo.setEndtime(rs.getString(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return hospitalVo;
		
	} // selectTime - 영업시간



	/**
	 * insert - 병원 등록
	 */
	public int insert(HospitalVo hospitalVo) {
		int result = 0;

		String sql = "INSERT INTO PCP_HOSPITAL (HID, HNAME, GLOC, LOC, TEL, HTIME, NTIME, HOLIDAY, ANIMAL, INTRO, HRINK) VALUES" + 
				" ('H_'||LTRIM(TO_CHAR(SEQU_PCP_HOSPITAL_HID.NEXTVAL,'0000')),?,?,?,?,?,?,?,?,?,?)";
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
			pstmt.setString(10, hospitalVo.getHrink());

			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}