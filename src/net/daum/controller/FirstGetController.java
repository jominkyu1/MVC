package net.daum.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstGetController
 */
@WebServlet(urlPatterns = "/start") //매핑주소 등록
public class FirstGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** 서블릿 자바 클래스 특징)
	 *	1. 서블릿은 MVC에서 C에 해당하는 컨트롤러 역할을 한다.
	 *	2. 서블릿은 온라인상에서 누구나 다 접근가능하게 public 접근지정자로 선언한다.
	 *	3. HttpServlet 클래스를 상속받아야한다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>최초 서블릿 실행</h3>");
		out.close();
	}

}
