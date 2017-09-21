package com.bank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// this is how we return views
@Controller
public class ViewController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView getAppView(){
		System.out.println("in viewctrl");
		return new ModelAndView("index.html");
		// return "redirect:http://google.com";
	}
}
