package com.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.t_networkspeedMapper;
import com.model.t_networkspeed;
import com.services.t_networkspeedService;

@Service("t_networkspeedService")
public class t_networkspeedServiceImpl implements t_networkspeedService {

	
	@Resource
	t_networkspeedMapper networkspeedmapper;
	
	@Override
	public int insertSelective(t_networkspeed speedDMEO) {
		return networkspeedmapper.insertSelective(speedDMEO);
	}

	@Override
	public int insertMany(List<Map<String, Object>> list) {
		return networkspeedmapper.insertMany(list);
	}

}
