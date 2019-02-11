package com.services;

import java.util.List;
import java.util.Map;

import com.model.t_networkspeed;

public interface t_networkspeedService {

	int insertSelective(t_networkspeed speedDMEO);

	int insertMany(List<Map<String, Object>> list);

}
