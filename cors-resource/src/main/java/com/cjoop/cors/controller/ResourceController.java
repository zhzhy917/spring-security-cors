package com.cjoop.cors.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import com.cjoop.cors.domain.User;

@RestController
public class ResourceController {
	
	@RequestMapping("/resource")
	public Map<String,Object> home(HttpServletRequest request) {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		User user = (User) WebUtils.getSessionAttribute(request, "user");
		model.put("user", user);
		model.put("sessionId", WebUtils.getSessionId(request));
		return model;
	}
}
