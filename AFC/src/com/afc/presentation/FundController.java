package com.afc.presentation;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.afc.domain.Fund;
import com.afc.service.FundService;

@Controller
@RequestMapping("/fund")
public class FundController {
	
	@Resource
	private FundService fundService;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView viewPost(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/fund/view");
		
		Fund fund = fundService.view(Integer.parseInt(request.getParameter("number")));
		modelAndView.addObject("fund", fund);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ModelAndView listPost(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/fund/list");
		List<Fund> list = fundService.listAsType(request.getParameter("type"));
		modelAndView.addObject("fundList", list);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/myList", method = RequestMethod.GET)
	public ModelAndView MyListPost(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		ModelAndView modelAndView = new ModelAndView("/fund/list");
		List<Fund> list = fundService.listAsMemberNumber((int)session.getAttribute("number"));
		modelAndView.addObject("fundList", list);
		
		return modelAndView;
	}
}
