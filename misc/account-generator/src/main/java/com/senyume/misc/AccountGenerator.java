package com.senyume.misc;

import java.util.HashMap;

/**
 * @author Jigish Patel
 */

public class AccountGenerator {

	private String[] usernamePrefixes = {"dev", "qa", "test", "user"};
	private int usernameSuffixLength = 5;
	private String passwordCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%^&!";
	private int passwordLength = 10;
	private HashMap<String,String> accountsMap = new HashMap<String, String>();
//	private String accountGeneratorSQL = "insert into oauth_client_details " +
//			"(client_id, client_secret, resource_ids,authorized_grant_types,authorities,access_token_validity) values " +
//			"('username', 'password', 'fmrApi', 'client_credentials', 'ROLE_FMR', -1);";
	private String accountGeneratorSQL = "insert into oauth_client_details " +
			"(client_id, client_secret, resource_ids,authorized_grant_types,authorities,access_token_validity) values " +
			"('username', 'password', 'sparklr-boot', 'client_credentials', 'ROLE_DEMO', -1);";

	public void generateAccounts() throws Exception{
		for(int i=0; i<100; i++){
			int usernameIndex = randomNumber(0, usernamePrefixes.length);
			int usernameSuffix = randomNumber(0, 10000);
			//System.out.println("index:" + usernameIndex + " suffix:" + usernameSuffix );
			String username = usernamePrefixes[usernameIndex] + Integer.toString(usernameSuffix);
			if(accountsMap.containsKey(username)){
				i = i-1;	// repeat this step
				//System.out.println("Duplicate username " + username + " ... adjusting loopcount to compensate");
				continue;
			}else{
				accountsMap.put(username, username);
			}
			StringBuilder passwordBuilder = new StringBuilder();
			for(int j=0; j<passwordLength; j++){
				int index = -1;
				if(j == 0) {
					index = randomNumber(0, 52);	// starting password with a character
				}else{
					index = randomNumber(0, passwordCharacters.length());
				}
				passwordBuilder.append(passwordCharacters.charAt(index));
			}
			System.out.println(username + " " + passwordBuilder.toString());
			String insertSql = accountGeneratorSQL.replace("username", username);
			insertSql = insertSql.replace("password", passwordBuilder.toString());
			System.out.println(insertSql);

		}
	}

	// max excluded
	private int randomNumber(int min, int max) throws Exception{
		if(min < 0){
			throw new Exception("Negative values not allowed in randomNumber()");
		}
		if(max > Integer.MAX_VALUE){
			throw new Exception("Invalid max value in randomNumber(). Cannot be greater than " + Integer.MAX_VALUE);
		}
		int range = max - min;
		return (int)(Math.random() * range) + min;
	}

}
