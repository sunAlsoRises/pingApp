package com.services;

import java.util.List;

import com.model.t_user;

public interface t_userService {

	List<t_user> selectBySql(String sql);

	int insertSelective(t_user userDEMO);

	int selectCountBySql(String string);

	int updateByPrimaryKeySelective(t_user user);

	t_user selectByKey(String userid);

}
