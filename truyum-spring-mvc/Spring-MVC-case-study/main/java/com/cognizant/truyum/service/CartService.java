package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;



@Service
public class CartService {

	/**
	 * CartService class is the implementation of the service layer as per the
	 * requirements of case study cartDao attribute is autowired using setter
	 * injection and cofigured using spring-config.xml CartDaoCollectionImpl is
	 * injected in cartDao using interface injection
	 */

	@Autowired
	private CartDao cartDao;

	/**
	 * setCartDao() method intitializes cartDao attribute and takes
	 * 
	 * @param cartDao
	 */

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	/**
	 * getAllCartItems() retreives all cart items present in the cart and return the
	 * same. Invokes appropriate methods of cartDao for getting the items from cart
	 * if cart is empty, it throws an Exception
	 * @param userId
	 * @return
	 * @throws CartEmptyException
	 */

	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		return cartDao.getAllCartItems(userId);
	}
	
	
	/**
	 * addCartItem() takes
	 * @param userId
	 * @param menuItemId
	 * and adds the item to the cart
	 */

	public boolean addCartItem(long userId, long menuItemId) {

         return cartDao.addCartItem(userId, menuItemId);

	}
	
	/**
	 * removeCartItem() takes
	 * @param userId
	 * @param menuItemId
	 * and deletes the items from cart
	 */

	public boolean removeCartItem(long userId, long menuItemId) {

		return cartDao.removeCartItem(userId, menuItemId);

	}
	
	public double getTotalCost()
	{	
		return cartDao.getTotalCost();
		
	}
}
