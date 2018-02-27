package com.my.framework.aop;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccessLogWriter {

	@Autowired
	private SqlSession sqlSession;

	public int insertAccessLog(AccessLogVo param) throws Exception {
		return sqlSession.insert("AccessLogMapper.insertAccessLog", param);
	}
}
