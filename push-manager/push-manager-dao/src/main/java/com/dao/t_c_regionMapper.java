package com.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.t_c_region;

public interface t_c_regionMapper {
    int insert(t_c_region record);

    int insertSelective(t_c_region record);
    
    List<t_c_region> selectBySql(@Param("sql") String sql);
    
    int selectCountBySql(@Param("sql") String sql);
}