/**
 * 
 */
package com.exam.examportal.config;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Bhavesh
 *
 */
class TestPasswordEnconder implements PasswordEncoder {

	
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.toString().equals(s);
    }
    
    /**
	 * Get the singleton {@link NoOpPasswordEncoder}.
	 */
}
