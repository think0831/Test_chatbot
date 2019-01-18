package com.afc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.afc.domain.Fund;
import com.afc.persistence.FundDao;

@Service
public class FundService {
	
	@Resource
	private FundDao fundDao;
	
	public Fund view(int fundNumber) {
		return this.fundDao.viewFromNumber(fundNumber);
	}
	
	@Transactional
	public List<Fund> list(String fundType) {
		return this.fundDao.list(fundType);
	}
}
