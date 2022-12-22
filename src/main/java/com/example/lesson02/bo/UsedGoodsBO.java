package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.dao.UsedGoodsDAO;
import com.example.lesson02.model.UsedGoods;

@Service
public class UsedGoodsBO {
	
	@Autowired // spring bean을 주입 받음(Dependency Injection)
	private UsedGoodsDAO usedGoodsDAO;
	
	// 주방
	// input:X (컨트롤러가 아무것도 주지않음)
	// output:List<UsedGoods>
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsDAO.selectUsedGoodsList(); // DAO에 있는걸 받음
	}
}
