package com.example.lesson03.dao;

import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	public Review selectReview(int id); // BO의 메소드를 복붙하고 select로 변경하기
	// 파라미터가 한 개면 @Param("id")이 부분 없애도됨
}
