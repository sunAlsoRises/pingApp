package com.services;

import java.util.List;


import com.model.t_collectnet;

public interface t_collectnetService {
    int deleteByPrimaryKey(String collectnetid);

    int insert(t_collectnet record);

    int insertSelective(t_collectnet record);

    t_collectnet selectByPrimaryKey(String collectnetid);

    int updateByPrimaryKeySelective(t_collectnet record);

    int updateByPrimaryKey(t_collectnet record);
    
    List<t_collectnet> selectBySql(String sql);
}