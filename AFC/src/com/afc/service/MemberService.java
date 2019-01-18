package com.afc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.afc.domain.Member;
import com.afc.persistence.MemberDao;

@Service
public class MemberService {
	@Resource
	private MemberDao MemberDao;
	
	@Transactional
	public void add(Member member) {
		this.MemberDao.add(member);
	}
}
