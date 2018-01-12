package com.my.framework.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPageService {

	@Autowired
	private MyPageDao dao;
	
	public String selectDual(String param) throws Exception {
		return dao.selectDual(param);
	}
	
	public MyPageVo selectUser(MyPageVo param) throws Exception {
		return dao.selectUser(param);
	}
}
