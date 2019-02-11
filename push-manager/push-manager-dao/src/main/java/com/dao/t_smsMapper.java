package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.t_sms;

public interface t_smsMapper {
    int deleteByPrimaryKey(String smsid);

    int insert(t_sms record);

    int insertSelective(t_sms record);

    t_sms selectByPrimaryKey(String smsid);

    int updateByPrimaryKeySelective(t_sms record);

    int updateByPrimaryKey(t_sms record);
    
    int selectCountBySql(@Param("sql") String sql);
    
    List<t_sms> selectBySql(@Param("sql") String sql);
}