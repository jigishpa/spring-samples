package com.senyume.aop.controller;

import com.senyume.aop.service.GoodbyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jigish Patel
 */

@RestController
public class GoodbyeController {

	@Autowired
	GoodbyeService goodbyeService;

	@RequestMapping("/goodbye")
	public String goodbye(){
		return goodbyeService.sayGoodbye();
	}
}
