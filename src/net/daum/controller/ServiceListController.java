package net.daum.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daum.dao.TestDAOImpl;
import net.daum.vo.TestVO;

public class ServiceListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TestDAOImpl tdao = new TestDAOImpl();
		List<TestVO> tlist = tdao.getTestList();
		
		req.setAttribute("tlist", tlist);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./views/tList.jsp"); 
		dispatcher.forward(req, resp); //resp.sendRedirect()와는 다르게 서버->서버이동 attribute 유지
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
