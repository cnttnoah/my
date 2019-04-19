package com.coin.controllers;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.coin.parameters.parameter;
import com.coin.services.service;

@Controller
public class MainController {
	@Autowired
	service service;
	int num=1;
	
	@RequestMapping(value = "/main", method =RequestMethod.GET)
	public String mainForm() {
		return "main";
	}
			
	@RequestMapping(value="/main", method=RequestMethod.POST)
	public String main(Model model,HttpServletRequest request, @ModelAttribute ("Par") parameter Par){
		num=service.Service(num, Par);
		request.setAttribute("number", String.valueOf(num));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		
		return "main";
	}
}