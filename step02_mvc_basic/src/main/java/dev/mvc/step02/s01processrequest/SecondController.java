package dev.mvc.step02.s01processrequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Component
@Controller // 본질적으로는 @Component처럼 빈으로 등록하는 역할 + 요청 처리를 수행할 핸들러
public class SecondController {
	
	private static final Logger logger = LoggerFactory.getLogger(SecondController.class);

	// 메서드를 보다 자유롭게 작성 가능

	@RequestMapping(value = "/s01/second-controller", method = RequestMethod.GET) 	// 메서드 레벨에서 경로를 매핑
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("-- /s01/second-controller handleRequest() called");
		
	}

}
