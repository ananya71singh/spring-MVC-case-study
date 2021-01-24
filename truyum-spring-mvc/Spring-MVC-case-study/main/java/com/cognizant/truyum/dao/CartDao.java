package com.cognizant.truyum.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;


@Component
public interface CartDao {

	/**
	 * Adds cart item
	 * 
	 * @param userId
	 * @param menuItemId
	 * @return true if item is added into cart
	 */
	public boolean addCartItem(long userId, long menuItemId);

	/**
	 * Gets the list of cart item
	 * 
	 * @param userId
	 * @return List of menuItems
	 * @throws CartEmptyException
	 */
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException;

	/**
	 * Deletes item from cart
	 * 
	 * @param userId
	 * @param menuItemId
	 * @return true if item gets deleted
	 */
	public boolean removeCartItem(long userId, long menuItemId);

	/**
	 * Gets total cost of items in cart
	 * 
	 * @return totalCost
	 */
	public double getTotalCost();
}
