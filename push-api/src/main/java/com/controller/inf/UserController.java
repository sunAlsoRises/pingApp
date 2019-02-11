package com.controller.inf;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.User;
import com.model.t_user;
import com.services.UserService;
import com.services.t_userService;

import commonSources.MD5Message;
import commonSources.jsonUtil;

@Controller
@RequestMapping("/User")
public class UserController {

	@Resource
	private t_userService userservice;

	/**
	 * 获取用户信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getUser")
	@ResponseBody
	public Map<String, Object> getUser(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String params = request.getParameter("params");
			JSONObject jo = new JSONObject(params);
			String userid = jo.getString("userid");
			String type = jo.getString("type");// 1运维，2众测
			if (type.equals("1")) {
				map.put("code", 100);
				map.put("msg", "获取用户信息失败，暂不支持运维人员信息获取");
				map.put("resp", "");
			} else if (type.equals("2")) {
				List<t_user> user = userservice.selectBySql(" where userId = '" + userid + "'");
				if (user.size() == 0) {
					map.put("code", 100);
					map.put("msg", "获取用户信息失败，无该用户信息");
					map.put("resp", "");
				} else {
					map.put("code", 200);
					map.put("msg", "获取用户信息成功");
					map.put("resp", user.get(0));
				}
			} else {
				map.put("code", 100);
				map.put("msg", "获取用户信息失败，type只能为1或者2");
				map.put("resp", "");
			}

		} catch (JSONException e) {
			map.put("code", 100);
			map.put("msg", "获取用户信息失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 修改用户信息
	 * 96e79218965eb72c92a549dd5a330112
	 * @param request
	 * @return
	 */
	@RequestMapping("/changeUser")
	@ResponseBody
	public Map<String, Object> changeUser(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String params = request.getParameter("params");
			JSONObject jo = new JSONObject(params);
			String userid = jo.getString("userid");
			String type = jo.getString("type");// 1运维，2众测
			String userphone = jo.getString("userphone");
			String userloginname = jo.getString("userloginname");
			String userpassword = jo.getString("userpassword");
			String username = jo.getString("username");
			if (type.equals("1")) {
				map.put("code", 100);
				map.put("msg", "修改用户信息失败，运维人员信息暂时无法修改");
				map.put("resp", "");
			} else if (type.equals("2")) {
				if(userid.isEmpty()){
					map.put("code", 100);
					map.put("msg", "修改用户信息失败，userid不能为空");
					map.put("resp", "");
				}else{
					t_user user = new t_user();
					user.setUserid(userid);
					if (!userloginname.isEmpty())
						user.setUserloginname(userloginname);
					if (!username.isEmpty())
						user.setUsername(username);
					if (!userpassword.isEmpty())
						user.setUserpassword(MD5Message.getMD5(userpassword));
					if (!userphone.isEmpty())
						user.setUserphone(userphone);
					userservice.updateByPrimaryKeySelective(user);
					map.put("code", 200);
					map.put("msg", "修改用户信息成功");
					map.put("resp", "");
				}
				
			}else{
				map.put("code", 100);
				map.put("msg", "修改用户信息失败，type只能为1或者2");
				map.put("resp", "");
			}
		} catch (JSONException e) {
			e.printStackTrace();
			map.put("code", 100);
			map.put("msg", "修改用户信息失败，"+e.getMessage());
			map.put("resp", "");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			map.put("code", 100);
			map.put("msg", "修改用户信息失败，"+e.getMessage());
			map.put("resp", "");
		}
		return map;
	}

}
