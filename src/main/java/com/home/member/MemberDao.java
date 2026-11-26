package com.home.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {
	
	// 드라이버
	final String DRIVER = "com.mysql.cj.jdbc.Driver";
	// URL
	final String URL = "jdbc:mysql://127.0.0.1/db_vaccin";
	// 계정 & 비밀번호
	final String USERNAME = "root";
	final String PASSWORD = "1234";

	public boolean isMember(String admin_id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			// 1. 드라이버 로드 in 메모리
			Class.forName(DRIVER);
			// 2. 다리 연결 : 커넥션
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// 3. 작업지시서 작성 : SQL문
			String sql = "select "
					+ 	"count(*) cnt "
					+ "from "
					+ 	"tbl_admin "
					+ "where "
					+ 	"admin_id = ?";
			// 4. 일꾼을 구합니다.
			pstmt = conn.prepareStatement(sql);
			// 5. 데이터 주입
			pstmt.setString(1, admin_id);
			// 6. 작업 지시
			rs = pstmt.executeQuery();
			// 7. 데이터 추출
			while (rs.next()) {
				result = rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			// 8. 외부 자원 해제
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return result > 0 ? true : false;
	
	}

}
