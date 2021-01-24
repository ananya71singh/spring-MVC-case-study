package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;


public interface MenuItemDao {

	/**
	 * Gets the list of menu items for admin
	 * 
	 * @return list of all menu items
	 */
	public List<MenuItem> getMenuItemListAdmin();

	/**
	 * Gets the list of menu items for customer
	 * 
	 * @return list of available menu items
	 */
	public List<MenuItem> getMenuItemListCustomer();

	/**
	 * Edits the menu item
	 * 
	 * @param menuItem
	 */
	public void modifyMenuItem(MenuItem menuItem);

	/**
	 * Gets menu item
	 * 
	 * @param menuItemId
	 * @return menuItem object
	 */
	public MenuItem getMenuItem(long menuItemId);

}
