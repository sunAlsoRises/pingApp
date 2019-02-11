package com.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.t_webthroughMapper;
import com.model.t_webthrough;
import com.services.t_webthroughService;

@Service("t_webthroughService")
public class t_webthroughServiceImpl implements t_webthroughService {
	
	@Resource
	t_webthroughMapper webthroughmapper;

	@Override
	public int insertSelective(t_webthrough demo) {
		return webthroughmapper.insertSelective(demo);
	}

	@Override
	public int insertMany(List<Map<String, Object>> list) {
		return webthroughmapper.insertMany(list);
	}

	

}
