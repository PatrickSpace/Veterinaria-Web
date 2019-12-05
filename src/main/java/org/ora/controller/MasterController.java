package org.ora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MasterController {

	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
}
