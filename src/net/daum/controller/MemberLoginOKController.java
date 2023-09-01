package net.daum.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.daum.dao.MemberDAOImpl;
import net.daum.vo.MemberDTO;

public class MemberLoginOKController implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		req.setCharacterEncoding("UTF-8");
		String login_id = req.getParameter("login_id");
		String login_pwd = req.getParameter("login_pwd");
		
		MemberDAOImpl mdao = new MemberDAOImpl();
		MemberDTO checked_id = mdao.idCheck(login_id);
		
		if(checked_id != null ) {
			String pwd = checked_id.getMem_pwd();
				if(pwd.equals(login_pwd)) {
					out.println("LOGIN SUCCESS");
					
					HttpSession session = req.getSession();
					
					session.setAttribute("id", login_id);
					session.setAttribute("name", checked_id.getMem_name());
					
					ActionForward af = new ActionForward();
					
					af.setRedirect(true);
					af.setPath("mem_login.daum");
					
					return af;
				} else {
					//NO PWD MATCHED
					out.println("<script>");
					out.println("alert('비밀번호를 확인해주세요.')");
					out.println("history.back();");
					out.println("</script>");
				}
		} else {
			out.println("<script>");
			out.println("alert('없는 아이디 입니다.')");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return null;
	}
}