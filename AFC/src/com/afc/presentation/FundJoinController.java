package com.afc.presentation;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.afc.service.FundService;

@Controller
@RequestMapping("/fundJoin")
public class FundJoinController {
	
	@Resource
	private FundService fundService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addPost(HttpServletRequest request) {
		System.out.println(request.getParameter("fundNumber"));
		
		return null;
	}
}
