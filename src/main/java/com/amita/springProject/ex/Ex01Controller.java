package com.amita.springProject.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex01Controller {
	
	@GetMapping("/hello/test")
	@ResponseBody
	public String printoutHello() {
		return "hello";
	}

}
