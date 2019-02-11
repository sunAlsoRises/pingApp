package com.services;



import java.util.List;

import org.springframework.stereotype.Service;

import com.model.t_sms;



public interface t_smsService {
    int deleteByPrimaryKey(String smsid);

    int insert(t_sms record);

    int insertSelective(t_sms record);

    t_sms selectByPrimaryKey(String smsid);

    int updateByPrimaryKeySelective(t_sms record);

    int updateByPrimaryKey(t_sms record);
    
    int selectCountBySql(String sql);
    
    List<t_sms> selectBySql(String sql);
}