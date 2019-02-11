package com.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.t_user;

public interface t_userMapper {
    int deleteByPrimaryKey(String userid);

    int insert(t_user record);

    int insertSelective(t_user record);

    t_user selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(t_user record);

    int updateByPrimaryKey(t_user record);
    
    List<t_user> selectBySql(@Param("sql") String sql);
    
    int selectCountBySql(@Param("sql") String sql);
}