package com.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.t_phonecodeMapper;
import com.model.t_phonecode;
import com.services.t_phonecodeService;


@Service("t_phonecodeService")
public class t_phonecodeServiceImpl implements t_phonecodeService {
	
	@Resource
	t_phonecodeMapper phonecodemapper;

	@Override
	public int insertSelective(t_phonecode codeDEMO) {
		return phonecodemapper.insertSelective(codeDEMO);
	}

	@Override
	public List<t_phonecode> selectBySql(String sql) {
		return phonecodemapper.selectBySql(sql);
	}
}
