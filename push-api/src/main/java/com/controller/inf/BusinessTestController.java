package com.controller.inf;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.t_networkconnectivity;
import com.model.t_networkspeed;
import com.model.t_routepass;
import com.model.t_traceroute;
import com.model.t_webthrough;
import com.services.t_networkconnectivityService;
import com.services.t_networkspeedService;
import com.services.t_routepassService;
import com.services.t_tracerouteService;
import com.services.t_webthroughService;

/**
 * 业务测试
 *
 * @author admin
 *
 */
@Controller
@RequestMapping("/Business")
public class BusinessTestController {

	@Resource
	t_networkconnectivityService networkconnectivityservice;

	@Resource
	t_webthroughService webthroughservice;

	@Resource
	t_tracerouteService tracerouteservice;

	@Resource
	t_routepassService routepassservice;

	@Resource
	t_networkspeedService networkspeedservice;

	Map<String, Object> map = null;
	private static final Logger log = LoggerFactory.getLogger(BusinessTestController.class);
	/**
	 * 上传网络连通性测试（PING测试）测试数据
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/UpNetworkConnectivityTest")
	@ResponseBody
	public Map<String, Object> upNetworkConnectivityTest(HttpServletRequest request) {
		map = new HashMap<String, Object>();
		try {
			String params = request.getParameter("params");
			JSONArray ja = new JSONArray(params);
			JSONObject jo = new JSONObject();
			String networkConnectivityTime = "";
			String networkConnectivityUrl = "";
			String networkConnectionTimeOut = "";
			String networkConnectionPacketLoss = "";
			String networkConnectionShake = "";
			String appId = "";
			String userId = "";
			String userPhone = "";
			String areaId = "";
			String channelNote = "";
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> mymap = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
			String[] arrtimeout = {};
			String[] arrpacketloss = {};
			String[] arrshake = {};
			String[] arrurl = {};
			String[] arrtime = {};
			for (int i = 0; i < ja.length(); i++) {
				jo = ja.getJSONObject(i);
				networkConnectivityTime = jo.getString("networkConnectivityTime");
				networkConnectivityUrl = jo.getString("networkConnectivityUrl");
				networkConnectionTimeOut = jo.getString("networkConnectionTimeOut");
				networkConnectionPacketLoss = jo.getString("networkConnectionPacketLoss");
				networkConnectionShake = jo.getString("networkConnectionShake");
				appId = jo.getString("appId");
				userId = jo.getString("userId");
				userPhone = jo.getString("userPhone");
				areaId = jo.getString("areaId");
				channelNote = jo.getString("channelNote");

				arrtimeout = networkConnectionTimeOut.split("\\$\\$");
				arrpacketloss = networkConnectionPacketLoss.split("\\$\\$");
				arrshake = networkConnectionShake.split("\\$\\$");
				arrurl = networkConnectivityUrl.split("\\$\\$");
				arrtime = networkConnectivityTime.split("\\$\\$");
				for (int ii = 0; ii < arrpacketloss.length; ii++) {
					mymap = new HashMap<String, Object>();
					mymap.put("networkConnectivityID", UUID.randomUUID().toString());
					mymap.put("networkConnectivityTime", sdf.parse(sdf.format(Long.valueOf(arrtime[ii]))));
					mymap.put("networkConnectivityUrl", arrurl[ii]);
					mymap.put("networkConnectionTimeOut", arrtimeout[ii]);
					mymap.put("networkConnectionPacketLoss", arrpacketloss[ii]);
					mymap.put("networkConnectionShake", arrshake[ii]);
					mymap.put("appId", appId);
					mymap.put("userId", userId);
					mymap.put("userPhone", userPhone);
					mymap.put("areaId", areaId);
					mymap.put("channelNote", channelNote);
					list.add(mymap);
				}
			}
			networkconnectivityservice.insertMany(list);
			map.put("code", 200);
			map.put("msg", "上传网络连通性测试数据成功");
			map.put("resp", "");
		} catch (JSONException e) {
			e.printStackTrace();
			map.put("code", 100);
			map.put("msg", "上传网络连通性测试数据失败" + e.getMessage());
			map.put("resp", "");
		}catch (Exception e) {
			e.printStackTrace();
			map.put("code", 100);
			map.put("msg", "上传网络连通性测试数据失败" + e.getMessage());
			map.put("resp", "");
		}
		return map;
	}

	/**
	 * WEB浏览测试（HTTP测试）上传数据
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/UpWebThroughTest")
	@ResponseBody
	public Map<String, Object> upWebThroughTest(HttpServletRequest request) {
		map = new HashMap<String, Object>();
		try {
			String params = request.getParameter("params");
			JSONArray ja=new JSONArray(params);
			JSONObject jo = new JSONObject();
			String webThroughTime ="";
			String webThroughUrl = "";
			String webThroughDNS = "";
			String webThroughDNSTime = "";
			String webThroughTimeOut = "";
			String webThroughFirstByteTimeOut = "";
			String webThroughUploadFileTimeOut = "";
			String webThroughUploadSpeed = "";
			String appId = "";
			String userId = "";
			String userPhone = "";
			String areaId = "";
			String channelNote = "";
			String[] arrdnstime = {};
			String[] arrdns = {};
			String[] arrtimeout = {};
			String[] arrfirsttimeout = {};
			String[] arrfiletimeout = {};
			String[] arrspeed = {};
			String[] arrurl={};
			String[] arrtime={};
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy=MM-dd HH:mm:ss:SSS");
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> mymap = null;
			for(int i=0;i<ja.length();i++){
				jo=ja.getJSONObject(i);
				webThroughTime = jo.getString("webThroughTime");
				webThroughUrl = jo.getString("webThroughUrl");
				webThroughDNS = jo.getString("webThroughDNS");
				webThroughDNSTime = jo.getString("webThroughDNSTime");
				webThroughTimeOut = jo.getString("webThroughTimeOut");
				webThroughFirstByteTimeOut = jo.getString("webThroughFirstByteTimeOut");
				webThroughUploadFileTimeOut = jo.getString("webThroughUploadFileTimeOut");
				webThroughUploadSpeed = jo.getString("webThroughUploadSpeed");
				appId = jo.getString("appId");
				userId = jo.getString("userId");
				userPhone = jo.getString("userPhone");
				areaId = jo.getString("areaId");
				channelNote = jo.getString("channelNote");

				arrdnstime = webThroughDNSTime.split("\\$\\$");
				arrdns = webThroughDNS.split("\\$\\$");
				arrtimeout = webThroughTimeOut.split("\\$\\$");
				arrfirsttimeout = webThroughFirstByteTimeOut.split("\\$\\$");
				arrfiletimeout = webThroughUploadFileTimeOut.split("\\$\\$");
				arrspeed = webThroughUploadSpeed.split("\\$\\$");
				arrurl=webThroughUrl.split("\\$\\$");
				arrtime=webThroughTime.split("\\$\\$");
				for (int ii = 0; ii < arrdnstime.length; ii++) {
					mymap = new HashMap<String, Object>();
					mymap.put("webthroughid", UUID.randomUUID().toString().replaceAll("-", ""));
					mymap.put("webthroughtime", sdf.parse(sdf.format(Long.valueOf(arrtime[ii]))));
					mymap.put("webthroughurl", arrurl[ii]);
					mymap.put("webthroughdns", arrdns[ii]);
					mymap.put("webthroughtimeout", new Long(new Double(Double.parseDouble(arrtimeout[ii])).longValue()));
					mymap.put("webthroughfirstbytetimeout",
							new Long(new Double(Double.parseDouble(arrfirsttimeout[ii])).longValue()));
					mymap.put("webthroughuploadfiletimeout",
							new Long(new Double(Double.parseDouble(arrfiletimeout[ii])).longValue()));
					mymap.put("webthroughuploadspeed",
							new Long(new Double(Double.parseDouble(arrspeed[ii])).longValue()));
					mymap.put("appid", appId);
					mymap.put("userid", userId);
					mymap.put("userphone", userPhone);
					mymap.put("areaid", areaId);
					mymap.put("channelnote", channelNote);
					mymap.put("webthroughdnstime", arrdnstime[ii]);
					list.add(mymap);
				}
			}
			webthroughservice.insertMany(list);
			map.put("code", 200);
			map.put("msg", "上传WEB浏览测试数据成功");
			map.put("resp", "");
		} catch (JSONException e) {
			map.put("code", 100);
			map.put("msg", "上传WEB浏览测试数据失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			map.put("code", 100);
			map.put("msg", "上传WEB浏览测试数据失败" + e.getMessage());
			map.put("resp", "");
		} catch (ParseException e) {
			e.printStackTrace();
			map.put("code", 100);
			map.put("msg", "上传WEB浏览测试数据失败" + e.getMessage());
			map.put("resp", "");
		}

		return map;
	}

	/**
	 * 上传TRACE路由测试测试数据
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/UpTraceRouteTest")
	@ResponseBody
	public Map<String, Object> UpTraceRouteTest(HttpServletRequest request) {
		map = new HashMap<String, Object>();
		try {
			String params = request.getParameter("params");
			JSONArray ja=new JSONArray(params);
			JSONObject jo = new JSONObject();
			String traceRouteTime = "";
			String traceRouteUrl = "";
			String traceRouteTimeOut = "";
			String traceRoutePostPacketLoss = "";
			String appId = "";
			String userId = "";
			String userPhone = "";
			String areaId = "";
			String channelNote = "";
			String packageInfo = "";// 键值对{a,b,c}${a,b,c}
			String[] arrtime = {};
			String[] arrurl = {};
			String[] arrtimeout = {};
			String[] arrloss = {};
			String[] arrinfo = {};
			List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
			Map<String,Object> mymap=null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
			for(int i=0;i<ja.length();i++){
				jo=ja.getJSONObject(i);
				traceRouteTime = jo.getString("traceRouteTime");
				traceRouteUrl = jo.getString("traceRouteUrl");
				traceRouteTimeOut = jo.getString("traceRouteTimeOut");
				traceRoutePostPacketLoss = jo.getString("traceRoutePostPacketLoss");
				appId = jo.getString("appId");
				userId = jo.getString("userId");
				userPhone = jo.getString("userPhone");
				areaId = jo.getString("areaId");
				channelNote = jo.getString("channelNote");
				packageInfo = jo.getString("packageInfo");// 键值对{a,b,c}${a,b,c}
				arrtime=traceRouteTime.split("\\$\\$");
				arrurl=traceRouteUrl.split("\\$\\$");
				arrtimeout=traceRouteTimeOut.split("\\$\\$");
				arrloss=traceRoutePostPacketLoss.split("\\$\\$");
				arrinfo=packageInfo.split("\\$\\$");

				for(int ii=0;ii<arrtime.length;ii++){
					mymap=new HashMap<String, Object>();
					mymap.put("traceRouteID", UUID.randomUUID().toString());
					mymap.put("traceRouteTime", sdf.parse(sdf.format(Long.valueOf(arrtime[ii]))));
					mymap.put("traceRouteUrl", arrurl[ii]);
					mymap.put("traceRouteTimeOut", Long.valueOf(arrtimeout[ii]));
					mymap.put("traceRoutePostPacketLoss", Long.valueOf(arrloss[ii]));
					mymap.put("appId", appId);
					mymap.put("userId", userId);
					mymap.put("userPhone", userPhone);
					mymap.put("areaId", areaId);
					mymap.put("channelNote", channelNote);
					mymap.put("routePass", arrinfo[ii]);
					list.add(mymap);
				}
			}
			tracerouteservice.insertMany(list);
			map.put("code", 200);
			map.put("msg", "上传TRACE路由测试测试数据成功");
			map.put("resp", "");
		} catch (JSONException e) {
			map.put("code", 100);
			map.put("msg", "上传TRACE路由测试测试数据失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			map.put("code", 100);
			map.put("msg", "上传TRACE路由测试测试数据失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		} catch (ParseException e) {
			map.put("code", 100);
			map.put("msg", "上传TRACE路由测试测试数据失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}
		return map;
	}

//--------------------------------------修改
	/**
	 * 上传网络测速测试数据
	 * 修改 测试 zx
	 * @param request
	 * @return
	 */
	@RequestMapping("/UpNetWorkSpeedTest")
	@ResponseBody
	public Map<String, Object> test(HttpServletRequest request) {
		map = new HashMap<String, Object>();
		try {
			String params = request.getParameter("params");
			System.out.println(params);
			JSONArray ja=new JSONArray(params);
			JSONObject jo = new JSONObject();
			String networkConnectionPacketLoss = "";
			String networkSpeedTimeOut = "";
			String networkSpeedUploadSpeed = "";
			String networkConnectionShake = "";
			String networkSpeedTime="";
			String appId = "";
			String userId = "";
			String userPhone = "";
			String areaId = "";
			String channelNote = "";
			String[] arrserver={};
			String[] arrtimeout={};
			String[] arrupload={};
			String[] arrnode={};
			String[] arrtime={};

			List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
			Map<String,Object> mymap=null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
			for(int i=0;i<ja.length();i++){
				jo=ja.getJSONObject(i);
				networkConnectionPacketLoss = jo.getString("networkConnectionPacketLoss");   //改  丢包率
				networkSpeedTimeOut = jo.getString("networkSpeedTimeOut");
				networkSpeedUploadSpeed = jo.getString("networkSpeedUploadSpeed");
				networkConnectionShake = jo.getString("networkConnectionShake");   //改 抖动
				networkSpeedTime=jo.getString("networkSpeedTime");
				appId = jo.getString("appId");
				userId = jo.getString("userId");
				userPhone = jo.getString("userPhone");
				areaId = jo.getString("areaId");
				channelNote = jo.getString("channelNote");
				arrserver=networkConnectionPacketLoss.split("\\$\\$");
				arrtimeout=networkSpeedTimeOut.split("\\$\\$");
				if (arrtimeout.length == 1){
					arrtimeout =new String[] {arrtimeout[0],"0"};
				}
				arrupload=networkSpeedUploadSpeed.split("\\$\\$");
				if (arrupload.length == 1){
					arrupload =new String[] {arrupload[0],"0"};
				}
				arrnode=networkConnectionShake.split("\\$\\$");
				if (arrnode.length == 1){
					arrnode =new String[] {arrnode[0],"0"};
				}
				arrtime=networkSpeedTime.split("\\$\\$");

				for(int ii=0;ii<arrtime.length;ii++){
					mymap=new HashMap<String, Object>();
					mymap.put("networkSpeedID", UUID.randomUUID().toString());
					mymap.put("networkConnectionPacketLoss", arrserver[ii]);
					mymap.put("networkSpeedTimeOut", Double.valueOf(arrtimeout[ii]));
					mymap.put("networkSpeedUploadSpeed", arrupload[ii]);
					mymap.put("networkConnectionShake", arrnode[ii]);
					mymap.put("networkSpeedTime", sdf.parse(sdf.format(Long.valueOf(arrtime[ii]))));
					mymap.put("appId", appId);
					mymap.put("userId", userId);
					mymap.put("userPhone", userPhone);
					mymap.put("areaId", areaId);
					mymap.put("channelNote", channelNote);
					list.add(mymap);
				}
			}

			networkspeedservice.insertMany(list);
			map.put("code", 200);
			map.put("msg", "上传网络测速测试数据成功");
			map.put("resp", "");
		} catch (JSONException e) {
			map.put("code", 100);
			map.put("msg", "上传网络测速测试数据失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			map.put("code", 101);
			map.put("msg", "上传网络测速测试数据失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		} catch (ParseException e) {
			map.put("code", 102);
			map.put("msg", "上传网络测速测试数据失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}catch (Exception e) {
			map.put("code", 103);
			map.put("msg", "上传网络测速测试数据失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}
		return map;
	}


//	/**
//	 * 上传网络测速测试数据
//	 * 修改 zx
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping("/UpNetWorkSpeedTest")
//	@ResponseBody
//	public Map<String, Object> UpNetWorkSpeedTest(HttpServletRequest request) {
//		map = new HashMap<String, Object>();
//		try {
//			String params = request.getParameter("params");
//			System.out.println(params);
//			JSONArray ja=new JSONArray(params);
//			JSONObject jo = new JSONObject();
//			String networkConnectionPacketLoss = "";
//			String networkSpeedTimeOut = "";
//			String networkSpeedUploadSpeed = "";
//			String networkConnectionShake = "";
//			String networkSpeedTime="";
//			String appId = "";
//			String userId = "";
//			String userPhone = "";
//			String areaId = "";
//			String channelNote = "";
//			String[] arrserver={};
//			String[] arrtimeout={};
//			String[] arrupload={};
//			String[] arrnode={};
//			String[] arrtime={};
//
//			List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
//			Map<String,Object> mymap=null;
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
//			for(int i=0;i<ja.length();i++){
//				jo=ja.getJSONObject(i);
//				networkConnectionPacketLoss = jo.getString("networkConnectionPacketLoss");   //改  丢包率
//				networkSpeedTimeOut = jo.getString("networkSpeedTimeOut");
//				networkSpeedUploadSpeed = jo.getString("networkSpeedUploadSpeed");
//				networkConnectionShake = jo.getString("networkConnectionShake");   //改 抖动
//				networkSpeedTime=jo.getString("networkSpeedTime");
//				appId = jo.getString("appId");
//				userId = jo.getString("userId");
//				userPhone = jo.getString("userPhone");
//				areaId = jo.getString("areaId");
//				channelNote = jo.getString("channelNote");
//				arrserver=networkConnectionPacketLoss.split("\\$\\$");
//				arrtimeout=networkSpeedTimeOut.split("\\$\\$");
//
//				arrupload=networkSpeedUploadSpeed.split("\\$\\$");
//
//				arrnode=networkConnectionShake.split("\\$\\$");
//				arrtime=networkSpeedTime.split("\\$\\$");
//				System.out.println("arrserver.length的长度"+arrserver.length);
//
//					mymap=new HashMap<String, Object>();
//					mymap.put("networkSpeedID", UUID.randomUUID().toString());
//					mymap.put("networkConnectionPacketLoss", arrserver[0]);
//					System.out.println("399"+arrtimeout[0]);
//
//
//
//					mymap.put("networkSpeedTimeOut", Double.valueOf(arrtimeout[0]));
//					mymap.put("networkSpeedUploadSpeed", arrupload[0]);
//					mymap.put("networkConnectionShake", arrnode[0]);
//					mymap.put("networkSpeedTime", sdf.parse(sdf.format(Long.valueOf(arrtime[0]))));
//					mymap.put("appId", appId);
//					mymap.put("userId", userId);
//					mymap.put("userPhone", userPhone);
//					mymap.put("areaId", areaId);
//					mymap.put("channelNote", channelNote);
//					list.add(mymap);
//				}
//
////			System.out.println(list);
//
//			networkspeedservice.insertMany(list);
//			map.put("code", 200);
//			map.put("msg", "上传网络测速测试数据成功");
//			map.put("resp", "");
//		} catch (JSONException e) {
//			map.put("code", 100);
//			map.put("msg", "上传网络测速测试数据失败" + e.getMessage());
//			map.put("resp", "");
//			e.printStackTrace();
//		} catch (NumberFormatException e) {
//			map.put("code", 101);
//			map.put("msg", "上传网络测速测试数据失败" + e.getMessage());
//			map.put("resp", "");
//			e.printStackTrace();
//		} catch (ParseException e) {
//			map.put("code", 102);
//			map.put("msg", "上传网络测速测试数据失败" + e.getMessage());
//			map.put("resp", "");
//			e.printStackTrace();
//		}catch (Exception e) {
//			map.put("code", 103);
//			map.put("msg", "上传网络测速测试数据失败" + e.getMessage());
//			map.put("resp", "");
//			e.printStackTrace();
//		}
//		return map;
//	}

	/**
	 * 上传网络测速测试数据
	 * 修改
	 * @param request
	 * @return
	 */
//	@RequestMapping("/UpNetWorkSpeedTest")
//	@ResponseBody
//	public Map<String, Object> UpNetWorkSpeedTest(HttpServletRequest request) {
//		map = new HashMap<String, Object>();
//		try {
//			String params = request.getParameter("params");
//			System.out.println(params);
//			JSONArray ja=new JSONArray(params);
//			JSONObject jo = new JSONObject();
//			String networkConnectionPacketLoss = "";
//			String networkSpeedTimeOut = "";
//			String networkSpeedUploadSpeed = "";
//			String networkConnectionShake = "";
//			String networkSpeedTime="";
//			String appId = "";
//			String userId = "";
//			String userPhone = "";
//			String areaId = "";
//			String channelNote = "";
//			String[] arrserver={};
//			String[] arrtimeout={};
//			String[] arrupload={};
//			String[] arrnode={};
//			String[] arrtime={};
//
//			List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
//			Map<String,Object> mymap=null;
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
//			for(int i=0;i<ja.length();i++){
//				jo=ja.getJSONObject(i);
//				networkConnectionPacketLoss = jo.getString("networkConnectionPacketLoss");   //改  丢包率
//				networkSpeedTimeOut = jo.getString("networkSpeedTimeOut");
//				networkSpeedUploadSpeed = jo.getString("networkSpeedUploadSpeed");
//				networkConnectionShake = jo.getString("networkConnectionShake");   //改 抖动
//				networkSpeedTime=jo.getString("networkSpeedTime");
//				appId = jo.getString("appId");
//				userId = jo.getString("userId");
//				userPhone = jo.getString("userPhone");
//				areaId = jo.getString("areaId");
//				channelNote = jo.getString("channelNote");
//				arrserver=networkConnectionPacketLoss.split("\\$\\$");
//				arrtimeout=networkSpeedTimeOut.split("\\$\\$");
//
//				arrupload=networkSpeedUploadSpeed.split("\\$\\$");
//
//				arrnode=networkConnectionShake.split("\\$\\$");
//				arrtime=networkSpeedTime.split("\\$\\$");
//				System.out.println("arrserver.length的长度"+arrserver.length);
//				for(int ii=0;ii<arrtime.length;ii++){
//					mymap=new HashMap<String, Object>();
//					mymap.put("networkSpeedID", UUID.randomUUID().toString());
//					mymap.put("networkConnectionPacketLoss", arrserver[ii]);
//					System.out.println("399"+arrtimeout[ii]);
//
//
//
//					mymap.put("networkSpeedTimeOut", Double.valueOf(arrtimeout[ii]));
//					mymap.put("networkSpeedUploadSpeed", arrupload[ii]);
//					mymap.put("networkConnectionShake", arrnode[ii]);
//					mymap.put("networkSpeedTime", sdf.parse(sdf.format(Long.valueOf(arrtime[ii]))));
//					mymap.put("appId", appId);
//					mymap.put("userId", userId);
//					mymap.put("userPhone", userPhone);
//					mymap.put("areaId", areaId);
//					mymap.put("channelNote", channelNote);
//					list.add(mymap);
//				}
//			}
//
////			System.out.println(list);
//
//			networkspeedservice.insertMany(list);
//			map.put("code", 200);
//			map.put("msg", "上传网络测速测试数据成功");
//			map.put("resp", "");
//		} catch (JSONException e) {
//			map.put("code", 100);
//			map.put("msg", "上传网络测速测试数据失败" + e.getMessage());
//			map.put("resp", "");
//			e.printStackTrace();
//		} catch (NumberFormatException e) {
//			map.put("code", 101);
//			map.put("msg", "上传网络测速测试数据失败" + e.getMessage());
//			map.put("resp", "");
//			e.printStackTrace();
//		} catch (ParseException e) {
//			map.put("code", 102);
//			map.put("msg", "上传网络测速测试数据失败" + e.getMessage());
//			map.put("resp", "");
//			e.printStackTrace();
//		}catch (Exception e) {
//			map.put("code", 103);
//			map.put("msg", "上传网络测速测试数据失败" + e.getMessage());
//			map.put("resp", "");
//			e.printStackTrace();
//		}
//		return map;
//	}

	/**
	 * 一键诊断
	 *
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/OneKeyTest")
	@ResponseBody
	public Map<String, Object> oneKeyTest(HttpServletRequest request) {
		log.info("672");
		map = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> listping=new ArrayList<Map<String,Object>>();
			List<Map<String, Object>> listhttp=new ArrayList<Map<String,Object>>();
			List<Map<String, Object>> listtrace=new ArrayList<Map<String,Object>>();
			List<Map<String, Object>> listdownload=new ArrayList<Map<String,Object>>();
//			因为安卓只能传params 所以需要进行判断
			String params = request.getParameter("params");
			String params1 = null ;
			String params2 = null ;
			String params4 = null;
			log.info(params);
			// ping
			JSONArray ja = null;
			JSONObject jo = new JSONObject();
			if (params !=null){
			    ja = new JSONArray(params);
                JSONObject jc =ja.getJSONObject(0);
                params1 =jc.getString("params1");
                params2 =jc.getString("params2");
                params4 =jc.getString("params4");
                log.info(params4);
			}else {
				 params1 = request.getParameter("params1");
				params2 = request.getParameter("params2");
				params4 = request.getParameter("params4");
			}
			ja = new JSONArray(params1);

			String networkConnectivityTime = "";
			String networkConnectivityUrl = "";
			String networkConnectionTimeOut = "";
			String networkConnectionPacketLoss = "";
			String networkConnectionShake = "";
			String appId = "";
			String userId = "";
			String userPhone = "";
			String areaId = "";
			String channelNote = "";
			String[] arrtimeout={};
			String[] arrpacketloss={};
			String[] arrshake={};
			String[] arrurl={};
			String[] arrtime={};
			t_networkconnectivity demo = new t_networkconnectivity();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
			List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
			log.info("700这里");
			Map<String,Object> mymap=null;
			for (int i = 0; i < ja.length(); i++) {
				jo = ja.getJSONObject(i);
				networkConnectivityTime = jo.getString("networkConnectivityTime");
				networkConnectivityUrl = jo.getString("networkConnectivityUrl");
				networkConnectionTimeOut = jo.getString("networkConnectionTimeOut");
				networkConnectionPacketLoss = jo.getString("networkConnectionPacketLoss");
				networkConnectionShake = jo.getString("networkConnectionShake");
				appId = jo.getString("appId");
				userId = jo.getString("userId");
				userPhone = jo.getString("userPhone");
				areaId = jo.getString("areaId");
				channelNote = jo.getString("channelNote");

				arrtimeout = networkConnectionTimeOut.split("\\$\\$");
				arrpacketloss = networkConnectionPacketLoss.split("\\$\\$");
				arrshake = networkConnectionShake.split("\\$\\$");
				arrurl = networkConnectivityUrl.split("\\$\\$");
				arrtime = networkConnectivityTime.split("\\$\\$");
				for (int ii = 0; ii < arrpacketloss.length; ii++) {
					mymap = new HashMap<String, Object>();
					mymap.put("networkConnectivityID", UUID.randomUUID().toString());
					mymap.put("networkConnectivityTime", sdf.parse(sdf.format(Long.valueOf(arrtime[ii]))));
					mymap.put("networkConnectivityUrl", arrurl[ii]);
					mymap.put("networkConnectionTimeOut", arrtimeout[ii]);
					mymap.put("networkConnectionPacketLoss", arrpacketloss[ii]);
					mymap.put("networkConnectionShake", arrshake[ii]);
					mymap.put("appId", appId);
					mymap.put("userId", userId);
					mymap.put("userPhone", userPhone);
					mymap.put("areaId", areaId);
					mymap.put("channelNote", channelNote);
					list.add(mymap);
				}
				log.info("735这里");
				/*
				// ping
				demo.setAppid(appId);
				demo.setAreaid(areaId);
				demo.setChannelnote(channelNote);
				demo.setNetworkconnectionpacketloss(networkConnectionPacketLoss);
				demo.setNetworkconnectionshake(networkConnectionShake);
				demo.setNetworkconnectiontimeout(Long.valueOf(networkConnectionTimeOut));
				demo.setNetworkconnectivityid(UUID.randomUUID().toString());
				demo.setNetworkconnectivitytime(sdf.parse(sdf.format(Long.valueOf(networkConnectivityTime))));
				demo.setNetworkconnectivityurl(networkConnectivityUrl);
				demo.setUserid(userId);
				demo.setUserphone(userPhone);
				networkconnectivityservice.insertSelective(demo);*/
			}
			listping=list;

			// http
			list=new ArrayList<Map<String,Object>>();
			ja = new JSONArray(params2);
			String webThroughTime = "";
			String webThroughUrl = "";
			String webThroughDNS = "";
			String webThroughTimeOut = "";
			String webThroughFirstByteTimeOut = "";
			String webThroughUploadFileTimeOut = "";
			String webThroughUploadSpeed = "";
			String webThroughDNSTime="";
			t_webthrough wdemo = new t_webthrough();
			String[] arrdnstime={};
			String[] arrdns={};
			String[] arrfirsttimeout={};
			String[] arrfiletimeout={};
			String[] arrspeed={};
			log.info("771这里");
			for (int i = 0; i < ja.length(); i++) {
				jo = ja.getJSONObject(i);
				webThroughTime = jo.getString("webThroughTime");
				webThroughUrl = jo.getString("webThroughUrl");
				webThroughDNS = jo.getString("webThroughDNS");
				webThroughTimeOut = jo.getString("webThroughTimeOut");
				webThroughFirstByteTimeOut = jo.getString("webThroughFirstByteTimeOut");
				webThroughUploadFileTimeOut = jo.getString("webThroughUploadFileTimeOut");
				webThroughUploadSpeed = jo.getString("webThroughUploadSpeed");
				webThroughDNSTime=jo.getString("webThroughDNSTime");
				arrdnstime = webThroughDNSTime.split("\\$\\$");
				arrdns = webThroughDNS.split("\\$\\$");
				arrtimeout = webThroughTimeOut.split("\\$\\$");
				arrfirsttimeout = webThroughFirstByteTimeOut.split("\\$\\$");
				arrfiletimeout = webThroughUploadFileTimeOut.split("\\$\\$");
				arrspeed = webThroughUploadSpeed.split("\\$\\$");
				arrurl=webThroughUrl.split("\\$\\$");
				arrtime=webThroughTime.split("\\$\\$");
				for (int ii = 0; ii < arrdnstime.length; ii++) {
					mymap = new HashMap<String, Object>();
					mymap.put("webthroughid", UUID.randomUUID().toString().replaceAll("-", ""));
					mymap.put("webthroughtime", sdf.parse(sdf.format(Long.valueOf(arrtime[ii]))));
					mymap.put("webthroughurl", arrurl[ii]);
					mymap.put("webthroughdns", arrdns[ii]);
					mymap.put("webthroughtimeout", new Long(new Double(Double.parseDouble(arrtimeout[ii])).longValue()));
					mymap.put("webthroughfirstbytetimeout",
							new Long(new Double(Double.parseDouble(arrfirsttimeout[ii])).longValue()));
					mymap.put("webthroughuploadfiletimeout",
							new Long(new Double(Double.parseDouble(arrfiletimeout[ii])).longValue()));
					mymap.put("webthroughuploadspeed",
							new Long(new Double(Double.parseDouble(arrspeed[ii])).longValue()));
					mymap.put("appid", appId);
					mymap.put("userid", userId);
					mymap.put("userphone", userPhone);
					mymap.put("areaid", areaId);
					mymap.put("channelnote", channelNote);
					mymap.put("webthroughdnstime", arrdnstime[ii]);
					list.add(mymap);
				}

				log.info("812这里");
				// http
			/*	wdemo.setAppid(appId);
				wdemo.setAreaid(areaId);
				wdemo.setChannelnote(channelNote);
				wdemo.setUserid(userId);
				wdemo.setUserphone(userPhone);
				wdemo.setWebthroughdns(webThroughDNS);
				wdemo.setWebthroughfirstbytetimeout(
						new Long(new Double(Double.parseDouble(webThroughFirstByteTimeOut)).longValue()));
				wdemo.setWebthroughid(UUID.randomUUID().toString());
				wdemo.setWebthroughtime(sdf.parse(sdf.format(Long.valueOf(webThroughTime))));
				wdemo.setWebthroughtimeout(new Long(new Double(Double.parseDouble(webThroughTimeOut)).longValue()));
				wdemo.setWebthroughuploadfiletimeout(
						new Long(new Double(Double.parseDouble(webThroughUploadFileTimeOut)).longValue()));
				wdemo.setWebthroughuploadspeed(
						new Long(new Double(Double.parseDouble(webThroughUploadSpeed)).longValue()));
				wdemo.setWebthroughurl(webThroughUrl);
				webthroughservice.insertSelective(wdemo);*/
			}
			listhttp=list;

			// trace
//			list=new ArrayList<Map<String,Object>>();
//			String params3 = request.getParameter("params3");
//			ja = new JSONArray(params3);
//			String traceRouteTime = "";
//			String traceRouteUrl = "";
//			String traceRouteTimeOut = "";
//			String traceRoutePostPacketLoss = "";
//			String packageInfo = "";// 键值对{a,b,c}${a,b,c}
//			String[] arrloss={};
//			String[] arrinfo={};
//			t_traceroute traceDEMO = new t_traceroute();
//			for (int i = 0; i < ja.length(); i++) {
//				jo = ja.getJSONObject(i);
//				traceRouteTime = jo.getString("traceRouteTime");
//				traceRouteUrl = jo.getString("traceRouteUrl");
//				traceRouteTimeOut = jo.getString("traceRouteTimeOut");
//				traceRoutePostPacketLoss = jo.getString("traceRoutePostPacketLoss");
//				packageInfo = jo.getString("packageInfo");// 键值对{a,b,c}${a,b,c}
//				arrtime=traceRouteTime.split("\\$\\$");
//				arrurl=traceRouteUrl.split("\\$\\$");
//				arrtimeout=traceRouteTimeOut.split("\\$\\$");
//				arrloss=traceRoutePostPacketLoss.split("\\$\\$");
//				arrinfo=packageInfo.split("\\$\\$");
//				for(int ii=0;ii<arrtime.length;ii++){
//					mymap=new HashMap<String, Object>();
//					mymap.put("traceRouteID", UUID.randomUUID().toString());
//					mymap.put("traceRouteTime", sdf.parse(sdf.format(Long.valueOf(arrtime[ii]))));
//					mymap.put("traceRouteUrl", arrurl[ii]);
//					mymap.put("traceRouteTimeOut", Long.valueOf(arrtimeout[ii]));
//					mymap.put("traceRoutePostPacketLoss", Long.valueOf(arrloss[ii]));
//					mymap.put("appId", appId);
//					mymap.put("userId", userId);
//					mymap.put("userPhone", userPhone);
//					mymap.put("areaId", areaId);
//					mymap.put("channelNote", channelNote);
//					mymap.put("routePass", arrinfo[ii]);
//					list.add(mymap);
//				}

				/*// trace

				traceDEMO.setAppid(appId);
				traceDEMO.setAreaid(areaId);
				traceDEMO.setChannelnote(channelNote);
				traceDEMO.setUserid(userId);
				traceDEMO.setUserphone(userPhone);
				traceDEMO.setTracerouteid(UUID.randomUUID().toString());
				traceDEMO.setTraceroutepostpacketloss(Long.valueOf(traceRoutePostPacketLoss));
				traceDEMO.setTraceroutetime(sdf.parse(sdf.format(Long.valueOf(traceRouteTime))));
				traceDEMO.setTraceroutetimeout(Long.valueOf(traceRouteTimeOut));
				traceDEMO.setTracerouteurl(traceRouteUrl);
				traceDEMO.setRoutepass(packageInfo);
				tracerouteservice.insertSelective(traceDEMO);*/

//			}
//			listtrace=list;
			log.info("891这里");
			// download
			list=new ArrayList<Map<String,Object>>();
			ja = new JSONArray(params4);
			String networkSpeedServer = "";
			String networkSpeedTimeOut = "";
			String networkSpeedUploadSpeed = "";
			String networkSpeedNode = "";
			String networkSpeedTime="";
			t_networkspeed speedDEMO = new t_networkspeed();
			String[] arrserver={};
			String[] arrupload={};
			String[] arrnode={};
			for (int i = 0; i < ja.length(); i++) {
				jo = ja.getJSONObject(i);
				networkConnectionPacketLoss = jo.getString("networkConnectionPacketLoss");   //改  丢包率
				networkSpeedTimeOut = jo.getString("networkSpeedTimeOut");
				networkSpeedUploadSpeed = jo.getString("networkSpeedUploadSpeed");
				networkConnectionShake = jo.getString("networkConnectionShake");   //改 抖动
				networkSpeedTime=jo.getString("networkSpeedTime");
				appId = jo.getString("appId");
				userId = jo.getString("userId");
				userPhone = jo.getString("userPhone");
				areaId = jo.getString("areaId");
				channelNote = jo.getString("channelNote");
				arrserver=networkConnectionPacketLoss.split("\\$\\$");
				arrtimeout=networkSpeedTimeOut.split("\\$\\$");
				if (arrtimeout.length == 1){
					arrtimeout =new String[] {arrtimeout[0],"0"};
				}
				arrupload=networkSpeedUploadSpeed.split("\\$\\$");
				if (arrupload.length == 1){
					arrupload =new String[] {arrupload[0],"0"};
				}
				arrnode=networkConnectionShake.split("\\$\\$");
				if (arrnode.length == 1){
					arrnode =new String[] {arrnode[0],"0"};
				}
				arrtime=networkSpeedTime.split("\\$\\$");
				log.info("931这里");

				for(int ii=0;ii<arrtime.length;ii++){
					mymap=new HashMap<String, Object>();
					mymap.put("networkSpeedID", UUID.randomUUID().toString());
					mymap.put("networkConnectionPacketLoss", arrserver[ii]);
					mymap.put("networkSpeedTimeOut", Double.valueOf(arrtimeout[ii]));
					mymap.put("networkSpeedUploadSpeed", arrupload[ii]);
					mymap.put("networkConnectionShake", arrnode[ii]);
					mymap.put("networkSpeedTime", sdf.parse(sdf.format(Long.valueOf(arrtime[ii]))));
					mymap.put("appId", appId);
					mymap.put("userId", userId);
					mymap.put("userPhone", userPhone);
					mymap.put("areaId", areaId);
					mymap.put("channelNote", channelNote);
					list.add(mymap);
				}
				/*// download
				speedDEMO.setAppid(appId);
				speedDEMO.setAreaid(areaId);
				speedDEMO.setChannelnote(channelNote);
				speedDEMO.setNetworkspeedid(UUID.randomUUID().toString());
				speedDEMO.setNetworkspeednode(networkSpeedNode);
				speedDEMO.setNetworkspeedserver(networkSpeedServer);
				speedDEMO.setNetworkspeedtime(new Date());
				speedDEMO.setNetworkspeedtimeout(Long.valueOf(networkSpeedTimeOut));
				speedDEMO.setNetworkspeeduploadspeed(networkSpeedUploadSpeed);
				speedDEMO.setUserid(userId);
				speedDEMO.setUserphone(userPhone);
				networkspeedservice.insertSelective(speedDEMO);*/
			}
			log.info("962这里");
			listdownload=list;
			networkconnectivityservice.insertMany(listping);
			webthroughservice.insertMany(listhttp);
//			tracerouteservice.insertMany(listtrace);
			networkspeedservice.insertMany(listdownload);
			map.put("code", 200);
			map.put("msg", "上传一键测试数据成功");
			map.put("resp", "");
			log.info("971这里");
		} catch (NumberFormatException e) {
			map.put("code", 100);
			map.put("msg", "上传一键测试数据失败NumberFormatException" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		} catch (JSONException e) {
			map.put("code", 100);
			map.put("msg", "上传一键测试数据失败JSONException" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		} catch (ParseException e) {
			map.put("code", 100);
			map.put("msg", "上传一键测试数据失败ParseException" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}
		log.info("988这里");
		return map;
	}


	/**
	 * 一键诊断
	 *
	 * @param request
	 * @return
	 * @throws ParseException
	 */
//	@RequestMapping("/OneKeyTest")
//	@ResponseBody
//	public Map<String, Object> oneKeyTest(HttpServletRequest request) {
//		map = new HashMap<String, Object>();
//		try {
//			List<Map<String, Object>> listping=new ArrayList<Map<String,Object>>();
//			List<Map<String, Object>> listhttp=new ArrayList<Map<String,Object>>();
//			List<Map<String, Object>> listtrace=new ArrayList<Map<String,Object>>();
//			List<Map<String, Object>> listdownload=new ArrayList<Map<String,Object>>();
//			// ping
//			String params1 = request.getParameter("params1");
//			JSONArray ja = new JSONArray(params1);
//			JSONObject jo = new JSONObject();
//			String networkConnectivityTime = "";
//			String networkConnectivityUrl = "";
//			String networkConnectionTimeOut = "";
//			String networkConnectionPacketLoss = "";
//			String networkConnectionShake = "";
//			String appId = "";
//			String userId = "";
//			String userPhone = "";
//			String areaId = "";
//			String channelNote = "";
//			String[] arrtimeout={};
//			String[] arrpacketloss={};
//			String[] arrshake={};
//			String[] arrurl={};
//			String[] arrtime={};
//			t_networkconnectivity demo = new t_networkconnectivity();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
//			List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
//			Map<String,Object> mymap=null;
//			for (int i = 0; i < ja.length(); i++) {
//				jo = ja.getJSONObject(i);
//				networkConnectivityTime = jo.getString("networkConnectivityTime");
//				networkConnectivityUrl = jo.getString("networkConnectivityUrl");
//				networkConnectionTimeOut = jo.getString("networkConnectionTimeOut");
//				networkConnectionPacketLoss = jo.getString("networkConnectionPacketLoss");
//				networkConnectionShake = jo.getString("networkConnectionShake");
//				appId = jo.getString("appId");
//				userId = jo.getString("userId");
//				userPhone = jo.getString("userPhone");
//				areaId = jo.getString("areaId");
//				channelNote = jo.getString("channelNote");
//
//				arrtimeout = networkConnectionTimeOut.split("\\$\\$");
//				arrpacketloss = networkConnectionPacketLoss.split("\\$\\$");
//				arrshake = networkConnectionShake.split("\\$\\$");
//				arrurl = networkConnectivityUrl.split("\\$\\$");
//				arrtime = networkConnectivityTime.split("\\$\\$");
//				for (int ii = 0; ii < arrpacketloss.length; ii++) {
//					mymap = new HashMap<String, Object>();
//					mymap.put("networkConnectivityID", UUID.randomUUID().toString());
//					mymap.put("networkConnectivityTime", sdf.parse(sdf.format(Long.valueOf(arrtime[ii]))));
//					mymap.put("networkConnectivityUrl", arrurl[ii]);
//					mymap.put("networkConnectionTimeOut", arrtimeout[ii]);
//					mymap.put("networkConnectionPacketLoss", arrpacketloss[ii]);
//					mymap.put("networkConnectionShake", arrshake[ii]);
//					mymap.put("appId", appId);
//					mymap.put("userId", userId);
//					mymap.put("userPhone", userPhone);
//					mymap.put("areaId", areaId);
//					mymap.put("channelNote", channelNote);
//					list.add(mymap);
//				}
//				/*
//				// ping
//				demo.setAppid(appId);
//				demo.setAreaid(areaId);
//				demo.setChannelnote(channelNote);
//				demo.setNetworkconnectionpacketloss(networkConnectionPacketLoss);
//				demo.setNetworkconnectionshake(networkConnectionShake);
//				demo.setNetworkconnectiontimeout(Long.valueOf(networkConnectionTimeOut));
//				demo.setNetworkconnectivityid(UUID.randomUUID().toString());
//				demo.setNetworkconnectivitytime(sdf.parse(sdf.format(Long.valueOf(networkConnectivityTime))));
//				demo.setNetworkconnectivityurl(networkConnectivityUrl);
//				demo.setUserid(userId);
//				demo.setUserphone(userPhone);
//				networkconnectivityservice.insertSelective(demo);*/
//			}
//			listping=list;
//
//			// http
//			list=new ArrayList<Map<String,Object>>();
//			String params2 = request.getParameter("params2");
//			ja = new JSONArray(params2);
//			String webThroughTime = "";
//			String webThroughUrl = "";
//			String webThroughDNS = "";
//			String webThroughTimeOut = "";
//			String webThroughFirstByteTimeOut = "";
//			String webThroughUploadFileTimeOut = "";
//			String webThroughUploadSpeed = "";
//			String webThroughDNSTime="";
//			t_webthrough wdemo = new t_webthrough();
//			String[] arrdnstime={};
//			String[] arrdns={};
//			String[] arrfirsttimeout={};
//			String[] arrfiletimeout={};
//			String[] arrspeed={};
//			for (int i = 0; i < ja.length(); i++) {
//				jo = ja.getJSONObject(i);
//				webThroughTime = jo.getString("webThroughTime");
//				webThroughUrl = jo.getString("webThroughUrl");
//				webThroughDNS = jo.getString("webThroughDNS");
//				webThroughTimeOut = jo.getString("webThroughTimeOut");
//				webThroughFirstByteTimeOut = jo.getString("webThroughFirstByteTimeOut");
//				webThroughUploadFileTimeOut = jo.getString("webThroughUploadFileTimeOut");
//				webThroughUploadSpeed = jo.getString("webThroughUploadSpeed");
//				webThroughDNSTime=jo.getString("webThroughDNSTime");
//				arrdnstime = webThroughDNSTime.split("\\$\\$");
//				arrdns = webThroughDNS.split("\\$\\$");
//				arrtimeout = webThroughTimeOut.split("\\$\\$");
//				arrfirsttimeout = webThroughFirstByteTimeOut.split("\\$\\$");
//				arrfiletimeout = webThroughUploadFileTimeOut.split("\\$\\$");
//				arrspeed = webThroughUploadSpeed.split("\\$\\$");
//				arrurl=webThroughUrl.split("\\$\\$");
//				arrtime=webThroughTime.split("\\$\\$");
//				for (int ii = 0; ii < arrdnstime.length; ii++) {
//					mymap = new HashMap<String, Object>();
//					mymap.put("webthroughid", UUID.randomUUID().toString().replaceAll("-", ""));
//					mymap.put("webthroughtime", sdf.parse(sdf.format(Long.valueOf(arrtime[ii]))));
//					mymap.put("webthroughurl", arrurl[ii]);
//					mymap.put("webthroughdns", arrdns[ii]);
//					mymap.put("webthroughtimeout", new Long(new Double(Double.parseDouble(arrtimeout[ii])).longValue()));
//					mymap.put("webthroughfirstbytetimeout",
//							new Long(new Double(Double.parseDouble(arrfirsttimeout[ii])).longValue()));
//					mymap.put("webthroughuploadfiletimeout",
//							new Long(new Double(Double.parseDouble(arrfiletimeout[ii])).longValue()));
//					mymap.put("webthroughuploadspeed",
//							new Long(new Double(Double.parseDouble(arrspeed[ii])).longValue()));
//					mymap.put("appid", appId);
//					mymap.put("userid", userId);
//					mymap.put("userphone", userPhone);
//					mymap.put("areaid", areaId);
//					mymap.put("channelnote", channelNote);
//					mymap.put("webthroughdnstime", arrdnstime[ii]);
//					list.add(mymap);
//				}
//
//
//				// http
//			/*	wdemo.setAppid(appId);
//				wdemo.setAreaid(areaId);
//				wdemo.setChannelnote(channelNote);
//				wdemo.setUserid(userId);
//				wdemo.setUserphone(userPhone);
//				wdemo.setWebthroughdns(webThroughDNS);
//				wdemo.setWebthroughfirstbytetimeout(
//						new Long(new Double(Double.parseDouble(webThroughFirstByteTimeOut)).longValue()));
//				wdemo.setWebthroughid(UUID.randomUUID().toString());
//				wdemo.setWebthroughtime(sdf.parse(sdf.format(Long.valueOf(webThroughTime))));
//				wdemo.setWebthroughtimeout(new Long(new Double(Double.parseDouble(webThroughTimeOut)).longValue()));
//				wdemo.setWebthroughuploadfiletimeout(
//						new Long(new Double(Double.parseDouble(webThroughUploadFileTimeOut)).longValue()));
//				wdemo.setWebthroughuploadspeed(
//						new Long(new Double(Double.parseDouble(webThroughUploadSpeed)).longValue()));
//				wdemo.setWebthroughurl(webThroughUrl);
//				webthroughservice.insertSelective(wdemo);*/
//			}
//			listhttp=list;
//
//			// trace
//			list=new ArrayList<Map<String,Object>>();
//			String params3 = request.getParameter("params3");
//			ja = new JSONArray(params3);
//			String traceRouteTime = "";
//			String traceRouteUrl = "";
//			String traceRouteTimeOut = "";
//			String traceRoutePostPacketLoss = "";
//			String packageInfo = "";// 键值对{a,b,c}${a,b,c}
//			String[] arrloss={};
//			String[] arrinfo={};
//			t_traceroute traceDEMO = new t_traceroute();
//			for (int i = 0; i < ja.length(); i++) {
//				jo = ja.getJSONObject(i);
//				traceRouteTime = jo.getString("traceRouteTime");
//				traceRouteUrl = jo.getString("traceRouteUrl");
//				traceRouteTimeOut = jo.getString("traceRouteTimeOut");
//				traceRoutePostPacketLoss = jo.getString("traceRoutePostPacketLoss");
//				packageInfo = jo.getString("packageInfo");// 键值对{a,b,c}${a,b,c}
//				arrtime=traceRouteTime.split("\\$\\$");
//				arrurl=traceRouteUrl.split("\\$\\$");
//				arrtimeout=traceRouteTimeOut.split("\\$\\$");
//				arrloss=traceRoutePostPacketLoss.split("\\$\\$");
//				arrinfo=packageInfo.split("\\$\\$");
//				for(int ii=0;ii<arrtime.length;ii++){
//					mymap=new HashMap<String, Object>();
//					mymap.put("traceRouteID", UUID.randomUUID().toString());
//					mymap.put("traceRouteTime", sdf.parse(sdf.format(Long.valueOf(arrtime[ii]))));
//					mymap.put("traceRouteUrl", arrurl[ii]);
//					mymap.put("traceRouteTimeOut", Long.valueOf(arrtimeout[ii]));
//					mymap.put("traceRoutePostPacketLoss", Long.valueOf(arrloss[ii]));
//					mymap.put("appId", appId);
//					mymap.put("userId", userId);
//					mymap.put("userPhone", userPhone);
//					mymap.put("areaId", areaId);
//					mymap.put("channelNote", channelNote);
//					mymap.put("routePass", arrinfo[ii]);
//					list.add(mymap);
//				}
//
//				/*// trace
//
//				traceDEMO.setAppid(appId);
//				traceDEMO.setAreaid(areaId);
//				traceDEMO.setChannelnote(channelNote);
//				traceDEMO.setUserid(userId);
//				traceDEMO.setUserphone(userPhone);
//				traceDEMO.setTracerouteid(UUID.randomUUID().toString());
//				traceDEMO.setTraceroutepostpacketloss(Long.valueOf(traceRoutePostPacketLoss));
//				traceDEMO.setTraceroutetime(sdf.parse(sdf.format(Long.valueOf(traceRouteTime))));
//				traceDEMO.setTraceroutetimeout(Long.valueOf(traceRouteTimeOut));
//				traceDEMO.setTracerouteurl(traceRouteUrl);
//				traceDEMO.setRoutepass(packageInfo);
//				tracerouteservice.insertSelective(traceDEMO);*/
//
//			}
//			listtrace=list;
//
//			// download
//			list=new ArrayList<Map<String,Object>>();
//			String params4 = request.getParameter("params4");
//			ja = new JSONArray(params4);
//			String networkSpeedServer = "";
//			String networkSpeedTimeOut = "";
//			String networkSpeedUploadSpeed = "";
//			String networkSpeedNode = "";
//			String networkSpeedTime="";
//			t_networkspeed speedDEMO = new t_networkspeed();
//			String[] arrserver={};
//			String[] arrupload={};
//			String[] arrnode={};
//			for (int i = 0; i < ja.length(); i++) {
//				jo = ja.getJSONObject(i);
//				networkSpeedServer = jo.getString("networkSpeedServer");
//				networkSpeedTimeOut = jo.getString("networkSpeedTimeOut");
//				networkSpeedUploadSpeed = jo.getString("networkSpeedUploadSpeed");
//				networkSpeedNode = jo.getString("networkSpeedNode");
//				networkSpeedTime=jo.getString("networkSpeedTime");
//				arrserver=networkSpeedServer.split("\\$\\$");
//				arrtimeout=networkSpeedTimeOut.split("\\$\\$");
//				arrupload=networkSpeedUploadSpeed.split("\\$\\$");
//				arrnode=networkSpeedNode.split("\\$\\$");
//				arrtime=networkSpeedTime.split("\\$\\$");
//				for(int ii=0;ii<arrtime.length;ii++){
//					mymap=new HashMap<String, Object>();
//					mymap.put("networkSpeedID", UUID.randomUUID().toString());
//					mymap.put("networkSpeedServer", arrserver[ii]);
//					mymap.put("networkSpeedTimeOut", Long.valueOf(arrtimeout[ii]));
//					mymap.put("networkSpeedUploadSpeed", arrupload[ii]);
//					mymap.put("networkSpeedNode", arrnode[ii]);
//					mymap.put("networkSpeedTime", sdf.parse(sdf.format(Long.valueOf(arrtime[ii]))));
//					mymap.put("appId", appId);
//					mymap.put("userId", userId);
//					mymap.put("userPhone", userPhone);
//					mymap.put("areaId", areaId);
//					mymap.put("channelNote", channelNote);
//					list.add(mymap);
//				}
//				/*// download
//				speedDEMO.setAppid(appId);
//				speedDEMO.setAreaid(areaId);
//				speedDEMO.setChannelnote(channelNote);
//				speedDEMO.setNetworkspeedid(UUID.randomUUID().toString());
//				speedDEMO.setNetworkspeednode(networkSpeedNode);
//				speedDEMO.setNetworkspeedserver(networkSpeedServer);
//				speedDEMO.setNetworkspeedtime(new Date());
//				speedDEMO.setNetworkspeedtimeout(Long.valueOf(networkSpeedTimeOut));
//				speedDEMO.setNetworkspeeduploadspeed(networkSpeedUploadSpeed);
//				speedDEMO.setUserid(userId);
//				speedDEMO.setUserphone(userPhone);
//				networkspeedservice.insertSelective(speedDEMO);*/
//			}
//			listdownload=list;
//			networkconnectivityservice.insertMany(listping);
//			webthroughservice.insertMany(listhttp);
//			tracerouteservice.insertMany(listtrace);
//			networkspeedservice.insertMany(listdownload);
//			map.put("code", 200);
//			map.put("msg", "上传一键测试数据成功");
//			map.put("resp", "");
//		} catch (NumberFormatException e) {
//			map.put("code", 100);
//			map.put("msg", "上传一键测试数据失败" + e.getMessage());
//			map.put("resp", "");
//			e.printStackTrace();
//		} catch (JSONException e) {
//			map.put("code", 100);
//			map.put("msg", "上传一键测试数据失败" + e.getMessage());
//			map.put("resp", "");
//			e.printStackTrace();
//		} catch (ParseException e) {
//			map.put("code", 100);
//			map.put("msg", "上传一键测试数据失败" + e.getMessage());
//			map.put("resp", "");
//			e.printStackTrace();
//		}
//
//		return map;
//	}

	/**
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/UpNetworkConnectivityTest1")
	@ResponseBody
	public Map<String, Object> upNetworkConnectivityTest1(HttpServletRequest request) {
		map = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			String mydata = request.getParameter("params");
			mydata = mydata.replaceAll("\\{", "").replaceAll("\\}", "");
			String[] listSize = mydata.split(",");// 逗号分隔
			String[] item = null;
			Map<String, Object> mymap = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
			for (int i = 0; i < listSize.length; i++) {
				listSize[i] = listSize[i].replaceAll("\"", "");
				item = listSize[i].split("\\$");
				mymap = new HashMap<String, Object>();
				mymap.put("networkConnectivityID", UUID.randomUUID().toString());
				mymap.put("networkConnectivityTime", sdf.parse(sdf.format(Long.valueOf(item[0]))));
				mymap.put("networkConnectivityUrl", item[1]);
				mymap.put("networkConnectionTimeOut", item[2]);
				mymap.put("networkConnectionPacketLoss", item[3]);
				mymap.put("networkConnectionShake", item[4]);
				mymap.put("appId", item[5]);
				mymap.put("userId", item[6]);
				mymap.put("userPhone", item[7]);
				mymap.put("areaId", item[8]);
				mymap.put("channelNote", item[9]);
				list.add(mymap);
			}
			networkconnectivityservice.insertMany(list);
			map.put("code", 200);
			map.put("msg", "上传网络连通性测试数据成功");
			map.put("resp", "");
		} catch (Exception e) {
			map.put("code", 100);
			map.put("msg", "上传网络连通性测试数据失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * WEB浏览测试（HTTP测试）上传数据
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/UpWebThroughTest1")
	@ResponseBody
	public Map<String, Object> upWebThroughTest1(HttpServletRequest request) {
		map = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			String mydata = request.getParameter("params");
			mydata = mydata.replaceAll("\\{", "").replaceAll("\\}", "");
			String[] listSize = mydata.split(",");// 逗号分隔
			String[] item = null;
			Map<String, Object> mymap = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
			for (int i = 0; i < listSize.length; i++) {
				listSize[i] = listSize[i].replaceAll("\"", "");
				item = listSize[i].split("\\$");
				mymap = new HashMap<String, Object>();
				mymap.put("traceRouteID", UUID.randomUUID().toString());
				mymap.put("traceRouteTime", sdf.parse(sdf.format(Long.valueOf(item[0]))));
				mymap.put("traceRouteUrl", item[1]);
				mymap.put("traceRouteTimeOut", item[2]);
				mymap.put("traceRoutePacketLoss", item[3]);
				mymap.put("appId", item[4]);
				mymap.put("userId", item[5]);
				mymap.put("userPhone", item[6]);
				mymap.put("areaId", item[7]);
				mymap.put("channelNote", item[8]);
				list.add(mymap);
			}
			// webthroughservice.insertMany(list);
			map.put("code", 200);
			map.put("msg", "上传WEB浏览测试数据成功");
			map.put("resp", "");
		} catch (Exception e) {
			map.put("code", 100);
			map.put("msg", "上传WEB浏览测试数据失败" + e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}

		return map;
	}

}
