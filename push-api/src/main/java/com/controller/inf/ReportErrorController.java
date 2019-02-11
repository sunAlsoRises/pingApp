package com.controller.inf;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cn.jpush.api.push.PushResult;
import com.util.JiGuangPush;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.model.User;
import com.model.t_reportError;
import com.model.t_user;
import com.services.UserService;
import com.services.t_reportErrorService;
import com.services.t_userService;

import commonSources.ResultPojo;
import commonSources.ResultSuccessOrError;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/Report")
public class ReportErrorController {
    private static final Logger log = LoggerFactory.getLogger(Class.class);
    @Resource
    private t_reportErrorService reporterrorservice;
    @Resource
    private t_userService userservice;
    /**
     * 获取历史保障信息
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/getErrorList")
    public Map<String, Object> getErrorList(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String params = request.getParameter("params");
            JSONObject jo = new JSONObject(params);
            String userid = jo.getString("userid");
            int pagestart = jo.getInt("pagestart");
            List<t_reportError> report = reporterrorservice.selectPageBySql(" where reportErrorUserId = '" + userid + "'  ORDER BY reportErrorCreateTime DESC ", 10, pagestart);
            map.put("code", 200);
            map.put("msg", "获取历史报障信息成功");
            map.put("resp", report);
        } catch (JSONException e) {
            map.put("code", 100);
            map.put("msg", "获取历史报障信息失败" + e.getMessage());
            map.put("resp", "");
            e.printStackTrace();
        } catch (Exception e) {
            map.put("code", 100);
            map.put("msg", "获取历史报障信息失败" + e.getMessage());
            map.put("resp", "");
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 极光推送
     *zx
     * @param area
     * @return
     */
    public void getPushMessage(String area){
//        1通过该用户所在区域获取相关区域的运维人员信息id
        String sql = " where userArea like '" + "%"+area+"%'" ;
        String alert = "pingApp提醒您:有新的报账信息,区域"+area;
        String alias = null ;
        try {
            List<t_user> t_users = this.userservice.selectBySql(sql);
            if (t_users.size() == 0){
                log.info("该区域没有运维人员");
                return;
            }else {
                for( int i = 0 ; i < t_users.size() ; i++) {
                    alias = t_users.get(i).getUserid();
//            将遍历结果发送给极光推送
                     PushResult result = JiGuangPush.push(alias, alert);
                    if(result != null && result.isResultOK()){
                        log.info("针对别名" + alias + "的信息推送成功！");
                    }else{
                        log.info("针对别名" + alias + "的信息推送失败！");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            log.info(e.getMessage());
        }

    }
    //	 * 新建报障
//	 *zx1
//	 * @param request
//	 * @return
//	 */
    @ResponseBody
    @RequestMapping("/addError")
    public Map<String, Object> addError(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        // 进行数据库操作
        t_reportError report = new t_reportError();
        int result = 0;
        try {
            String params = request.getParameter("params");

            JSONObject jo = new JSONObject(params);
            String erroraccount = jo.getString("account");// 宽带账号
            String errorphone = jo.getString("phone");// 手机号
            String erroraddress = jo.getString("address");// 地址
            String errornote = jo.getString("note");// 故障信息
            String userid = jo.getString("userid");
            String type = jo.getString("type");
            request.setCharacterEncoding("utf-8");
            report.setReporterroraccount(erroraccount);
            report.setReporterroraddress(erroraddress);
            report.setReporterrorid(UUID.randomUUID().toString());
            report.setReporterrornote(errornote);
            report.setReporterrorphone(errorphone);
            report.setReporterrorcreatetime(new Date());
            report.setReporterroruserid(userid);
            report.setReportlogsprogress("未受理");

            try {
                if (Integer.parseInt(type) == 1) {
//                List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
                    Iterator<String> it = ((MultipartHttpServletRequest) request).getFileNames();
                    String[] img = {"", "", "", "", ""};
                    int i = 0;
                    while (it.hasNext()){
//                    MultipartFile file = files.get(i);
                        MultipartFile file = ((MultipartHttpServletRequest) request).getFile(it.next());
                        //        项目地址
                        String webPath = "http://" + request.getServerName() + ":" + request.getServerPort()
                                + request.getContextPath();// 项目名称


                        String fileName = file.getOriginalFilename();  // 文件名
                        if (!"".equals(fileName) && fileName != null) {

                            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名

                            String filePath = "D://temp-rainy//"; // 上传后的路径
                            fileName = UUID.randomUUID() + suffixName; // 新文件名
                            File dest = new File(filePath + fileName);
                            if (!dest.getParentFile().exists()) {
                                dest.getParentFile().mkdirs();
                            }
                            try {
                                file.transferTo(dest);
                            } catch (IOException e) {
                                e.printStackTrace();
                                map.put("code", 101);
                                map.put("msg", e.getMessage());
                                return map;
                            }
                            fileName = webPath + "/temp-rainy/" + fileName;
                            img[i] = fileName;
                            i++;
                        }
                    }
                    if (img[0].isEmpty()) {
                    } else if (img[1].isEmpty()) {
                        report.setReporterrorimg1(img[0]);
                    } else if (img[2].isEmpty()) {
                        report.setReporterrorimg1(img[0]);
                        report.setReporterrorimg2(img[1]);
                    } else if (img[3].isEmpty()) {
                        report.setReporterrorimg1(img[0]);
                        report.setReporterrorimg2(img[1]);
                        report.setReporterrorimg3(img[2]);
                    } else if (img[4].isEmpty()) {
                        report.setReporterrorimg1(img[0]);
                        report.setReporterrorimg2(img[1]);
                        report.setReporterrorimg3(img[2]);
                        report.setReporterrorimg4(img[3]);
                    } else {
                        report.setReporterrorimg1(img[0]);
                        report.setReporterrorimg2(img[1]);
                        report.setReporterrorimg3(img[2]);
                        report.setReporterrorimg4(img[3]);
                        report.setReporterrorimg5(img[4]);
                    }
                    map.put("msg", "成功");
                } else {
                    map.put("msg", "no get file");
                }
                System.out.println("210"+report);
                result = reporterrorservice.insertSelective(report);
                if (result>0){
                    getPushMessage("和平");
                    map.put("code", 200);
                }else {
                    map.put("code", 501);
                    map.put("msg", "插入数据失败");
                }
                map.put("resp", "");
                log.info("结果"+map);
                return map;
            }catch (Exception e){
                e.printStackTrace();
                map.put("code", 100);
                if (result>0){map.put("code", 200);map.put("msg","传成功了但是后台报了文件转换错"+e.getMessage());}
                map.put("msg", e.getMessage());
                map.put("resp", "");
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 100);
            if (result>0){map.put("code", 200);map.put("msg","传成功了但是后台报错了");}
            map.put("msg", e.getMessage());
            map.put("resp", "");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping("/test2")
    public Map<String, Object> test2(HttpServletRequest request) {
        Logger logger = LoggerFactory.getLogger(getClass());
        Map<String, Object> map = new HashMap<>();
        try {
            String erroraccount = request.getParameter("account");
            String errorphone = request.getParameter("phone");
            String erroraddress = request.getParameter("address");
            String errornote = request.getParameter("note");
            String account = request.getParameter("account");
            String userid = request.getParameter("userid");
            String type = request.getParameter("type");
            request.setCharacterEncoding("utf-8");
            // 进行数据库操作
            t_reportError report = new t_reportError();
            report.setReporterroraccount(erroraccount);
            report.setReporterroraddress(erroraddress);
            report.setReporterrorid(UUID.randomUUID().toString());
            report.setReporterrornote(errornote);
            report.setReporterrorphone(errorphone);
            report.setReporterrorcreatetime(new Date());
            report.setReporterroruserid(userid);
            report.setReportlogsprogress("未受理");
            if (Integer.parseInt(type) == 1) {
                Iterator<String> it = ((MultipartHttpServletRequest) request).getFileNames();
                  logger.debug("224走这了吗");
//                List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
                String[] img = {"", "", "", "", ""};
//                for (int i = 0; i < files.size(); ++i) {
                int i = 0;
                while (it.hasNext()){
//                    MultipartFile file = files.get(i);
                    MultipartFile file = ((MultipartHttpServletRequest) request).getFile(it.next());
                    logger.debug("232走这了吗");

                    //        项目地址
                    String webPath = "http://" + request.getServerName() + ":" + request.getServerPort()
                            + request.getContextPath();// 项目名称


                    String fileName = file.getOriginalFilename();  // 文件名
                    if (!"".equals(fileName) && fileName != null) {

                        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名

                        String filePath = "D://temp-rainy//"; // 上传后的路径
                        fileName = UUID.randomUUID() + suffixName; // 新文件名
                        File dest = new File(filePath + fileName);
                        if (!dest.getParentFile().exists()) {
                            dest.getParentFile().mkdirs();
                        }
                        try {
                            file.transferTo(dest);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        fileName = webPath + "/temp-rainy/" + fileName;
                        img[i] = fileName;
                        i++;
                        logger.debug("260上传成功");
                    }
                }
                if (img[0].isEmpty()) {
                } else if (img[1].isEmpty()) {
                    report.setReporterrorimg1(img[0]);
                } else if (img[2].isEmpty()) {
                    report.setReporterrorimg1(img[0]);
                    report.setReporterrorimg2(img[1]);
                } else if (img[3].isEmpty()) {
                    report.setReporterrorimg1(img[0]);
                    report.setReporterrorimg2(img[1]);
                    report.setReporterrorimg3(img[2]);
                } else if (img[4].isEmpty()) {
                    report.setReporterrorimg1(img[0]);
                    report.setReporterrorimg2(img[1]);
                    report.setReporterrorimg3(img[2]);
                    report.setReporterrorimg4(img[3]);
                } else {
                    report.setReporterrorimg1(img[0]);
                    report.setReporterrorimg2(img[1]);
                    report.setReporterrorimg3(img[2]);
                    report.setReporterrorimg4(img[3]);
                    report.setReporterrorimg5(img[4]);
                }
                map.put("msg", "成功");
            } else {
                map.put("msg", "success and no get file");
            }
            System.out.println("329"+report);
            int result = reporterrorservice.insertSelective(report);
            if (result>0){
//                getPushMessage("和平");
                map.put("code", 200);
            }else {
                map.put("code", 501);
                map.put("msg", "插入数据失败");
            }
            map.put("resp", "");
            log.info("结果"+map);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 100);
            map.put("msg", e.getMessage());
            map.put("resp", "");
            return map;
        }
    }

//	/**
//	 * 新建报障
//	 *张宇
//	 * @param request
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/addError")
//	public Map<String, Object> addError(HttpServletRequest request) {
//
//		Map<String, Object> map = new HashMap<>();
//		// 上传报障图片部分
//		try {
//			String params = request.getParameter("params");
//			JSONObject jo = new JSONObject(params);
//			String erroraccount = jo.getString("account");// 宽带账号
//			String errorphone = jo.getString("phone");// 手机号
//			String erroraddress = jo.getString("address");// 地址
//			String errornote = jo.getString("note");// 故障信息
//			String userid=jo.getString("userid");
//			request.setCharacterEncoding("utf-8");
//			// 保存地址
//			String filePath = request.getServletContext().getRealPath("/reportError/");
//			String webPath = "http://" + request.getServerName() + ":" + request.getServerPort()
//					+ request.getContextPath() + "/reportError/";// 项目名称
//
//			// 获取解析器
//			CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//			// 判断是否是文件
//			if (resolver.isMultipart(request)) {
//				try {
//					// 进行转换
//					MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) (request);
//					// 获取所有文件名称
//					Iterator<String> it = multiRequest.getFileNames();// 迭代器，只允许向下执行不允许向上执行
//					MultipartFile file = null;
//					String[] img = { "", "", "", "", "" };
//					int i = 0;
//					while (it.hasNext()) {
//						try {
//							// 根据文件名称取文件
//							filePath = request.getServletContext().getRealPath("/reportError/");
//							webPath = "http://" + request.getServerName() + ":" + request.getServerPort()
//							+ request.getContextPath() + "/reportError/";// 项目名称
//							file = multiRequest.getFile(it.next());
//							String fileName = file.getOriginalFilename();
//							String localPath = filePath + fileName;
//							String nowtimefile = new Date().getTime() + "";
//							String url = webPath + nowtimefile + ".jpg";
//							File newFile = new File(localPath);
//							File f1 = new File(filePath);
//							if (!f1.exists()) {
//								f1.mkdirs();
//							}
//							// 上传的文件写入到指定的文件中
//							file.transferTo(newFile);
//							File toFile = new File(filePath + nowtimefile + ".jpg");
//							newFile.renameTo(toFile);
//							webPath = webPath + nowtimefile + ".jpg";
//							img[i] = webPath;
//							i++;
//							map.put("code", 200);
//							map.put("msg", "成功");
//							map.put("resp", "");
//						} catch (Exception e) {
//							e.printStackTrace();
//							map.put("code", 101);
//							map.put("msg", "get file message error" + e.getMessage());
//							map.put("resp", "");
//						}
//					}
//					// 进行数据库操作
//					t_reportError report = new t_reportError();
//					if (img[0].isEmpty()) {
//						report.setReporterroraccount(erroraccount);
//						report.setReporterroraddress(erroraddress);
//						report.setReporterrorid(UUID.randomUUID().toString());
//						report.setReporterrornote(errornote);
//						report.setReporterrorphone(errorphone);
//						report.setReporterrorcreatetime(new Date());
//						report.setReporterroruserid(userid);
//					} else if (img[1].isEmpty()) {
//						report.setReporterroraccount(erroraccount);
//						report.setReporterroraddress(erroraddress);
//						report.setReporterrorid(UUID.randomUUID().toString());
//						report.setReporterrornote(errornote);
//						report.setReporterrorphone(errorphone);
//						report.setReporterrorcreatetime(new Date());
//						report.setReporterroruserid(userid);
//						report.setReporterrorimg1(img[0]);
//					} else if (img[2].isEmpty()) {
//						report.setReporterroraccount(erroraccount);
//						report.setReporterroraddress(erroraddress);
//						report.setReporterrorid(UUID.randomUUID().toString());
//						report.setReporterrornote(errornote);
//						report.setReporterrorphone(errorphone);
//						report.setReporterrorcreatetime(new Date());
//						report.setReporterroruserid(userid);
//						report.setReporterrorimg1(img[0]);
//						report.setReporterrorimg2(img[1]);
//					} else if (img[3].isEmpty()) {
//						report.setReporterroraccount(erroraccount);
//						report.setReporterroraddress(erroraddress);
//						report.setReporterrorid(UUID.randomUUID().toString());
//						report.setReporterrornote(errornote);
//						report.setReporterrorphone(errorphone);
//						report.setReporterrorcreatetime(new Date());
//						report.setReporterroruserid(userid);
//						report.setReporterrorimg1(img[0]);
//						report.setReporterrorimg2(img[1]);
//						report.setReporterrorimg3(img[2]);
//					} else if (img[4].isEmpty()) {
//						report.setReporterroraccount(erroraccount);
//						report.setReporterroraddress(erroraddress);
//						report.setReporterrorid(UUID.randomUUID().toString());
//						report.setReporterrornote(errornote);
//						report.setReporterrorphone(errorphone);
//						report.setReporterrorcreatetime(new Date());
//						report.setReporterroruserid(userid);
//						report.setReporterrorimg1(img[0]);
//						report.setReporterrorimg2(img[1]);
//						report.setReporterrorimg3(img[2]);
//						report.setReporterrorimg4(img[3]);
//					} else {
//						report.setReporterroraccount(erroraccount);
//						report.setReporterroraddress(erroraddress);
//						report.setReporterrorid(UUID.randomUUID().toString());
//						report.setReporterrornote(errornote);
//						report.setReporterrorphone(errorphone);
//						report.setReporterrorcreatetime(new Date());
//						report.setReporterroruserid(userid);
//						report.setReporterrorimg1(img[0]);
//						report.setReporterrorimg2(img[1]);
//						report.setReporterrorimg3(img[2]);
//						report.setReporterrorimg4(img[3]);
//						report.setReporterrorimg5(img[4]);
//					}
//					reporterrorservice.insertSelective(report);
//					map.put("code", 200);
//					map.put("msg", "成功");
//					map.put("resp", "");
//
//				} catch (IllegalStateException e) {
//					e.printStackTrace();
//					map.put("code", 110);
//					map.put("msg", "file multi error" + e.getMessage());
//					map.put("resp", "");
//				}
//			} else {
//				map.put("code", 102);
//				map.put("msg", "no get file");
//				map.put("resp", "");
//			}
//
//			return map;
//		} catch (Exception e) {
//			e.printStackTrace();
//			map.put("code", 100);
//			map.put("msg", e.getMessage());
//			map.put("resp", "");
//			return map;
//		}
//	}
////
//	/**
//	 * 故障受理
//	 * @param request
//	 * @return
//	 */
	@ResponseBody
	@RequestMapping("/updateReport")
	public Map<String,Object> updateReport(HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			String params=request.getParameter("params");
			JSONObject jo=new JSONObject(params);
			String progress=jo.getString("progress");//故障进度
			String userid=jo.getString("userid");//受理人
			String reporttype=jo.getString("reporttype");//故障类型
			String reportclass=jo.getString("reportclass");//故障分类
			String reportid=jo.getString("reportid");//故障ID
			String other = jo.getString("other");
			if(reportid.isEmpty()){
				map.put("code", 100);
				map.put("msg", "故障受理失败，reportid不能为空");
				map.put("resp", "");
			}else{
				t_reportError report=new t_reportError();
				report.setReporterrorid(reportid);
				report.setReportlogsprogress(progress);
				report.setReportlogsuserid(userid);
				report.setReportlogstype(reporttype);
				report.setReportlogsclass(reportclass);
				report.setOther(other);
				reporterrorservice.updateByPrimaryKeySelective(report);
				map.put("code", 200);
				map.put("msg", "故障受理成功");
				map.put("resp", "");
			}

		} catch (JSONException e) {
			map.put("code", 100);
			map.put("msg", "故障受理失败"+e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}catch (Exception e) {
			map.put("code", 100);
			map.put("msg", "故障受理失败"+e.getMessage());
			map.put("resp", "");
			e.printStackTrace();
		}
		return map;
	}

    /**
     * 运维人员通过区域获取报障信息
     * 通过自身id获取已处理的报障订单
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/getErrorListByArea")
    public Map<String, Object> getErrorListByArea(HttpServletRequest request) {
        t_reportError report = new t_reportError();
        String params = request.getParameter("params");
        JSONObject jo = new JSONObject(params);
        String reportlogsuserid = jo.getString("reportlogsuserid");// 宽带账号
        Integer pagestart =jo.getInt("pagestart");// 手机号
        report.setReporterroruserid(reportlogsuserid);

        ResultPojo rp = new ResultPojo();
        Map<String, Object> map = new HashMap<String, Object>();
        if (reportlogsuserid == null) {
            ResultSuccessOrError.resultError(rp);
            rp.setMsg("获取运维人员id失败");
            map.put("msg", "获取运维人员id失败");
            map.put("code", "500");
            return map;
        }
        if (pagestart == null) {
            pagestart = 0;
        }

        String sql = " where reportlogsuserid = '" + reportlogsuserid + "'  ORDER BY reportErrorCreateTime DESC ";
        try {
//			 通过受理人id获取该受理人的受理报障信息
            List<t_reportError> reportLog = this.reporterrorservice.selectPageBySql(sql, 10, pagestart);
            if (reportLog.isEmpty()) {
                ResultSuccessOrError.resultError(rp);
                rp.setMsg("1暂无该受理人提交过的报障信息");
            } else {
                ResultSuccessOrError.resultSuccess(rp);
            }
//			1通过受理人id获取受理人所在区域
            t_user userById = this.userservice.selectByKey(reportlogsuserid);
            List<t_reportError> reportArea = null;
            if (userById == null) {
                rp.setMsg(rp.getMsg() + "2受理人id无法获取到受理人相关区域");
            } else {
                String area = userById.getUserArea();
                if (userById.getUserArea() == null) {
                    rp.setMsg(rp.getMsg() + "3该运维人员无区域信息");
                } else {
//				通过区域获取报障信息
                    sql = " where reporterroraddress = '" + area + "' and reportlogsuserid ='' or reportlogsprogress = '未受理'  ORDER BY reportErrorCreateTime DESC ";
                    reportArea = this.reporterrorservice.selectPageBySql(sql, 10, pagestart);
                }
            }
            Map<String, Object> Tmap = new HashMap<>();
            Tmap.put("reportLog", reportLog);
            Tmap.put("reportArea", reportArea);

            map.put("msg", rp.getMsg());
            map.put("code", rp.getCode());
            map.put("resp", Tmap);
//		rp.setResp(map);
        } catch (Exception e) {
            e.printStackTrace();
            rp.setCode(500);
            rp.setMsg("查看失败");
        }

        return map;
    }

    /**
     * 确认工单
     *zx
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/submitReport")
    public ResultPojo submitReport(HttpServletRequest request) {
        t_reportError error = new t_reportError();
        String params = request.getParameter("params");
        JSONObject jo = new JSONObject(params);
        String reporterrorid = jo.getString("reporterrorid");// 宽带账号
        String reportlogsuserid = jo.getString("reportlogsuserid");// 宽带账号
        error.setReporterroruserid(reportlogsuserid);
        error.setReporterrorid(reporterrorid);

//		将运维人员id插入到故障表中并且状态设定为确认订单 那么需要两个字段  故障id 运维人员id
       error.setReportlogsprogress("已受理");
        int updateByPrimaryKeySelective = this.reporterrorservice.updateByPrimaryKeySelective(error);
//		创建一个工具类pojo，用于返回数据
        ResultPojo<Object> rp = new ResultPojo<Object>();
        if (updateByPrimaryKeySelective == 1) {
            ResultSuccessOrError.resultSuccess(rp);
        } else {
            ResultSuccessOrError.resultError(rp);
        }
        return rp;
    }

}
