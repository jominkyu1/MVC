package net.daum.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogoutController implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = req.getSession();
		session.invalidate(); //세션만료시킴
		
		PrintWriter out = resp.getWriter();
		out.println("<script>alert('로그아웃 되었습니다.'); location='mem_login.daum';</script>");
		return null;
	}
}