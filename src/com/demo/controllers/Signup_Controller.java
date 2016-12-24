package com.demo.controllers;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.models.Signup_Model;
import com.demo.pojo.User;

@Controller
public class Signup_Controller {
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public ModelAndView load_signup(){
		System.out.println("load_signup() method is called");
		ModelAndView mav = new ModelAndView("signup");
		
		return mav;
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ModelAndView doSignUpProcess(HttpServletRequest request){
		System.out.println("doSignUpProcess method is called..");
		ModelAndView mav = new ModelAndView("signup");
		String message = "";
		
		if(ServletFileUpload.isMultipartContent(request)){
			try{
							
				List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				System.out.println("After new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request)");
				System.out.println("data.get(0) = " +data.get(0));
				String username = data.get(0).getString();
				System.out.println("username = " +username);
				String password = data.get(1).getString();
				System.out.println("password = " +password);
				String repassword = data.get(2).getString();
				System.out.println("repassword = " +repassword);
				String gender = data.get(3).getString();
				System.out.println("gender = " +gender);
				String vehicle = data.get(4).getString();
				System.out.println("vehicle = " +vehicle);
				String country = data.get(5).getString();
				System.out.println("country = " +country);
				
				String image = new File(data.get(6).getName()).getName();
				System.out.println("image = " +image);
				
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setGender(gender);
				user.setCountry(country);
				user.setVehicle(vehicle);
				user.setImage(image);
				
				
				if(password.equals(repassword)){
					System.out.println("Passwords matches");
					Signup_Model sm = new Signup_Model();
					//message = sm.doSignUp(username, repassword, gender, vehicle, country, image); // This is used for without hibernate
					message = sm.doHibernateSignUp(user); // This is used for hibernate
					
					String path = request.getSession().getServletContext().getRealPath("/") + "//WEB-INF//images//";
					
					data.get(6).write(new File(path + File.separator + image));
				}
				else{
					message = "Password mismatch!";					
				}
			}
			catch(Exception e){
				System.out.println(e);
				message = "Please try again!";
			}
		}
		mav.addObject("message", message);
		return mav;
	}

}
