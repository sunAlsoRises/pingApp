package com.dao;

import com.model.t_perssion;

public interface t_perssionMapper {
    int deleteByPrimaryKey(String perssionid);

    int insert(t_perssion record);

    int insertSelective(t_perssion record);

    t_perssion selectByPrimaryKey(String perssionid);

    int updateByPrimaryKeySelective(t_perssion record);

    int updateByPrimaryKey(t_perssion record);
}