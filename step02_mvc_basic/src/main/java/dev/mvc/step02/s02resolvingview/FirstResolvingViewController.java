package dev.mvc.step02.s02resolvingview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// 초기 Controller 인터페이스 기반 요청 처리 방식(FirstController와 같은 코드)
@Component(value = "/s02/first-controller")
public class FirstResolvingViewController implements Controller {

	private static final Logger logger = LoggerFactory.getLogger(FirstResolvingViewController.class);
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("-- /s02/first-controller handlerRequest() called");
		
		// ModelAndView 객체에 적절한 View 파일명과 화면에 렌더링할 Model 데이터만 바인딩해준 후 반환하면 나머지는 DispatcherServlet이 처리
		
		// ModelAndView 객체 생성
		ModelAndView mnv = new ModelAndView();
		
		// 적절한 View 파일명을 view 필드에 바인딩
		mnv.setViewName("home"); // /WEB-INF/views/"home".jsp에서 파일명(home)만 지정
		
		return mnv;
	}

}
