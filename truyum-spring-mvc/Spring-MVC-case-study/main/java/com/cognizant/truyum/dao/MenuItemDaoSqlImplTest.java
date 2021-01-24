package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImplTest {
	public static void main(String[] args) {
		
		
		System.out.println("Admin List:");
		testGetMenuItemListAdmin();
		System.out.println("Customer List :");
		testGetMenuItemListCustomer();
		//System.out.println("Modified menu item at id 3:");
	    //testModifyMenuItem();
		//System.out.println("Modified menu item:");
		testGetMenuItem();
	}
	
	public static void testGetMenuItemListAdmin()
	{
		MenuItemDao menuItemDao = new  MenuItemDaoSqlImpl();
		
		menuItemDao.getMenuItemListAdmin().forEach(menuitem->System.out.println(menuitem.toString()));
	}
	
	public static void testGetMenuItemListCustomer()
	{
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		menuItemDao.getMenuItemListCustomer().forEach(menuItem->System.out.println(menuItem.toString()));
	}
	
	public static void testModifyMenuItem()
	{
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		menuItemDao.modifyMenuItem(menuItemDao.getMenuItem(3));
	}
	
	public static void testGetMenuItem()
	{
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(3);
		System.out.println(menuItem.toString());
	}
}
