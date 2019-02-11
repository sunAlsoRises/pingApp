package com.dao;

import java.util.List;
import java.util.Map;

import com.model.t_traceroute;

public interface t_tracerouteMapper {
    int deleteByPrimaryKey(String tracerouteid);

    int insert(t_traceroute record);

    int insertSelective(t_traceroute record);

    t_traceroute selectByPrimaryKey(String tracerouteid);

    int updateByPrimaryKeySelective(t_traceroute record);

    int updateByPrimaryKey(t_traceroute record);
    
    int insertMany(List<Map<String, Object>> list);
}