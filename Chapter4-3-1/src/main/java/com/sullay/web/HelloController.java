package com.sullay.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	 @RequestMapping("/")
	    public String index() {
	        return "index";
	    }

	    @RequestMapping("/hello")
	    public String hello() {
	        return "hello";
	    }
	    @RequestMapping("/login")
	    public String login() {
	        return "login";
	    }
}
