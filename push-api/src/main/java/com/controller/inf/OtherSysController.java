package com.controller.inf;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.t_appversion;
import com.model.t_c_region;
import com.model.t_collectnet;
import com.model.t_sms;
import com.model.t_user;
import com.services.t_appversionService;
import com.services.t_c_regionService;
import com.services.t_collectnetService;
import com.services.t_smsService;
import com.services.t_userService;

import commonSources.HttpConnectionManager;
import commonSources.SysConfig;
import commonSources.myUtil;

/**
 * 其他
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("/OtherSys")
public class OtherSysController {

	Map<String, Object> map = null;

	@Resource
	private t_appversionService appversionservice;

	@Resource
	private t_c_regionService regionservice;

	@Resource
	private t_smsService smsservice;

	@Resource
	private t_collectnetService collectnetservice;
	
	@Resource
	private t_userService userservice;

	/**
	 * 上传APP版本号
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/UpAppVersion")
	@ResponseBody
	public Map<String, Object> UpAppVersion(HttpServletRequest request) {
		map = new HashMap<String, Object>();

		try {
			String params = request.getParameter("params");
			JSONObject jo = new JSONObject(params);
			String appVersionNum = jo.getString("appVersionNum");
			String appVersionNote = jo.getString("appVersionNote");
			t_appversion appDEMO = new t_appversion();
			appDEMO.setAppversioncreatetime(new Date());
			appDEMO.setAppversionid(UUID.randomUUID().toString());
			appDEMO.setAppversionnote(appVersionNote);
			appDEMO.setAppversionnum(appVersionNum);
			appversionservice.insertSelective(appDEMO);
			map.put("code", 200);
			map.put("msg", "更新APP版本成功");
			map.put("resp", "");

		} catch (JSONException e) {
			map.put("code", 100);
			map.put("msg", "更新APP版本失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 获取地区
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAreaList")
	@ResponseBody
	public Map<String, Object> getAreaList(HttpServletRequest request) {
		map = new HashMap<String, Object>();
		try {
			String params = request.getParameter("params");
			String sql = " where r_parent_code = " + params;
			List<t_c_region> regionDEMO1 = regionservice.selectBySql(sql);
			for (int i = 0; i < regionDEMO1.size(); i++) {
				sql = " where r_parent_code = " + regionDEMO1.get(i).getrCode();
				regionDEMO1.get(i).setNextLevelCount(regionservice.selectCountBySql(sql));
			}
			/*
			 * String sql=" where r_level = 0"; List<t_c_region>
			 * regionDEMO1=regionservice.selectBySql(sql);//获取第一层数据
			 * List<t_c_region> regionDEMO2=null; List<t_c_region>
			 * regionDEMO3=null; for(int i=0;i<regionDEMO1.size();i++){
			 * sql=" where r_level = 1 and r_parent_code = "+regionDEMO1.get(i).
			 * getrCode(); regionDEMO2=regionservice.selectBySql(sql);//获取第二层
			 * regionDEMO1.get(i).setChildreddemo(regionDEMO2); for(int
			 * j=0;j<regionDEMO2.size();j++){
			 * sql=" where r_level = 2 and r_parent_code = "+regionDEMO2.get(j).
			 * getrCode(); regionDEMO3=regionservice.selectBySql(sql);//获取第二层
			 * regionDEMO2.get(j).setChildreddemo(regionDEMO3); } }
			 */
			map.put("code", 200);
			map.put("msg", "获取地域标识成功");
			map.put("resp", regionDEMO1);
		} catch (Exception e) {
			map.put("code", 100);
			map.put("msg", "获取地域标识失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 根据地区获取探针
	 * 
	 * @param request
	 * @return
	 * 
	 */
	@RequestMapping("/getProbes")
	@ResponseBody
	public Map<String, Object> getProbesByArea(HttpServletRequest request) {
		map = new HashMap<String, Object>();
		try {
			String params = request.getParameter("params");
			JSONObject jo = new JSONObject(params);
			String recode = jo.getString("recode");
			String path = "http://124.95.165.176:9090/dataproxy/proxy/probe/v2/Provincelist";
			String data = "source_id=110201792&recode=" + recode;
			Map<String, Object> mymap = myUtil.getInterface(path, data);
			if (mymap.get("status_code").equals("0")) {
				map.put("code", 200);
			} else {
				map.put("code", 100);
			}
			map.put("msg", mymap.get("description"));
			map.put("resp", mymap.get("probes"));
		} catch (JSONException e) {
			map.put("code", 100);
			map.put("msg", e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}catch (Exception e){
			map.put("code", 101);
			map.put("msg", e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}

		return map;
		// return map;
	}

	/**
	 * 运维人员登录提醒
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/PushUserLoginIn")
	@ResponseBody
	public Map<String, Object> PushUserLoginIn(HttpServletRequest request) {
		map = new HashMap<String, Object>();
		return map;
	}

	/**
	 * 运维人员退出提醒
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/PushUserLoginOut")
	@ResponseBody
	public Map<String, Object> PushUserLoginOut(HttpServletRequest request) {
		map = new HashMap<String, Object>();
		return map;
	}

	/**
	 * 发送短信
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sendSms")
	@ResponseBody
	public Map<String, Object> sendSms(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		try {
			String parameter = request.getParameter("params");
			JSONObject js = new JSONObject(parameter);
			String phone = js.getString("phone");
			int random = (int) ((Math.random() * 9 + 1) * 100000);
			String msgg = "";
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			System.out.println(df.format(new Date())+"224当前时间");
			String sql = "where smsPhone = '" + phone + "' and '" + df.format(new Date())
					+ "' between smsCreateTime and smsEndTime";
			if (smsservice.selectCountBySql(sql) > 0) {
				map.put("code", 100);
				map.put("msg", "请勿重复发送！");
				map.put("resp", "");
			} else {
				try {
					String server = SysConfig.getInstance().getProperty("rest_server");
					System.out.println(server);
					StringBuffer sb = new StringBuffer("https://");
					sb.append(server).append("/ol/sms");
					String url = sb.append("/sendsms").toString();
					System.out.println(url);
					CloseableHttpClient httpClient = HttpConnectionManager.getInstance().getHttpClient();
					HttpPost httpPost = new HttpPost(url);
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("sid", "48a07b3fec5b348c3d857c070367e47f");
					jsonObject.put("token", "9c950b8f33b61e4d7f1dfc20e4daa3b2");
					jsonObject.put("appid", "a5e09c32a5a64149bc078321f6f8cbc5");
					jsonObject.put("templateid", "369038");
					jsonObject.put("param", random + ",180");
					System.out.println(phone);
					jsonObject.put("mobile", phone);
					jsonObject.put("uid", "4584");
					// 设置连接超时,设置读取超时
					RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000)
							.setSocketTimeout(10000).build();
					httpPost.setConfig(requestConfig);
					httpPost.setHeader("Accept", "application/json");
					httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
					// 设置参数
					StringEntity se = new StringEntity(jsonObject.toString(), "UTF-8");
					httpPost.setEntity(se);
					// 执行请求
					HttpResponse response = httpClient.execute(httpPost);
					// 打印执行结果
					String msg = EntityUtils.toString(response.getEntity(), "utf-8");
					System.out.println(msg);
					JSONObject jj = new JSONObject(msg);
					int code_ = jj.getInt("code");
					msgg = jj.getString("msg");
					System.out.println(code_);
					if (code_ == 000000) {
						// 发送成功

						map.put("code", Integer.valueOf(200));
						map.put("msg", "发送成功");
						map.put("resp", "");
						Date create_time = df.parse(df.format(new Date()));
						System.out.println("275create=="+create_time);
						Date due_time = new Date();
						System.out.println(due_time);
						due_time.setTime(due_time.getTime() + 3 * 60 * 1000);
						System.out.println("279endtime=="+due_time);
						// 插入数据库
						t_sms sms = new t_sms();
						sms.setSmscode(random + "");
						sms.setSmscreatetime(create_time);
						sms.setSmsendtime(due_time);
						sms.setSmsid(UUID.randomUUID().toString().replaceAll("-", ""));
						sms.setSmsphone(phone);
						sms.setSmsuesd(0);
						smsservice.insertSelective(sms);
					} else {
						map.put("code", Integer.valueOf(100));
						map.put("msg", msgg);
						map.put("resp", "");
					}
				} catch (Exception e) {
					// 开始异常打印
					e.printStackTrace();
					map.put("code", 100);
					map.put("msg", "发送失败" + e.getMessage());
					map.put("resp", "");
				}
			}
		} catch (JSONException e) {
			map.put("code", 100);
			map.put("msg", "发送失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}
		return map;
	}

	/*
	 * Account Sid （用户sid） 48a07b3fec5b348c3d857c070367e47f AppID （应用ID）
	 * a5e09c32a5a64149bc078321f6f8cbc5 Auth Token （鉴权密钥）
	 * 9c950b8f33b61e4d7f1dfc20e4daa3b2 369038 模版ID Rest URL （请求地址）
	 * https://open.ucpaas.com/ol/sms/{function}
	 */

	@RequestMapping("/getCollectNet")
	@ResponseBody
	public Map<String, Object> getCollectNet(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		try {
			String params = request.getParameter("params");
			JSONObject jo = new JSONObject(params);
			String userid = jo.getString("userid");
			// List<t_collectnet> cnet = collectnetservice.selectBySql(" where
			// collectnetStatus = 0");
			List<t_collectnet> cnet1 = collectnetservice.selectBySql(
					" where collectnetStatus = 0 and collectnetNum = 1 and (collectnetUser = '0' or collectnetUser = '"
							+ userid + "')");
			List<t_collectnet> cnet2 = collectnetservice.selectBySql(
					" where collectnetStatus = 0 and collectnetNum = 2 and (collectnetUser = '0' or collectnetUser = '"
							+ userid + "')");
			List<t_collectnet> cnet3 = collectnetservice.selectBySql(
					" where collectnetStatus = 0 and collectnetNum = 3 and (collectnetUser = '0' or collectnetUser = '"
							+ userid + "')");
			List<t_collectnet> cnet4 = collectnetservice.selectBySql(
					" where collectnetStatus = 0 and collectnetNum = 4 and (collectnetUser = '0' or collectnetUser = '"
							+ userid + "')");
			Map<String, Object> mymap = new HashMap<String, Object>();
			mymap.put("ping", cnet1);// ping
			mymap.put("http", cnet2);// http
			mymap.put("trace", cnet3);// trace
			mymap.put("download", cnet4);// download
			map.put("code", 200);
			map.put("msg", "获取网址成功");
			map.put("resp", mymap);
		} catch (JSONException e) {
			map.put("code", 100);
			map.put("msg", "获取网址失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", 100);
			map.put("msg", "获取网址失败" + e.getMessage());
			map.put("resp", "");
		}
		return map;
	}

	/**
	 * 添加收藏网址
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addCollectNet")
	@ResponseBody
	public Map<String, Object> addCollectNet(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String params = request.getParameter("params");
		try {
			JSONObject jo = new JSONObject(params);
			String curl = jo.getString("curl");// 网址
			String cname = jo.getString("cname");// 网址名称
			int cnum = jo.getInt("cnum");// 1:ping,2:http,3:trace,4:download
			String userid = jo.getString("userid");// 用户ID
			if(cnum!=1&&cnum!=2&&cnum!=3&&cnum!=4){
				map.put("code", 100);
				map.put("msg", "添加收藏网址失败,cnum必须为1,2,3,4中的一个");
				map.put("resp", "");
			}else{
				t_user user=userservice.selectByKey(userid);
				if(user==null){
					map.put("code", 100);
					map.put("msg", "添加收藏网址失败,请检查userid");
					map.put("resp", "");
				}else{
					t_collectnet cnet = new t_collectnet();
					cnet.setCollectnetid(UUID.randomUUID().toString());
					cnet.setCollectnetname(cname);
					cnet.setCollectnetnum(cnum);
					cnet.setCollectnetstatus(0);
					cnet.setCollectneturl(curl);
					cnet.setCollectnetuser(userid);
					collectnetservice.insertSelective(cnet);
					map.put("code", 200);
					map.put("msg", "添加收藏网址成功");
					map.put("resp", "");
				}
				
			}
			
		} catch (JSONException e) {
			map.put("code", 100);
			map.put("msg", "添加收藏网址失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		} catch (Exception e) {
			map.put("code", 100);
			map.put("msg", "添加收藏网址失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}
		return map;
	}

}
