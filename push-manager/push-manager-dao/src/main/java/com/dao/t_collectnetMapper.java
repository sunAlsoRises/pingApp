package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.t_collectnet;

public interface t_collectnetMapper {
    int deleteByPrimaryKey(String collectnetid);

    int insert(t_collectnet record);

    int insertSelective(t_collectnet record);

    t_collectnet selectByPrimaryKey(String collectnetid);

    int updateByPrimaryKeySelective(t_collectnet record);

    int updateByPrimaryKey(t_collectnet record);
    
    List<t_collectnet> selectBySql(@Param("sql") String sql);
}