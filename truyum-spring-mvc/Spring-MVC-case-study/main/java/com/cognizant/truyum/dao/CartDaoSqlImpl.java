package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;



@Component
public class CartDaoSqlImpl implements CartDao {

	/**
	 * CartDaoSqlImp is the sql implementation of all business methods
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CartDaoSqlImpl.class);
	private double totalCost;

	/**
	 * adds item to the cart
	 */
	@Override
	public boolean addCartItem(long userId, long menuItemId) {
		LOGGER.info("Start");
		Connection con = ConnectionHandler.getConnection();

		String sql = "insert into cart(user_id,item_id) values(?,?)";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, menuItemId);

			int row = preparedStatement.executeUpdate();

			LOGGER.info("End");
			if (row > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			LOGGER.info("End");
			return false;
		}

	}

	/**
	 * returns list of all items in cart
	 */
	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {

		LOGGER.info("Start");
		Connection con = ConnectionHandler.getConnection();
		Cart userCart = new Cart(new ArrayList<MenuItem>(), 0);
		String sql = "select m.item_id,item_name,price,active_status,date_of_launch,category,free_delivery from cart c join menu_items m on c.item_id=m.item_id and c.user_id=?";
		double totalPrice = 0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setLong(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				userCart.getMenuItemList()
						.add(new MenuItem(resultSet.getLong(1), resultSet.getString(2),
								String.valueOf(resultSet.getFloat(3)), resultSet.getString(4).equals("Yes"),
								resultSet.getDate(5), resultSet.getString(6), resultSet.getString(7).equals("Yes")));
				totalPrice += resultSet.getFloat(3);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (userCart.getMenuItemList().isEmpty())
			throw new CartEmptyException("Cart is Empty!");
		userCart.setTotal(totalPrice);
		totalCost = totalPrice;

		LOGGER.info("End");
		return userCart.getMenuItemList();
	}

	/**
	 * deletes item from cart
	 */
	@Override
	public boolean removeCartItem(long userId, long menuItemId) {

		LOGGER.info("Start");
		Connection con = ConnectionHandler.getConnection();
		String sql = "delete from cart where user_id = ? and item_id = ? limit 1";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, menuItemId);
			int row = preparedStatement.executeUpdate();

			LOGGER.info("End");
			if (row > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {

			LOGGER.info("End");
			return false;
		}

	}

	/**
	 * returns total cost of items in cart
	 */
	@Override
	public double getTotalCost() {

		LOGGER.info("Start");
		LOGGER.info("End");

		return totalCost;
	}

}
