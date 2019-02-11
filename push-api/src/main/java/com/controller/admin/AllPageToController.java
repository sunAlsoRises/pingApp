package com.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/AdminPage")
@Controller
public class AllPageToController {

	
	@RequestMapping("/Login")
	public String LoginPage(){
		return "/admin/login";
	}
	
}
