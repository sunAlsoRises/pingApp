package com.services;

import java.util.List;

import com.model.t_phonecode;

public interface t_phonecodeService {

	int insertSelective(t_phonecode codeDEMO);

	List<t_phonecode> selectBySql(String sql);

}
