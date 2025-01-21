package com.student_attendance.attendance.login;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("branch")
public class WelcomeController {
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String gotoWelcomepage(ModelMap model) {
		model.put("branch",getLoggedinBranch());
		return "home";
	}
	
	private String getLoggedinBranch() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}
