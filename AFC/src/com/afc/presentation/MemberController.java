package com.afc.presentation;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.afc.domain.Fund;
import com.afc.domain.Member;
import com.afc.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Resource
	private MemberService memberService;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addGet(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/member/add");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addPost(Member member, HttpServletRequest request) {		
		member.setMemberNumber(2);
		memberService.add(member);
		
		return new ModelAndView("/chat/chat");
	}
}
