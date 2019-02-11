package com.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.t_userMapper;
import com.model.t_user;
import com.services.t_userService;

@Service("t_userService")
public class t_userServiceImpl implements t_userService {
	
	@Resource
	private t_userMapper usermapper;

	@Override
	public List<t_user> selectBySql(String sql) {
		return usermapper.selectBySql(sql);
	}

	@Override
	public int insertSelective(t_user userDEMO) {
		return usermapper.insertSelective(userDEMO);
	}

	@Override
	public int selectCountBySql(String string) {
		return usermapper.selectCountBySql(string);
	}

	@Override
	public int updateByPrimaryKeySelective(t_user user) {
		return usermapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public t_user selectByKey(String userid) {
		return usermapper.selectByPrimaryKey(userid);
	}
}
