package com.my.framework.mypage;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyPageDao {

	@Autowired
	private SqlSession sqlSession;
	
	public String selectDual(String param) throws Exception {
		return sqlSession.selectOne("mapper.MyPageMapper.selectDual", param);
	}
	
	public MyPageVo selectUser(MyPageVo param) throws Exception {
		return sqlSession.selectOne("mapper.MyPageMapper.selectUser", param);
	}
}
