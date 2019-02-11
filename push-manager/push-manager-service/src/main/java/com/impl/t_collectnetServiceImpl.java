package com.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.t_collectnetMapper;
import com.model.t_collectnet;
import com.services.t_collectnetService;


@Service("t_collectnetService")
public class t_collectnetServiceImpl implements t_collectnetService {

	@Resource
	t_collectnetMapper mapper;
	
	
	@Override
	public int deleteByPrimaryKey(String collectnetid) {
		return mapper.deleteByPrimaryKey(collectnetid);
	}

	@Override
	public int insert(t_collectnet record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(t_collectnet record) {
		return mapper.insertSelective(record);
	}

	@Override
	public t_collectnet selectByPrimaryKey(String collectnetid) {
		return mapper.selectByPrimaryKey(collectnetid);
	}

	@Override
	public int updateByPrimaryKeySelective(t_collectnet record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(t_collectnet record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<t_collectnet> selectBySql(String sql) {
		return mapper.selectBySql(sql);
	}

}
