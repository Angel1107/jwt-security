package com.angel1107.account.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.angel1107.account.model.User;

@Controller
public class Regist {
	
	@GetMapping("openregist") 
	public String openRegist(){
		return "regist";
	}
	@RequestMapping("navigation")
	public String navigationPage(HttpServletRequest request,User user) {
		String page = "";
		//校验用户名是否重复
		{
			//page = "错误页面";
		}
		request.getSession().setAttribute("user", user);
		int userType = user.getUserType();
		switch (userType) {
		case 0:
			page = "test.jsp";
			break;
		case 1:
			page = "test1.jsp";
			break;
		case 2:
			page = "test2.jsp";
			break;
		case 3:
			page = "test3.jsp";
			break;
		case 4:
			page = "test4.jsp";
			break;
		case 5:
			page = "test5.jsp";
			break;
		case 6:
			page = "test6.jsp";
			break;
		}
		return page;
	}

	@RequestMapping("regist")
	public String regist(User user){
		//保存用户
		return "registsuccess";
	}
	
	
}
