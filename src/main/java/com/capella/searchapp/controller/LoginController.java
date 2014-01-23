package com.capella.searchapp.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capella.searchapp.model.Agency;
@Controller
public class LoginController{
	@RequestMapping(value={"/secure/index"})
	@PreAuthorize("hasRole('ROLE_USER')")
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response, 
			Principal principal)
					throws ServletException, IOException {
		ModelAndView model = new ModelAndView("index");
		if(principal != null){
			String name = principal.getName();
			model.addObject("username", name);
			model.addObject("message", "Welcome to spring security!!");
		}
		return model;
	}


	@RequestMapping(value={"/login"})
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value={"/"})
	public String root(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		model.addAttribute("agency", new Agency());
		return ("redirect:/secure/index");
	}

}