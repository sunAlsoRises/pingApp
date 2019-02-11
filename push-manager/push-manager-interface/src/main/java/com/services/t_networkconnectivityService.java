package com.services;

import java.util.List;
import java.util.Map;

import com.model.t_networkconnectivity;

public interface t_networkconnectivityService {

	int insertSelective(t_networkconnectivity demo);

	int insertMany(List<Map<String, Object>> list);

}
