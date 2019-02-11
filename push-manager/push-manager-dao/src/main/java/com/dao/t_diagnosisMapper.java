package com.dao;

import com.model.t_diagnosis;

public interface t_diagnosisMapper {
    int deleteByPrimaryKey(String diagnosisid);

    int insert(t_diagnosis record);

    int insertSelective(t_diagnosis record);

    t_diagnosis selectByPrimaryKey(String diagnosisid);

    int updateByPrimaryKeySelective(t_diagnosis record);

    int updateByPrimaryKey(t_diagnosis record);
}