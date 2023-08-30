package net.daum.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/service_write")
public class ServiceWriterController extends HttpServlet{
	/*	get or post에 상관없이 service() 메서드가 호출됨
	 * 
	 * */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher fw = req.getRequestDispatcher("./views/sw.jsp");
		fw.forward(req, resp);
		// RequestDispatcher 서블릿 forward는 기존 URL패턴을 유지한상태로 view만 반환
	}
}
