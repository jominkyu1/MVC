package net.daum.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daum.dao.TestDAOImpl;
import net.daum.vo.TestVO;

@WebServlet("/service_ok")
public class ServiceOkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8"); //받아온객체 UTF-8 인코딩
		
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		out.println("글제목: <strong>" + title + "</strong><br>");
		out.println("글내용: " + content + "<hr>");
		out.println("<a href='service_write'> 입력 </a>");
		out.println("<a href='service_List'> 목록으로 </a>");
		
		TestVO t = new TestVO();
		t.setTitle(title); t.setContent(content);
		
		TestDAOImpl tdao = new TestDAOImpl();
		int re=tdao.testInsert(t);
		if(re==1) {
			out.println("<script>alert('저장성공'); </script>");
		}
		out.close();
	}
}