package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;



@Component("menuItemDao")
public class MenuItemDaoSqlImpl implements MenuItemDao {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(MenuItemDaoSqlImpl.class);
	

	/**
	 * Gets all menu items
	 */
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		
		LOGGER.info("Start");
        
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> menuItems = new ArrayList<>();
		String sql = "select * from menu_items";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				menuItems.add(new MenuItem(resultSet.getLong(1), resultSet.getString(2), String.valueOf(resultSet.getFloat(3)),
						resultSet.getString(4).equals("Yes"), resultSet.getDate(5), resultSet.getString(6),
						resultSet.getString(7).equals("Yes")));
			}
		} catch (SQLException e) {
                System.out.println(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

                System.out.println(e.getMessage());
			}
		}
		LOGGER.info("End");
		return menuItems;
	}

	/**
	 * Gets available menu items
	 */
	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("Start");
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> menuItems = new ArrayList<>();

		String sql = "select * from menu_items where date_of_launch < curdate() and active_status='Yes'";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				menuItems.add(new MenuItem(resultSet.getLong(1), resultSet.getString(2), String.valueOf(resultSet.getFloat(3)),
						resultSet.getString(4).equals("Yes"),resultSet.getDate(5), resultSet.getString(6),
						resultSet.getString(7).equals("Yes")));
			}
		} catch (SQLException e) {
			
		}
		LOGGER.info("End");
		return menuItems;
	}

	/**
	 * Edits menu item
	 */
	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("Start");
		Connection con = ConnectionHandler.getConnection();
        String sql = "update menu_items set item_name = ?,price = ?,active_status = ?,date_of_launch = ?, category = ?,free_delivery = ? where item_id = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,menuItem.getName());
			preparedStatement.setFloat(2, Float.parseFloat(menuItem.getPrice()));
			preparedStatement.setString(3,menuItem.getActive()?"Yes":"No");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			preparedStatement.setString(4,simpleDateFormat.format(menuItem.getDateOfLaunch()));
			preparedStatement.setString(5, menuItem.getCategory());
			preparedStatement.setString(6, menuItem.getFreeDelivery()?"Yes":"No");
			preparedStatement.setLong(7, menuItem.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
		}
		
		LOGGER.info("End");

	}

	/**
	 * Gets menu item and return menu item object
	 */
	@Override
	public MenuItem getMenuItem(long menuItemId) {
		LOGGER.info("Start");
		Connection con = ConnectionHandler.getConnection();
		MenuItem menuItem = null;

		String sql = "select * from menu_items where item_id = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setLong(1, menuItemId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
				menuItem = new MenuItem(resultSet.getLong(1), resultSet.getString(2),String.valueOf(resultSet.getFloat(3)),
						resultSet.getString(4).equals("Yes"),resultSet.getDate(5), resultSet.getString(6),
						resultSet.getString(7).equals("Yes"));
		} catch (SQLException e) {
			
		}
		LOGGER.info("End");
		return menuItem;
		
	}

}

