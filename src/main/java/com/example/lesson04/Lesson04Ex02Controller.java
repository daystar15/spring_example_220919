package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.model.Student;

@Controller
@RequestMapping("/lesson04/ex02")
public class Lesson04Ex02Controller {
	
	@Autowired
	private StudentBO studentBO;
	
	// 학생 추가 화면
	// http://localhost:80/lesson04/ex02/add_student_view
	@GetMapping("/add_student_view") // 이 주소를 치면
	public String addStudentView() {
		return "lesson04/addStudent"; // 이 jsp로 넘어간다.
	}
	
	@PostMapping("/add_student")
	public String addStudent(
			@ModelAttribute Student student, // name(request param)과 필드명이 일치하는 것이 담긴다.
			Model model) { // 내가 만든 객체들이 파라미터가 된다(@생략가능, 여러개 받아올 때는 불가)
		// int는 0, 날짜 객체들은 null로 들어있다.
		// db insert
		studentBO.addStudent(student);
		
		// db select(방금 가입된 사람)
		System.out.println("student Id:" + student.getId());
		Student student1 = studentBO.getStudentById(student.getId());

		model.addAttribute("result", student1);
		model.addAttribute("subject", "학생 정보");
		
		// view 페이지 응답값
		return "lesson04/afterAddStudent";
	}

}
