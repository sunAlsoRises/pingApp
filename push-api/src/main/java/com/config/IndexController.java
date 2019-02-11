package com.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping({"/","/index"})
	public String index() {
		System.out.println("首页走了吗");
		return "redirect:/index.html";
	}
}
