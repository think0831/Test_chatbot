package com.afc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.afc.domain.FundJoin;
import com.afc.persistence.FundDao;
import com.afc.persistence.FundJoinDao;

@Service
public class FundJoinService {
	
	@Resource
	private FundDao fundDao;
	
	@Resource
	private FundJoinDao fundJoinDao;
	
	@Transactional
	public void add(FundJoin fundJoin) {
		fundJoinDao.add(fundJoin);
	}
}
