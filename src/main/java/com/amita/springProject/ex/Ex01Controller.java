package com.amita.springProject.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex01Controller {
	
	@RequestMapping("/hello/test")
	@ResponseBody
	public String printoutHello() {
		return "hello";
	}

}
