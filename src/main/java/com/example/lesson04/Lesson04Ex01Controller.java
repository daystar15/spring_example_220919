package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;

@Controller // view페이지가 있기 때문에 ResponseBody가 data로 들어와야함
@RequestMapping("/lesson04/ex01")
public class Lesson04Ex01Controller {
	
	@Autowired // 여러 개의 BO를 불러올 경우 각 BO마다 @Autowired를 붙여줘야한다. 
	private UserBO userBO;

	// 회원가입 화면
	// http://localhost:80/lesson04/ex01/add_user_view
	@RequestMapping(path="/add_user_view", method=RequestMethod.GET) // path= 생략가능
	public String addUserView() {
		// /WEB-INF/jsp/(lesson04/addUser).jsp
		return "lesson04/addUser";
	}
	
	@PostMapping("/add_user") // 무슨 메서드인지 알고 써야한다
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="introduce", required=false) String introduce) {
		
		// DB insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		return "lesson04/afterAddUser";  // 결과 jsp
	}
	
	// http://localhost:80/lesson04/ex01/get_last_user_view
	@GetMapping("/get_last_user_view")
	public String getLastUserView() {
		// DB select
		
		
		return "lesson04/getLastUser";
	}
	
}
