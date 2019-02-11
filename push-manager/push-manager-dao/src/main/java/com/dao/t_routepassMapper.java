package com.dao;

import com.model.t_routepass;

public interface t_routepassMapper {
    int deleteByPrimaryKey(String routepassid);

    int insert(t_routepass record);

    int insertSelective(t_routepass record);

    t_routepass selectByPrimaryKey(String routepassid);

    int updateByPrimaryKeySelective(t_routepass record);

    int updateByPrimaryKey(t_routepass record);
}