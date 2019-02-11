package com.services;

import java.util.List;

import com.model.t_c_region;

public interface t_c_regionService {

	List<t_c_region> selectBySql(String sql);

	int selectCountBySql(String sql);

}
