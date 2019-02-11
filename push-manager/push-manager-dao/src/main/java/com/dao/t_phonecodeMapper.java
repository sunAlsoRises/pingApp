package com.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.t_phonecode;

public interface t_phonecodeMapper {
    int insert(t_phonecode record);

    int insertSelective(t_phonecode record);
    
    List<t_phonecode> selectBySql(@Param("sql") String sql);
}