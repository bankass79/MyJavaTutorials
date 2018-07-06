package fr.amadou.generateRandomString;

import java.security.SecureRandom;
import java.util.UUID;

public class GenerateRandomString {
	
	
	/*public static void main(String[] args) {
		System.out.println(randomString());
	}

	
	public static String randomString() {
		
		String uuiD= UUID.randomUUID().toString();
		return uuiD;
		
		
	}
*/
	
	static final String AB="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	static SecureRandom rmd= new SecureRandom ();
	String randomString(int len) {
		StringBuilder sb= new StringBuilder(len);
		
		for(int i =0; i<len; i++) {
			
			sb.append(AB.charAt(rmd.nextInt(AB.length())));
			
		}
		//System.out.println(sb.toString());
		return sb.toString();
		
		
		
		
	}
}
