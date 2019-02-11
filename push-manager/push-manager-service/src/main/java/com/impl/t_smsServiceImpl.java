package com.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.t_smsMapper;
import com.model.t_sms;
import com.services.t_smsService;


@Service("t_smsService")
public class t_smsServiceImpl implements t_smsService {
	
	@Resource
	t_smsMapper smsmapper;

	@Override
	public int deleteByPrimaryKey(String smsid) {
		
		return smsmapper.deleteByPrimaryKey(smsid);
	}

	@Override
	public int insert(t_sms record) {
		return smsmapper.insert(record);
	}

	@Override
	public int insertSelective(t_sms record) {
		return smsmapper.insertSelective(record);
	}

	@Override
	public t_sms selectByPrimaryKey(String smsid) {
		return smsmapper.selectByPrimaryKey(smsid);
	}

	@Override
	public int updateByPrimaryKeySelective(t_sms record) {
		return smsmapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(t_sms record) {
		return smsmapper.updateByPrimaryKey(record);
	}

	@Override
	public int selectCountBySql(String sql) {
		return smsmapper.selectCountBySql(sql);
	}

	@Override
	public List<t_sms> selectBySql(String sql) {
		return smsmapper.selectBySql(sql);
	}

}
