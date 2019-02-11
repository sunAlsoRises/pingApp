package com.dao;

import java.util.List;
import java.util.Map;

import com.model.t_networkspeed;

public interface t_networkspeedMapper {
    int deleteByPrimaryKey(String networkspeedid);

    int insert(t_networkspeed record);

    int insertSelective(t_networkspeed record);

    t_networkspeed selectByPrimaryKey(String networkspeedid);

    int updateByPrimaryKeySelective(t_networkspeed record);

    int updateByPrimaryKey(t_networkspeed record);
    
    int insertMany(List<Map<String, Object>> list);
}