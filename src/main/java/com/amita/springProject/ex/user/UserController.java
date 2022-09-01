package com.amita.springProject.ex.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/signup/view")
	public String signupView() {
		return "user/signup";
	}
	
	@GetMapping("/signin/view")
	public String singinView() {
		return "user/signin";
	}
	
	// 로그아웃 기능 => 로그아웃 한 다음에는 로그인 페이지로 이동
	@GetMapping("/signout")
	public String signout(HttpServletRequest request) {
		
		HttpSession sessoin =  request.getSession();
		
		sessoin.removeAttribute("userId");
		sessoin.removeAttribute("userName");
		
		return "redirect:/user/signin/view";
	}

}
