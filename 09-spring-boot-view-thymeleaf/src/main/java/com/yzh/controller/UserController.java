package com.yzh.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzh.pojo.Users;

@Controller
public class UserController {

	@RequestMapping("/show")
	public String showUser(int id, String name) {
		System.out.println(id);
		System.out.println(name);
		return "userList";
	}

	@RequestMapping("/hello")
	public String showHello(Model model, HttpServletRequest request) {
		//list
		List<Users> list = new ArrayList<>();
		list.add(new Users("张3", "1123", 18));
		list.add(new Users("张4", "1123", 13));
		list.add(new Users("张5", "1123", 14));
		list.add(new Users("张6", "1123", 16));

		model.addAttribute("list", list);

		//map
		Map<String, Users> map = new HashMap<>();
		map.put("u1", new Users("李3", "321", 18));
		map.put("u2", new Users("李3", "234", 18));
		map.put("u3", new Users("李3", "456", 18));
		model.addAttribute("map", map);

		//域对象
		request.setAttribute("req", "HttpServletRequest");
		request.getSession().setAttribute("sess", "HttpSession");
		request.getSession().getServletContext().setAttribute("app", "Application");
		
		model.addAttribute("msg", "hello world");
		model.addAttribute("date", new Date());
		return "userList";
	}

}
