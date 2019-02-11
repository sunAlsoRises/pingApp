package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.t_appversion;

public interface t_appversionMapper {
    int deleteByPrimaryKey(String appversionid);

    int insert(t_appversion record);

    int insertSelective(t_appversion record);

    t_appversion selectByPrimaryKey(String appversionid);

    int updateByPrimaryKeySelective(t_appversion record);

    int updateByPrimaryKey(t_appversion record);
    
    List<t_appversion> selectBySql(@Param("sql") String sql);
}