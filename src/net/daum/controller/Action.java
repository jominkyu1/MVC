package net.daum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface Action {
	public abstract ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public abstract는 생략가능함.
}
