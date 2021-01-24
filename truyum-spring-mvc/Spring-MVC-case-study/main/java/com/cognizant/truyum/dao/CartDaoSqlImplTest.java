package com.cognizant.truyum.dao;

public class CartDaoSqlImplTest {
	public static void main(String[] args) {
		System.out.println("Add cart item:");
		testAddCartItem();
		System.out.println("Get all cart items");
	    testGetAllCartItems();
	    System.out.println("Removed cart item with id 3");
		testRemoveCartItem();
		System.out.println("getting cart item with id 3");
		testGetAllCartItems();
	}
	
	public static void testAddCartItem()
	{
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.addCartItem(1, 3);
	}
	public static void testGetAllCartItems()
	{
		CartDao cartDao =new CartDaoSqlImpl();
		try {
			cartDao.getAllCartItems(1).forEach(cartItem->System.out.println(cartItem.toString()));
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void testRemoveCartItem()
	{
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.removeCartItem(1, 3);
	}
}