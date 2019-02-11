package com.services;

import java.util.List;

import com.model.t_appversion;

public interface t_appversionService {

	int insertSelective(t_appversion appDEMO);

	List<t_appversion> selectBySql(String string);

}
