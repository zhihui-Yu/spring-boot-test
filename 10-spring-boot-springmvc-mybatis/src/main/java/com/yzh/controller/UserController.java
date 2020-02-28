package com.yzh.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzh.pojo.User;
import com.yzh.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}

	@RequestMapping("addUser")
	public String addUser(User user) {
		return this.userService.addUser(user) > 0 ? "ok" : "notOk";
	}

	@RequestMapping("findUserAll")
	public String findUserAll(Model model) {
		List<User> list = this.userService.findUserAll();
		model.addAttribute("list", list);
		return "showAll";
	}

	@RequestMapping("findUserById")
	public String findUserById(Integer id, Model model) {
		User user = this.userService.findUserById(id);
		model.addAttribute("user", user);
		return "updateUser";
	}

	@RequestMapping("editUser")
	public String editUser(User user) {
		this.userService.updateUser(user);
		return "redirect:/user/findUserAll";
	}

	@RequestMapping("delUser")
	public String delUser(int id) {
		this.userService.delUser(id);
		return "ok";
	}
}
