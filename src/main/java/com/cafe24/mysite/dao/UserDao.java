package com.cafe24.mysite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.mysite.vo.UserVo;
import com.cafe24.mysite.vo.UserVo;

public class UserDao {
	public boolean insert(UserVo vo) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		boolean result=false;
		try {
			conn=Connector.getConnection();
			String sql="insert into user values(null,?,?,?,?,now());";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());
			int count =pstmt.executeUpdate();
			result  =(count==1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connector.allClose(conn, pstmt, rs);
		}
		return result;
	}
	public   UserVo  get (Long no) {
		return null;
	}
	
	public   UserVo  get (String email, String password) {
		 UserVo result = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			conn=Connector.getConnection();
			// 4. SQL문 실행
			String sql = "select no, name from user where email=? and password=? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			 rs = pstmt.executeQuery();
			// 5. 결과 가져오기
			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				result = new UserVo();
				result.setNo(no);
				result.setName(name);
				System.out.println(no+" "+name);
			}
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			Connector.allClose(conn, pstmt, rs);
		}
		return result;
	}
}
