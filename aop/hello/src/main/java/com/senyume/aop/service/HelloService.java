package com.senyume.aop.service;

import org.springframework.stereotype.Service;

/**
 * @author Jigish Patel
 */

@Service
public class HelloService {

	public String sayHello(){
		//return "Hello from AOP!";
		return sayHello2();
	}

	public String sayHello2(){
		return "Hello from AOP2!";
	}
}
