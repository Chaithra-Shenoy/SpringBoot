/**
 * 
 */
package com.bridgelabz.login.util;

/**
 * purpose
 * @author Chaithra-Shenoy
 * Date
 * 
 */
public class CustomErrorType {
	private String errorMessage;
    
    /**
     * to print error message
     * @param errorMessage
     */
    public CustomErrorType(String errorMessage){
        this.errorMessage = errorMessage;
    }
 
    public String getErrorMessage() {
        return errorMessage;
    }
}
