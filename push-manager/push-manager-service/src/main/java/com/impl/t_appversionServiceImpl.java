package com.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.t_appversionMapper;
import com.model.t_appversion;
import com.services.t_appversionService;


@Service("t_appversionService")
public class t_appversionServiceImpl implements t_appversionService {
	
	@Resource
	t_appversionMapper appversionmapper;

	@Override
	public int insertSelective(t_appversion appDEMO) {
		return appversionmapper.insertSelective(appDEMO);
	}

	@Override
	public List<t_appversion> selectBySql(String string) {
		return appversionmapper.selectBySql(string);
	}

}
