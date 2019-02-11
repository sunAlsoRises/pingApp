package com.services;

import java.util.List;
import java.util.Map;

import com.model.t_webthrough;

public interface t_webthroughService {

	int insertSelective(t_webthrough demo);

	int insertMany(List<Map<String, Object>> list);

}
