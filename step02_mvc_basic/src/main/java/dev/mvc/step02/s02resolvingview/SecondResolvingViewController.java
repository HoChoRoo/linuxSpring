package dev.mvc.step02.s02resolvingview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// @Controller 사용해서 변경, test.jsp 파일로 렌더링될 수 있도록 작성
@Controller
public class SecondResolvingViewController{

	private static final Logger logger = LoggerFactory.getLogger(SecondResolvingViewController.class);

	@RequestMapping(value = "/s02/second-controller", method = RequestMethod.GET)
	public ModelAndView handleRequest() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("test");
		
		return mnv;
	}
	
}
