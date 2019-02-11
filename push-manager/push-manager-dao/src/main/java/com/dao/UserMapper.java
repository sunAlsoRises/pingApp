package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User selectByUserName(String userName);
	
	List<User> selectUser();
	
	List<User> selectUserToPage(@Param(value = "startPos") Integer startPos, @Param(value = "pageSize") Integer pageSize);
}