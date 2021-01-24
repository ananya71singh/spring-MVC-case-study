package com.cognizant.truyum.dao;


public class CartEmptyException extends Exception {

	
	private static final long serialVersionUID = 6539196163290646747L;
	/**
	 * "Cart is empty!"
	 * @param message
	 */
	public CartEmptyException(String message) {
		super(message);
	}
}
