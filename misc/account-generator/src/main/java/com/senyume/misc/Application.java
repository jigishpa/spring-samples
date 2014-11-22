package com.senyume.misc;

/**
 * @author Jigish Patel
 */

public class Application {

	public static void main(String[] args){
		System.out.println("Generating accounts ...");
		AccountGenerator generator = new AccountGenerator();
		try {
			generator.generateAccounts();
		}catch (Exception ex){
			System.out.println("Exception occured:" + ex);
		}
	}
}
