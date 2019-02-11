package com.services;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.model.User;

public interface UserService {
	public User getUserById(String string);
	
	public User getUserByName(String userName);
	
	public int insertSelective(User record);
	
	public String selectUser();

	public String selectUseToPage(HttpServletRequest request, Model model);
}
