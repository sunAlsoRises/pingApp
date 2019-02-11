package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.t_reportError;

public interface t_reportErrorMapper {
    int deleteByPrimaryKey(String reporterrorid);

    int insert(t_reportError record);

    int insertSelective(t_reportError record);

    t_reportError selectByPrimaryKey(String reporterrorid);

    int updateByPrimaryKeySelective(t_reportError record);

    int updateByPrimaryKey(t_reportError record);
    
    List<t_reportError> selectPageBySql(@Param("sql") String sql, @Param("pageSize") int pageSize, @Param("pageStart") int pageStart);
}