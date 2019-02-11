package com.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dao.UserMapper;
import com.model.User;
import com.services.UserService;


@Service("UserService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userdao;

	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		return this.userdao.selectByPrimaryKey(userId);
	}

	@Override
	public User getUserByName(String userName) {
		// TODO Auto-generated method stub
		return this.userdao.selectByUserName(userName);
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return this.userdao.insertSelective(record);
	}

	@Override
	public String selectUser() {
		// TODO Auto-generated method stub
		return toJson(this.userdao.selectUser());
	}

	public String toJson(List<User> dateList){
		JSONObject row=null;
		JSONArray dataArr=new JSONArray();
		for(int i=0;i<dateList.size();i++){
			row=new JSONObject();
			row.put("id", dateList.get(i).getId());
			row.put("name", dateList.get(i).getName());
			row.put("password", dateList.get(i).getPassword());
			dataArr.add(row);
		}
		return dataArr.toString();
	}

	@Override
	public String selectUseToPage(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		String pageNow = request.getParameter("pageNow");  
		  
	   /* Page page = null;  
	  
	    List<ProductWithBLOBs> products = new ArrayList<ProductWithBLOBs>();  
	  
	    int totalCount = (int) productDao.getProductsCount(loginUserId);  
	  
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        allProducts = this.productDao.selectProductsByPage(page.getStartPos(), page.getPageSize(), loginUserId);  
	    } else {  
	        page = new Page(totalCount, 1);  
	        allProducts = this.productDao.selectProductsByPage(page.getStartPos(), page.getPageSize(), loginUserId);  
	    }  
	  
	    model.addAttribute("products", products);  
	    model.addAttribute("page", page);  */
		return null;
	}

	
}
