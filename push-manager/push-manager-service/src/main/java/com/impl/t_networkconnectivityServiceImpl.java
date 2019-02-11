package com.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.t_networkconnectivityMapper;
import com.model.t_networkconnectivity;
import com.services.t_networkconnectivityService;

@Service("t_networkconnectivityService")
public class t_networkconnectivityServiceImpl implements t_networkconnectivityService {

	@Resource
	t_networkconnectivityMapper networkconnectivitymapper;
	
	@Override
	public int insertSelective(t_networkconnectivity demo) {
		return networkconnectivitymapper.insertSelective(demo);
	}

	/**
	 * 批量上传
	 */
	@Override
	public int insertMany(List<Map<String, Object>> list) {
		return networkconnectivitymapper.insertMany(list);
	}

}
