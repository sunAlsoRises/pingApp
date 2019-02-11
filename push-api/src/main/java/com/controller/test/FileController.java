package com.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * 文件上传
 */
@Controller
public class FileController {

    @GetMapping(value = "/file")
    public String file() {
        return "file";
    }

    @PostMapping(value = "/fileUpload")
    public String fileUpload(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        List<MultipartFile> files =((MultipartHttpServletRequest)request).getFiles("file");

        for (int i =0; i< files.size(); ++i) {
            //        项目地址
            String webPath = "http://" + request.getServerName() + ":" + request.getServerPort()
                    + request.getContextPath() ;// 项目名称

            System.out.println("项目地址"+webPath);

            String fileName = files.get(i).getOriginalFilename();  // 文件名
            System.out.println(38+fileName);
            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
            System.out.println(40+fileName);
            String filePath = "D://temp-rainy//"; // 上传后的路径
            fileName = UUID.randomUUID() + suffixName; // 新文件名
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                files.get(i).transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String filename = webPath+"/temp-rainy/" + fileName;
            System.out.println(fileName);
            model.addAttribute("filename", filename);
            System.out.println("上传成功");
        }

        return "uploadPic";
    }
}
