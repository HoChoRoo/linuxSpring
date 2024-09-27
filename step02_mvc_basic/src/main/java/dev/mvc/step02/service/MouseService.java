package dev.mvc.step02.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.mvc.step02.model.Mouse;

/*
 * Service - 어떤 특정 도메인에 속한 웹 서비스의 Service를 의미
 * 
 * 해당 클래스 내에 핵심 비즈니스 로직을 주로 작성 with POJO
 */

@Service // @Component의 스테레오 타입
public class MouseService { // MouseService도 스프링 컨테이너에 빈으로 등록

	private static List<Mouse> mice;

	static {
		Mouse mini = new Mouse(10, "미니", "하와이", "구직중");
		Mouse mickey = new Mouse(25, "미키", "런던", "맨체스터 유나이티드");
		Mouse jay = new Mouse(15, "제이", "상하이", "텐센트");
		Mouse jerry = new Mouse(20, "제리", "도쿄", "라인");
		Mouse jamie = new Mouse(40, "제이미", "대한민국", "삼성");

		Mouse[] mouseArray = { mini, mickey, jay, jerry, jamie };

		mice = new ArrayList<>(Arrays.asList(mouseArray));
	}

	public List<Mouse> findAll() {
		
		// DB에서 Mouse 목록 조회 처리 수행했다고 가정(DAO코드 작성 부분)
		return mice;
	}

	public void add(Mouse mouse) {
		mice.add(mouse);
	}
}
