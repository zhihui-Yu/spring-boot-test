package com.yzh.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 * @author listener
 *
 */
@RestController //该注解自动将返回值转换为json
public class fileController {
	@RequestMapping("/upfile")
	public Map<String, Object> upFile(MultipartFile file) throws IOException{
		System.out.println(file.getOriginalFilename());
		file.transferTo(new File("e:/"+file.getOriginalFilename()));
		Map<String, Object> map = new  HashMap<String, Object>();
		map.put("msg", "ok");
		return map;
	}
}
