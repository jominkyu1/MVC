package net.daum.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daum.dao.MemberDAOImpl;
import net.daum.vo.MemberDTO;

public class MemberJoinOKController implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		ActionForward af = new ActionForward();
		MemberDAOImpl mdao = new MemberDAOImpl();
		
		String mem_id = req.getParameter("mem_id");
		MemberDTO db_id = mdao.idCheck(mem_id);
		
		if(db_id != null) { 
			out.println("<script>");
			out.println("alert('중복 아이디입니다.')");
			out.println("history.back();");
			out.println("</script>");
		} else {
			String mem_pwd=req.getParameter("mem_pwd");
			String mem_name=req.getParameter("mem_name");
			String mem_phone=req.getParameter("mem_phone");
			String mem_email=req.getParameter("mem_email");
			
			MemberDTO m = new MemberDTO();
			m.setMem_id(mem_id); m.setMem_name(mem_name); m.setMem_phone(mem_phone);
			m.setMem_email(mem_email); m.setMem_pwd(mem_pwd);
			
			int re = mdao.insertMember(m);
			if(re==1) {
				out.println("<script>alert('회원가입 완료'); "
							+ "location='mem_login.daum'</script>");
			}
		}
		return null;
	}

}
