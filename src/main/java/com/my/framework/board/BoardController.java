package com.my.framework.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	private Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping("/boardList")
	public String boardList(HttpServletRequest request, HttpServletResponse response
			, Model model
			) throws Exception {
		log.debug("########## " + request.getRequestURI());
		
		return "board/boardList";
	}
}
