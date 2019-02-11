package com.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.t_reportErrorMapper;
import com.model.t_reportError;
import com.services.t_reportErrorService;


@Service("t_reportErrorService")
public class t_reportErrorServiceImpl implements t_reportErrorService {

	@Resource
	private t_reportErrorMapper reporterrormapper;
	
	@Override
	public int deleteByPrimaryKey(String reporterrorid) {
		return reporterrormapper.deleteByPrimaryKey(reporterrorid);
	}

	@Override
	public int insert(t_reportError record) {
		return reporterrormapper.insert(record);
	}

	@Override
	public int insertSelective(t_reportError record) {
		return reporterrormapper.insertSelective(record);
	}

	@Override
	public t_reportError selectByPrimaryKey(String reporterrorid) {
		return reporterrormapper.selectByPrimaryKey(reporterrorid);
	}

	@Override
	public int updateByPrimaryKeySelective(t_reportError record) {
		return reporterrormapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(t_reportError record) {
		return reporterrormapper.updateByPrimaryKey(record);
	}

	@Override
	public List<t_reportError> selectPageBySql(String sql, int pageSize, int pageStart) {
		return reporterrormapper.selectPageBySql(sql, pageSize, pageStart);
	}

}
