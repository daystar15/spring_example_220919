package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;

	public Review getReview(int id) { // null이 들어가도 되면 Integer, id를 필수로 넘겨야함
		return reviewDAO.selectReview(id);
	}
	
	// input: Review 객체
	// output: int(insert가 성공된 행 수)
	public int addReview(Review review) {
		return reviewDAO.insertReview(review);
	}
	
	// addReviewAsField(4, "콤비네이션R", "신바다", 5.0, "역시 맛있다!")
	// point는 null허용이기 때문에 Double로 해도됨
	public int addReviewAsField(
			int storeId, String menu, String userName, Double point, String review
			) {
		return reviewDAO.insertReviewAsField(storeId, menu, userName, point, review);
		// 자동완성 꼭 다시 확인하기(정확하지 않을 수 있음)
	}
}
