package com.dao;

import java.util.List;
import java.util.Map;

import com.model.t_networkconnectivity;

public interface t_networkconnectivityMapper {
    int deleteByPrimaryKey(String networkconnectivityid);

    int insert(t_networkconnectivity record);

    int insertSelective(t_networkconnectivity record);

    t_networkconnectivity selectByPrimaryKey(String networkconnectivityid);

    int updateByPrimaryKeySelective(t_networkconnectivity record);

    int updateByPrimaryKey(t_networkconnectivity record);
    
    int insertMany(List<Map<String, Object>> list);
}