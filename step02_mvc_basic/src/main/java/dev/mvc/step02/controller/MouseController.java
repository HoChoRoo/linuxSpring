package dev.mvc.step02.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.step02.model.Mouse;
import dev.mvc.step02.service.MouseService;

// mouse-api/*~로 요청이 왔을 때 처리할 핸들러
@Controller
@RequestMapping("/mouse-api/mice")
public class MouseController {

	private final MouseService mouseService;

	// @Autowired
	public MouseController(MouseService mouseService) {
		super();
		System.out.println("MouseController(MouseService service) called");
		this.mouseService = mouseService;
	}

	// GET: localhost:8080/step02/mouse-api/mice
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMice() {
		// 1. 적절한 MouseList를 가져오는 처리
		// -> MouseService를 통해 메서드를 호출(Controller가 Service에 의존)
		List<Mouse> mice = mouseService.findAll();
		
		// ModelAndView 객체 생성
		ModelAndView mnv = new ModelAndView();
		
		// 2. mice라는 Model 데이터를 mouseList.jsp에서 사용할 수 있도록 전달 - ModelAndView 활용
		// In Servlet, 
		// request.setAttribute("mouseList", mice);
		
		// In Spring MVC,
		mnv.addObject("mice", mice); // key값으로 mice, 실제 value에도 mice 리스트
		
		// 3. mouseList.jsp에 대한 파일명 전달하는 처리 - ModelAndView 활용
		mnv.setViewName("mouseList"); // 파일명만 입력, 나머지는 ViewResolver가 처리
		
		return mnv; // Model 데이터와 View 파일명이 작성된 ModelAndView 객체를 DispatcherServlet에게 반환
	}

	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public ModelAndView getMouseRegisterForm() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("mouseRegisterForm"); // forward
		return mnv;
	}
	
	@RequestMapping(path ="/register", method = RequestMethod.POST)
	public ModelAndView addMouse(HttpServletRequest request) {
		
		ModelAndView mnv = new ModelAndView();
		
		// DB 등록 처리
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		
		Mouse newMouse = new Mouse(name, country, address);
		mouseService.add(newMouse);
		
		mnv.setViewName("redirect:/mouse-api/mice"); // redirect
		
		return mnv;
	}
}







