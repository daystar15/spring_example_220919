package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.model.UsedGoods;

@RestController
public class Lesson02Ex01RestController {
	
	@Autowired
	private UsedGoodsBO usedGoodsBO; // 스프링 빈을 DI(주입) 받음, BO한테서 받음
	
	@RequestMapping("/lesson02/ex01") // 리퀘스트 발생
	public List<UsedGoods> ex01() { // 어제만든 Data, Board클래스 같은 것, DB는 UsedGoods가 됨
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
		return usedGoodsList; // JSON
	} // 주문받음
}
