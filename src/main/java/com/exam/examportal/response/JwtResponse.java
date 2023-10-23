/**
 * 
 */
package com.exam.examportal.response;

/**
 * @author Bhavesh
 *
 */
public class JwtResponse {
	private String token;

	/**
	 * @param token
	 */
	public JwtResponse(String token) {
		super();
		this.token = token;
	}

	/**
	 * 
	 */
	public JwtResponse() {
		super();
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "JwtResponse [token=" + token + "]";
	}
	
	

}
