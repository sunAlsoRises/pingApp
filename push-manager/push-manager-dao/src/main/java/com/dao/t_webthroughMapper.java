package com.dao;

import java.util.List;
import java.util.Map;

import com.model.t_webthrough;

public interface t_webthroughMapper {
    int deleteByPrimaryKey(String webthroughid);

    int insert(t_webthrough record);

    int insertSelective(t_webthrough record);

    t_webthrough selectByPrimaryKey(String webthroughid);

    int updateByPrimaryKeySelective(t_webthrough record);

    int updateByPrimaryKey(t_webthrough record);
    
    int insertMany(List<Map<String, Object>> list);
}