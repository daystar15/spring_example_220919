package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController
public class Lesson03Ex01RestController {

	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost:80/lesson03/ex01?id=2
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			@RequestParam("id") int id // 필수 파라미터
			//@RequestParam(value="id") int id // null이 들어올 수 없는 필수파라미터
			// 아래 코드들은 value가 필수로 들어가야함
			//@RequestParam(value="id", required=true) int id // 필수 파라미터(?뒤를 제거했을 때 오류가 뜸)라는 설정임
			//@RequestParam(value="id", required=false) Integer id // 비필수 파라미터
			//@RequestParam(value="id", defaultValue="1") int id // 비필수 파라미터, 디폴트값 1(파라미터 없을 
		) { 
		
//		if (id == null) {
//			return null;
//		} else {
			return reviewBO.getReview(id);
//		}
	}
}
