package com.senyume.aop.service;

import org.springframework.stereotype.Service;

/**
 * @author Jigish Patel
 */

@Service
public class GoodbyeService {

	public String sayGoodbye() {
		return sayGoodbye2();
	}

	public String sayGoodbye2(){
		return "Goodbye2!";
	}

}
