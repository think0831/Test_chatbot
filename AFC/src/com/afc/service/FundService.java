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
	
	public List<Fund> listAsType(String fundType) {
		return this.fundDao.listAsType(fundType);
	}
	
	public List<Fund> listAsMemberNumber(int memberNumber) {
		return this.fundDao.listAsMemberNumber(memberNumber);
	}
}
