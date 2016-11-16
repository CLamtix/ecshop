package com.xy.user.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xy.user.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@ModelAttribute("user") User user, HttpSession session){
		System.out.println(session.getId());
		if("lucy".equals(user.getLoginName()) && "123456".equals(user.getPwd())){
			session.setAttribute(session.getId(), user);
			return "index";
		}else{
			return "login";
		}
		
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session){
		System.out.println(session.getId());
		session.setAttribute(session.getId(), null);
		return "login";
	}
	
}