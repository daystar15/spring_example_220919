package com.example.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.model.UsedGoods;

@Repository
public interface UsedGoodsDAO {

	// input:X (서비스(BO)가 아무것도 주지않음)
	// output:List<UsedGoods>
	// 인터페이스는 구현체가 없는 메소드
	public List<UsedGoods> selectUsedGoodsList();
	// DB에 가까워지기 때문에 CRUD문법처럼 비슷하게 만든다.
}
