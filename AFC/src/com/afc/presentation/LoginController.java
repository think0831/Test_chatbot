package com.afc.presentation;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.afc.domain.Member;
import com.afc.service.LoginService;


@Controller
public class LoginController {
	@Resource
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(HttpServletRequest request) {
		HttpSession httpSession = request.getSession(true);
		Boolean isLogin = httpSession.getAttribute("isLogin") != null ? (Boolean) httpSession.getAttribute("isLogin")
				: false;

		if (isLogin) {
			return new ModelAndView(new RedirectView("/chat/chat"));
		}
		
		return new ModelAndView("/login/login");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(Member member, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(true);
		ModelAndView modelAndView;
		System.out.println(member.getId());
		System.out.println(StringUtils.isNotEmpty(member.getPassword()));
		
		if (StringUtils.isNotEmpty(member.getId()) 
				&& StringUtils.isNotEmpty(member.getPassword())) {
			Member memberInDB = this.loginService.login(member.getId());
			System.out.println(memberInDB);
			
			if(memberInDB != null && memberInDB.getPassword().equals(member.getPassword())) {
				session.setAttribute("isLogin", true);
				session.setAttribute("id", memberInDB.getId());
				
				modelAndView = new ModelAndView("/chat/chat");
				
			} else {
				modelAndView = new ModelAndView(new RedirectView("/login"));
			}
			
		} else {
			modelAndView = new ModelAndView(new RedirectView("/login"));
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session != null) {
			session.invalidate();
		}

		return new ModelAndView(new RedirectView("/login"));
	}
}
