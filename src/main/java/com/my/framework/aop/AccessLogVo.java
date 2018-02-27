package com.my.framework.aop;

import org.apache.ibatis.type.Alias;

import com.my.framework.mypage.MyPageVo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data @Getter @Setter @ToString
@Alias("AccessLogVo")
public class AccessLogVo {
	public AccessLogVo() {}
	
	private String signature_type_name;
	private String signature_name;
	private String acc_id;
	private String acc_ip;
	private String acc_date;

	public String getSignature_type_name() {
		return signature_type_name;
	}

	public void setSignature_type_name(String signature_type_name) {
		this.signature_type_name = signature_type_name;
	}

	public String getSignature_name() {
		return signature_name;
	}

	public void setSignature_name(String signature_name) {
		this.signature_name = signature_name;
	}

	public String getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}

	public String getAcc_ip() {
		return acc_ip;
	}

	public void setAcc_ip(String acc_ip) {
		this.acc_ip = acc_ip;
	}

	public String getAcc_date() {
		return acc_date;
	}

	public void setAcc_date(String acc_date) {
		this.acc_date = acc_date;
	}

	public AccessLogVo(String signature_type_name, String signature_name, String acc_id, String acc_ip,
			String acc_date) {
		super();
		this.signature_type_name = signature_type_name;
		this.signature_name = signature_name;
		this.acc_id = acc_id;
		this.acc_ip = acc_ip;
		this.acc_date = acc_date;
	}
}
