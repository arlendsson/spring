package com.my.framework.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.framework.mypage.MyPageVo;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

	private Logger log = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/home")
	public String home(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("########## " + request.getRequestURI());
		return "home/home";
	}
	
	@RequestMapping("/ajax/data")
	@ResponseBody
	public MyPageVo data(HttpServletRequest request, HttpServletResponse response, MyPageVo param) throws Exception {
		log.debug("########## " + request.getRequestURI());
		log.debug("########## param.toString(): " + param.toString());

		return param;
	}
}
