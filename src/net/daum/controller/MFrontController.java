package net.daum.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MFrontController extends HttpServlet{
	
	//	service -> get post 모두
	 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestUri = req.getRequestURI(); // /mvc/*.daum을 구함
			System.out.println("requestUri:: " + requestUri);
		String contextPath = req.getContextPath(); // Mvc 컨텍스트 패스 경로
			System.out.println("contextPath:: " + contextPath);
		String command = requestUri.substring(contextPath.length());
			System.out.println("requestUri.substring(contextPath.length()):: " + command);
			System.out.println("======================================");
			
		ActionForward forward=null;
		Action action=null;
		
		Properties prop = new Properties(); // 키, 밸류 쌍으로 저장하는 사전적인 자료구조인 컬렉션클래스
		
		/* 
		 * getRealPath() 메서드는 톰캣WAS서버에 의해서 변경된 실제 프로젝트 하위의 WEB-INF/classes/daum.properties 파일을 읽어들임.
		 * ------------------------------------------------------------------------------------------------------------------------------------------
		 * C:\MKWork\WebWorkspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Mvc\WEB-INF\classes
		*/
		FileInputStream fis = new FileInputStream(req.getRealPath("/WEB-INF/classes/daum.properties"));
		
		prop.load(fis);
		fis.close();
		
		String value = prop.getProperty(command); //키에대한 값을 구함
		// 값으로 execute|net.daum.controller.실제컨트롤러클래스명
		
		if(value.substring(0, 7).equals("execute")) { // 0이상 7미만 문자를 구해서 그것이 execute와 같다면
			try {
				StringTokenizer st = new StringTokenizer(value, "|"); // |를 기준으로 문자 분리
				String url_01 = st.nextToken(); //첫번째 분리된(파싱된) 문자 execute를 구함
				String url_02 = st.nextToken(); //두번째 파싱된 문자 net.daum.controller.클래스명을 구함
				
				Class url = Class.forName(url_02); // url_02 클래스 로드
				
				action = (Action) url.newInstance();
				forward = action.execute(req, resp);
				
				if(forward != null) {
					if(forward.isRedirect() == true) {
						resp.sendRedirect(forward.getPath());
							//레코드 저장, 수정, 삭제후에 새로운 매핑주소로 이동할때 사용된다.
							//이런경우는 req.setAttribute(키, 밸류)를 유지하지못함. 기존매핑주소를 잃어버리기때문
							//session.setAttribute(key, value)는 유지함
					} else {
						RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
						dispatcher.forward(req, resp);
							//request, session에 의해 저장된 key, value를 유지함
					}
				}
				
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(InstantiationException e) { //추상클래스나 인터페이스가 인스턴스화를 하고자할때
				e.printStackTrace();
			}catch(IllegalAccessException e) { //클래스 접근을 못할때
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}