package net.daum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.daum.vo.TestVO;

public class TestDAOImpl { //DBCP 커넥션풀에 의해서 오라클 연결
	Connection con = null;
	PreparedStatement pt = null;
	ResultSet rs = null;
	DataSource ds = null;
	String sql = null;
	
	public TestDAOImpl() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/xe");
			//server.xml에 설정된 xe DB를 찾아서 커넥션 풀 관리 ds를 생성
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	} 
	
	public int testInsert(TestVO t) {
		int re = -1;
		
		try {
			con = ds.getConnection();
			sql="insert into tbl_test (no, title, content, regdate) values" +
					"(bno_seq25.nextval, ?, ?, sysdate)";
			pt = con.prepareStatement(sql);
			pt.setString(1, t.getTitle());
			pt.setString(2, t.getContent());
			
			re = pt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pt!=null) pt.close();
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return re;
	}
	
	public List<TestVO> getTestList(){
		List<TestVO> tlist = new ArrayList<>();
		try {
			con = ds.getConnection();
			sql = "select * from tbl_test order by no desc";
			pt=con.prepareStatement(sql);
			rs=pt.executeQuery();
			
			while(rs.next()) {
				TestVO t = new TestVO();
				t.setNo(rs.getInt("no"));
				t.setTitle(rs.getString("title"));
				t.setContent(rs.getString("content"));
				t.setRegdate(rs.getTimestamp("regdate"));
				
				tlist.add(t);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pt!=null) pt.close();
				if(con!=null) con.close();
				if(rs!=null) rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return tlist;
	}
}
