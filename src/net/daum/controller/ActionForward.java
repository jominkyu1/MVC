package net.daum.controller;

public class ActionForward {
	private boolean isRedirect; //어떻게 이동할것인지에 대해 판단하는 분기 변수
	private String path; //매핑주소 경로를 담을 변수
	
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
