package com.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.t_diagnosisMapper;
import com.model.t_diagnosis;
import com.services.t_diagnosisService;


@Service("t_diagnosisService")
public class t_diagnosisServiceImpl implements t_diagnosisService {
	
	@Resource
	t_diagnosisMapper diagnosismapper;

	@Override
	public int insertSelective(t_diagnosis diagnosisDEMO) {
		return diagnosismapper.insertSelective(diagnosisDEMO);
	}

}
