package com.afc.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.afc.domain.Member;
import com.afc.persistence.MemberDao;

@Service
public class LoginService {
	@Resource
	private MemberDao MemberDao;
	
	public Member login(String id) {
		return this.MemberDao.view(id);
	}
}
