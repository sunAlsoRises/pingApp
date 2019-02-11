package com.controller.inf;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.t_phonecode;
import com.model.t_sms;
import com.model.t_user;
import com.services.t_phonecodeService;
import com.services.t_smsService;
import com.services.t_userService;

import commonSources.MD5Message;
import commonSources.myUtil;

@Controller
@RequestMapping("/Logining")
public class LoginingController {

	@Resource
	private t_userService userservice;

	@Resource
	private t_phonecodeService phonecodeservice;

	@Resource
	private t_smsService smsservice;

	Map<String, Object> map = null;

	/**
	 * 用户登录
	 * 
	 * @param request
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@RequestMapping("/LoginIn")
	@ResponseBody
	public Map<String, Object> LoginIn(HttpServletRequest request) throws NoSuchAlgorithmException {
		map = new HashMap<String, Object>();
		try {
			String params = request.getParameter("params");
			JSONObject jo = new JSONObject(params);
			String phone = jo.getString("phone");
			String pwd = jo.getString("password");
			String type = jo.getString("type");// 1众测，2运维
//			if (type.equals("1")) {
//				String sql = " where userPhone = '" + phone + "' and userPassword = '" + MD5Message.getMD5(pwd) + "' ";
			String sql = " where userPhone = '" + phone + "' and userPassword = '" + MD5Message.getMD5(pwd) + "' and userType = '"+type+"' ";
			List<t_user> userDEMO = userservice.selectBySql(sql);
				if (userDEMO.size() == 0) {
					// 查找账号密码不匹配
					map.put("code", 100);
					map.put("msg", "登陆失败，账号密码不匹配,或者登陆类型不匹配");
					map.put("resp", "");
				} else {
					// 众测
					map.put("code", 200);
					map.put("msg", "登录成功");
					t_user u = new t_user();
					u.setUserid(userDEMO.get(0).getUserid());
					u.setUserArea(userDEMO.get(0).getUserArea());
					u.setUserloginname(userDEMO.get(0).getUserloginname());
					if (u.getUserid() == null){
						map.put("msg","没有获取到id");
					}
//					else if(u.getUserArea() == null){
//						map.put("msg","获取区域失败");
//					}
					map.put("resp", u);
					// map.put("resp", "");
				}
//			} else {
//				// 运维
//				String path = "http://124.95.165.176:9090/dataproxy/proxy/login/v2/login";
//				String data = "data={\"source_id\":\"110201790\", \"username\": \"" + phone + "\", \"password\": \""
//						+ pwd + "\" }";
//				Map<String, Object> mymap = myUtil.getInterface(path, data);
//				if (mymap.get("code").equals("0")) {
//					map.put("code", 200);
//				} else {
//					map.put("code", 100);
//				}
//				map.put("msg", mymap.get("msg"));
//				map.put("resp", "");
//			}

		} catch (JSONException e) {
			map.put("code", 100);
			map.put("msg", "登录失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 众测用户注册接口
	 * 
	 * @param request
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@RequestMapping("/Register")
	@ResponseBody
	public Map<String, Object> register(HttpServletRequest request) throws NoSuchAlgorithmException {
		map = new HashMap<String, Object>();
		try {
			String params = request.getParameter("params");
			JSONObject jo = new JSONObject(params);
			String phone = jo.getString("phone");
			String pwd = jo.getString("password");
			int cnum = userservice.selectCountBySql(" where userPhone = '" + phone + "'");
			if (cnum > 0) {
				map.put("code", 100);
				map.put("msg", "注册失败,手机号已存在,请勿重复注册");
				map.put("resp", "");
				System.out.println("走了吗140");
			} else {
				t_user userDEMO = new t_user();
				String userid = UUID.randomUUID().toString().replaceAll("-", "_");
				userDEMO.setUserid(userid);
				userDEMO.setUserphone(phone);
				userDEMO.setUserpassword(MD5Message.getMD5(pwd));
				userDEMO.setUsertype(1);
				userDEMO.setUserstatus(0);
				int i = userservice.insertSelective(userDEMO);
				System.out.println("走了吗155=="+i);
				map.put("code", 200);
				map.put("msg", "注册成功");
				map.put("resp", userDEMO);
			}
		} catch (JSONException e) {
			map.put("code", 100);
			map.put("msg", "注册失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 验证验证码是否正确
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/RCode")
	@ResponseBody
	public Map<String, Object> RCode(HttpServletRequest request) {
		map = new HashMap<String, Object>();
		try {
			String params = request.getParameter("params");
			JSONObject jo = new JSONObject(params);
			String phone = jo.getString("phone");
			String code = jo.getString("code");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(sdf.format(new Date()) +"当前时间");
			String sql = " where smsPhone = '" + phone + "' and smsUesd = 0 and '" + sdf.format(new Date())
					+ "' between smsCreateTime and smsEndTime order by smsCreateTime desc";
			List<t_sms> mysms = smsservice.selectBySql(sql);
			if (mysms.size() > 0) {
				if (mysms.get(0).getSmscode().equals(code)) {
					// 验证码正确
					map.put("code", 200);
					map.put("msg", "校验验证码成功");
					map.put("resp", "");
				} else {
					map.put("code", 100);
					map.put("msg", "校验验证码失败,验证码错误");
					map.put("resp", "");
				}
			} else {
				map.put("code", 100);
				map.put("msg", "校验验证码失败,验证码已过期");
				map.put("resp", "");
			}
		} catch (JSONException e) {
			map.put("code", 100);
			map.put("msg", "校验验证码失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}
		return map;
	}

}
