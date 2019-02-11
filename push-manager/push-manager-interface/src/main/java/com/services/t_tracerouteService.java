package com.services;

import java.util.List;
import java.util.Map;

import com.model.t_traceroute;

public interface t_tracerouteService {

	int insertSelective(t_traceroute traceDEMO);

	int insertMany(List<Map<String, Object>> list);

}
