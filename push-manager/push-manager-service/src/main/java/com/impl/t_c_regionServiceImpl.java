package com.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.t_c_regionMapper;
import com.model.t_c_region;
import com.services.t_c_regionService;


@Service("t_c_regionService")
public class t_c_regionServiceImpl implements t_c_regionService {

	@Resource
	private t_c_regionMapper regionmapper;

	@Override
	public List<t_c_region> selectBySql(String sql) {
		return regionmapper.selectBySql(sql);
	}

	@Override
	public int selectCountBySql(String sql) {
		return regionmapper.selectCountBySql(sql);
	}
}
