package com.monish.weshare.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.monish.weshare.model.Login;
import com.monish.weshare.model.Register;


@Controller
public class WeShareController {
	
	@Autowired
	Register register;
	
	@Autowired 
	Login login;
	
	
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String home(HttpServletRequest req, Locale locale, Model model) {

		if (null != req.getSession()) {
			req.getSession().invalidate();
		}
		return "LoginRegistration";
	}
	//registration
	@RequestMapping(value ="userRegistration", method = RequestMethod.POST)
	public String userRegistration(@Validated Register register,HttpServletRequest req) {

		if (null != req.getSession()) {
			req.getSession().invalidate();
		}
		System.out.println("User Registered "+register.getFirstname());
		return "RegistrationSuccess";
	}
	
	//login 
	
	@RequestMapping(value ="userLogin", method = RequestMethod.POST)
	public String userLogin(Login login,HttpServletRequest req) {

		if (null != req.getSession()) {
			req.getSession().invalidate();
		}
String successFlag="LoginRegistration";		
boolean loginValidationResult=false;
String userName=login.getUsername();
String password=login.getPassword();
//loginValidationResult=
if (loginValidationResult){
	successFlag="userHome";
}
return successFlag;
	
	}

}
