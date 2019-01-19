package com.afc.presentation;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.afc.domain.FundJoin;
import com.afc.service.FundJoinService;

@Controller
@RequestMapping("/fundJoin")
public class FundJoinController {
	
	@Resource
	private FundJoinService fundJoinService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addPost(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		System.out.println(session.getAttribute("number"));
		
		FundJoin fundJoin = new FundJoin();
		
		fundJoin.setFundNumber(Integer.parseInt(request.getParameter("fundNumber")));
		fundJoin.setMemberNumber((int)session.getAttribute("number"));
		fundJoin.setJoinNumber(1);
		
		fundJoinService.add(fundJoin);
		return null;
	}
}
