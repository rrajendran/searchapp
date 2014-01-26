package com.capella.searchapp.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(value = { "/secure/index" })
	@PreAuthorize("hasRole('ROLE_USER')")
	public ModelAndView home(Principal principal) throws ServletException, IOException {
		ModelAndView model = new ModelAndView("index");
		if (principal != null) {
			String name = principal.getName();
			model.addObject("username", name);
			model.addObject("message", "Welcome to spring security!!");
		}
		return model;
	}

	@RequestMapping(value = { "/login" })
	public ModelAndView login() throws ServletException, IOException {
		return new ModelAndView("login");
	}

	@RequestMapping(value = { "/" })
	public String root(Model model) throws ServletException, IOException {
		return ("redirect:/company/home");
	}

}