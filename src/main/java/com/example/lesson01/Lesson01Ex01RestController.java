package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // @Controller + @ResponseBody
public class Lesson01Ex01RestController {

	// http://localhost:8080/lesson01/ex01/3 (주소가 겹치면 오류가 생김)
	@RequestMapping("/3")
	public String ex01_3() {
		return "@RestController 사용해서 String을 리턴한다.";
	}
	
	// http://localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> ex01_4() {
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "qqq");
		map.put("bbb", "aaaa");
		map.put("ccc", "pppp");
		return map;
	}
	
	// http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() { // 같은 패키지에 있기 때문에 자동 import됨
		Data data = new Data(); // 일반 자바 bean(bean은 객체란 의미)
		data.setId(1); // setId는 key, 1은 value
		data.setName("김남희");
		return data; // 일반 bean 객체로 json으로 변환된다
	}
	
	// http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() {
		Data data = new Data(); // 일반 자바 bean(bean은 객체란 의미)
		data.setId(1); // setId는 key, 1은 value
		data.setName("김남희");
		
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
