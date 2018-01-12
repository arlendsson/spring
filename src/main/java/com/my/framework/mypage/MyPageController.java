package com.my.framework.mypage;

import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/mypage")
public class MyPageController {
	
	private Logger log = LoggerFactory.getLogger(MyPageController.class);
	
	@Resource(name = "configuration")
	private Properties configuration;
	
	@Autowired
	private MyPageService service;

	public boolean validationHasErrors(BindingResult bindingResult) throws Exception {
		//validation
		if(bindingResult.hasErrors()) {
			for (Object object : bindingResult.getAllErrors()) {
			    if(object instanceof FieldError) {
			        FieldError fieldError = (FieldError) object;
			        log.warn("########## fieldError : " + fieldError.toString());
			    }

			    if(object instanceof ObjectError) {
			        ObjectError objectError = (ObjectError) object;
			        log.warn("########## objectError : " + objectError.toString());
			    }
			}
			return true;
		} else {
			return false;
		}
	}
	
	@RequestMapping("/myPage")
	public String myPage(HttpServletRequest request, HttpServletResponse response
			, Model model
			, @Valid MyPageVo param, BindingResult bindingResult
			) throws Exception {
		log.debug("########## " + request.getRequestURI());
		
		log.debug(service.selectDual("지금은 "));
		
		MyPageVo result = service.selectUser(new MyPageVo("test"));
		
		log.debug("########## name : " + result.getName());
		
		return "mypage/myPage";
	}
	
	@RequestMapping("/ajax/data")
	@ResponseBody
	public MyPageVo data(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("########## " + request.getRequestURI());
		
		return new MyPageVo("hello");
	}
	
}
