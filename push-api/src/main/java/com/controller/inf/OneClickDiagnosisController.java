package com.controller.inf;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.t_diagnosis;
import com.services.t_diagnosisService;



/**
 * 一键诊断
 * @author admin
 *
 */
@Controller
@RequestMapping("/OneClickDiagnosis")
public class OneClickDiagnosisController {
	
	@Resource
	t_diagnosisService diagnosisservice;
	
	Map<String,Object> map=null;
	
	
	/**
	 * 上传一键诊断终端显示信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/UpTerminalDisplayTest")
	@ResponseBody
	public Map<String,Object> UpTerminalDisplayTest(HttpServletRequest request){
		map=new HashMap<String, Object>();
		try {
			String params=request.getParameter("params");
			JSONObject jo=new JSONObject(params);
			String diagnosisIp=jo.getString("diagnosisIp");
			String diagnosisGetway=jo.getString("diagnosisGetway");
			String diagnosisDNS=jo.getString("diagnosisDNS");
			String diagnosisCPU=jo.getString("diagnosisCPU");
			String diagnosisMemory=jo.getString("diagnosisMemory");
			t_diagnosis diagnosisDEMO=new t_diagnosis();
			diagnosisDEMO.setDiagnosiscpu(diagnosisCPU);
			diagnosisDEMO.setDiagnosisdns(diagnosisDNS);
			diagnosisDEMO.setDiagnosisgetway(diagnosisGetway);
			diagnosisDEMO.setDiagnosisid(UUID.randomUUID().toString());
			diagnosisDEMO.setDiagnosisip(diagnosisIp);
			diagnosisDEMO.setDiagnosismemory(diagnosisMemory);
			diagnosisservice.insertSelective(diagnosisDEMO);
			map.put("code", 200);
			map.put("msg", "上传一键诊断终端显示信息成功");
			map.put("resp", "");
		} catch (JSONException e) {
			e.printStackTrace();
			map.put("code", 100);
			map.put("msg", "上传一键诊断终端显示信息失败"+e.getMessage());
			map.put("resp", "");
		}
		return map;
	}
	

}
