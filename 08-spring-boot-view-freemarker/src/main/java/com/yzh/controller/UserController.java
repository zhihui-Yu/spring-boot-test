package com.yzh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzh.pojo.Users;

@Controller
public class UserController {

	@RequestMapping("/showUser")
	public String showUser (Model model) {
		List<Users> list = new ArrayList<>();
		list.add(new Users("张3", "1123", 18));
		list.add(new Users("张4", "1123", 13));
		list.add(new Users("张5", "1123", 14));
		list.add(new Users("张6", "1123", 16));
		
		model.addAttribute("list", list);
		
		return "userList";
	}
	
}
