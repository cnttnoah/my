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
	
	@RequestMapping(value = "/main", method =RequestMethod.GET)
	public String mainForm() {
		return "main";
	}
			
	@RequestMapping(value="/main", method=RequestMethod.POST) // GET방식과 POST방식이 가능하게 해둔다
	public String main(Model model,HttpServletRequest request, @ModelAttribute ("Par") parameter Par, @RequestParam(value="btn",required=true) String btn) {
		Par.setNum(service.Service(btn, Par).getNum());
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		
		return "main";
	}
}