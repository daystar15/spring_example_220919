package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewdao;

	public Review getReview(int id) { // null이 들어가도 되면 Integer, id를 필수로 넘겨야함
		return reviewdao.selectReview(id);
	}
}
