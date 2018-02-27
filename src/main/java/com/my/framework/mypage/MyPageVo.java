package com.my.framework.mypage;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data @Getter @Setter @ToString
@Alias("MyPageVo")
public class MyPageVo {
	
	public MyPageVo() {}
	
	public MyPageVo(String id) {
		super();
		this.id = id;
	}
	
	public MyPageVo(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	private String id;
	private String pw;
	private String name;

}
