package dev.mvc.step02.s01processrequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component(value = "/s01/first-controller") // FirstController 클래스가 스프링 컨테이너에 하나의 빈으로 등록되도록 적용
// value - localhost:8080/step02/{하위 URI 패스}
// localhost:8080/step02/s01/first-controller 경로에서 테스트
public class FirstController implements Controller {

	@Override
	// 요청에 대한 처리를 수행하는 핸들러 메서드
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("-- /s01/first-controller handleRequest() called");
		
		return null;
	}

}
