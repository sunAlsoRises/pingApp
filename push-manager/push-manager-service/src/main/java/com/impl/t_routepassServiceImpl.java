package com.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.t_routepassMapper;
import com.model.t_routepass;
import com.services.t_routepassService;


@Service("t_routepassService")
public class t_routepassServiceImpl implements t_routepassService {

	@Resource
	t_routepassMapper routepassmapper;
	
	@Override
	public int insertSelective(t_routepass passDEMO) {
		return routepassmapper.insertSelective(passDEMO);
	}

}
