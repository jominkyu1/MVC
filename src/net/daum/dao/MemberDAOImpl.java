package net.daum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import net.daum.vo.MemberDTO;

public class MemberDAOImpl { //DBCP 커넥션풀에 의한 오라클 연결 클래스
	
	Connection con=null;
	PreparedStatement pt=null;
	ResultSet rs=null;
	DataSource ds=null; //Connection pool 관리 데이터소스
	String sql=null;
	
	public MemberDAOImpl() {
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/xe");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//아이디 중복검색
	public MemberDTO idCheck(String id) {
		MemberDTO m=null;
		try {
			sql="select * from tbl_memberT where mem_id=?";
			pt = initSql(sql);
			pt.setString(1, id);
			rs=pt.executeQuery();
			
			if(rs.next()) {
				m=new MemberDTO();
				m.setMem_id(rs.getString("mem_id"));
				m.setMem_pwd(rs.getString("mem_pwd"));
				m.setMem_name(rs.getString("mem_name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conClose();
		}
		
		return m;
	}

	//회원저장
	public int insertMember(MemberDTO m) {
		int re = -1;
		try {
			sql="insert into tbl_memberT values(?, ?, ?, ?, ?, sysdate)";
			pt = initSql(sql);	
			pt.setString(1, m.getMem_id());
			pt.setString(2, m.getMem_pwd());
			pt.setString(3, m.getMem_name());
			pt.setString(4, m.getMem_phone());
			pt.setString(5, m.getMem_email());
			
			re = pt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conClose();
		}
		
		return re;
	}
		
	private PreparedStatement initSql(String sql) throws SQLException{
		con = ds.getConnection();
		return con.prepareStatement(sql);
	}
	
	private void conClose() {
		try {
			if(rs!=null) rs.close();
			if(pt!=null) pt.close();
			if(con!=null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}