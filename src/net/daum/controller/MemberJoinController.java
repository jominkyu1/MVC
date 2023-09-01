package net.daum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberJoinController implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward af = new ActionForward();
		af.setRedirect(false);
		af.setPath("./views/member/member_Join.jsp");
		return af;
	}
}