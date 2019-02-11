package com.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.t_tracerouteMapper;
import com.model.t_traceroute;
import com.services.t_tracerouteService;
@Service("t_tracerouteService")
public class t_tracerouteServiceImpl implements t_tracerouteService {
	
	@Resource
	t_tracerouteMapper traceroutemapper;

	@Override
	public int insertSelective(t_traceroute traceDEMO) {
		return traceroutemapper.insertSelective(traceDEMO);
	}

	@Override
	public int insertMany(List<Map<String, Object>> list) {
		return traceroutemapper.insertMany(list);
	}

}
