package com.senyume.aop.controller;

import com.senyume.aop.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jigish Patel
 */

@RestController
public class HelloController {

	@Autowired
	HelloService helloService;

	@RequestMapping("/hello")
	public String hello(){
		return helloService.sayHello();
	}

	@RequestMapping("/hello2")
	public String hello2(){
		return helloService.sayHello2();
	}
}
