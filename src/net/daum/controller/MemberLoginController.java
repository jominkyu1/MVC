package net.daum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLoginController implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./views/member/member_Login.jsp");
			
			return forward;
	}
}