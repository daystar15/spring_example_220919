package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	public Review selectReview(int id); // BO의 메소드를 복붙하고 select로 변경하기
	// 파라미터가 한 개면 @Param("id")이 부분 없애도됨
	
	public int insertReview(Review review);
	
	public int insertReviewAsField(
			// 하나의 맵으로 구성됨(@Param) - 두 개 이상일 경우
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
	
	public int updateReviewById(
			@Param("id") int id, 
			@Param("review") String review);
	
	public void deleteReviewById(int id);
}
