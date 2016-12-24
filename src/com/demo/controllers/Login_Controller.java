package com.demo.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.models.Login_Model;
import com.demo.pojo.User;

@Controller
public class Login_Controller {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loadLoginPage(HttpServletResponse response, @CookieValue(value="hits", defaultValue="0") Long hits){
		ModelAndView mav = new ModelAndView("login");
		System.out.println("Login method has been called");
		System.out.println("hits = " +hits);
		hits++;
		System.out.println("hits++ = " +hits);
		Cookie cookie = new Cookie("hits", hits.toString());
		response.addCookie(cookie);
		
		User user = new User();
		mav.addObject("user", user);
		return mav;
	}
	
	@RequestMapping(value="/springLogin", method=RequestMethod.GET)
	public ModelAndView springLogin(){
		ModelAndView mav = new ModelAndView("springLogin");
		return mav;
	}
	
	@RequestMapping(value="/springHome", method=RequestMethod.GET)
	public ModelAndView springHOme(){
		ModelAndView mav = new ModelAndView("springHome");
		return mav;
	}
	
	/*
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loadLoginpage(){
		return "login";
	}
	*/
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String do_login(HttpServletRequest req, Model md, HttpSession session, @Valid User user, BindingResult br){
		
		try{
			
			System.out.println("Number of errors: " +br.getAllErrors().size());
			String userName = req.getParameter("username");
			String password = req.getParameter("password");
			
			System.out.println("user namd and password are: " +userName+ ", " +password);
			if(br.getAllErrors().size() > 0){
				System.out.println("There are at least one error");
			}
			else{
				Login_Model lm = new Login_Model();
				String message = lm.doHibernateLogin(userName, password);
				
				if(message.equals("login success")){
					session.setAttribute("username", userName);
					return "redirect:/myProfile2";
				}
				else{
					md.addAttribute("error_msg", message);
				}
				
				/*String message = lm.do_login_process(userName, password);
				if(message.equals("login success")){
					session.setAttribute("username", userName);
					return "redirect:/myProfile2";
				}
				else{
					md.addAttribute("error_msg", message);
				}*/
			}			
			
			return "login";
		}
		catch(Exception e){
			return "login";
		}
	}
}
