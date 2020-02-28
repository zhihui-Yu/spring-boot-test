package com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Users;

/**
 * @NotBlank: 判断字符串是否为 null 或者是空串(去掉首尾空格)。 
 * @NotEmpty: 判断字符串是否 null 或者是空串。 
 * @Length: 判断字符的长度(最大或者最小) 
 * @Min: 判断数值最小值 
 * @Max: 判断数值最大值
 * @Email: 判断邮箱是否合法
 * @author listener
 *
 */

@Controller
public class UsersController {
	
	//如果想为传递的对象更改名称
	//可以使用@ModelAttribute("aa")这表示当 前传递的对象的 key 为 aa。 
	//那么我们在页面中获取该对象的 key 也需要修改为 aa 
	@RequestMapping("/addUser")
	public String showPage(@ModelAttribute("aa")Users users) {
		return "add";
	}

	/** * 完成用户添加 */
	//@Valid 开启对 Users 对象的数据校验 
	//BindingResult:封装了校验的结果
	@RequestMapping("/save")
	public String saveUser(@Valid Users users, BindingResult result) {
		if(result.hasErrors()){
			return "add";
		}
		System.out.println(users.toString());
		return "ok";
	}
}
