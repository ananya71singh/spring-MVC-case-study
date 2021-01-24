package com.cognizant.truyum.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.SystemException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;


@Controller
public class MenuItemController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	/**
	 * validator is a validator for application-specific objects. menuItemService is
	 * instance of MenuItemService class which holds methods for getting data from
	 * dao layer. menuItemService is Autowired menuItemDao is instance of
	 * MenuItemDaoSqlImp class which holds all the data access objects. menuItemDao
	 * in autowired
	 */

	@Autowired
	MenuItemService menuItemService;

	@Autowired
	@Qualifier("menuItemDao")
	MenuItemDao menuItemDao;

	/**
	 * List of all the items in menu categories
	 * 
	 * @return List of all categories in an item
	 */
	@ModelAttribute("categoryList")
	public List<String> categories() {
		List<String> categoriesList = new ArrayList<>();
		categoriesList.add("Main Course");
		categoriesList.add("Starters");
		categoriesList.add("Dessert");
		categoriesList.add("Drinks");

		return categoriesList;
	}

	/**
	 * loads the admin menu item list and adds the list to attribute "menuItemList"
	 * by invoking menuItemService.getMenuItemListAdmin()
	 * 
	 * @param model
	 * @return menu-item-list-admin jsp reference
	 * @throws SystemException
	 */
	@GetMapping("/show-menu-list-admin")
	public String showMenuItemListAdmin(ModelMap model) throws SystemException {
		LOGGER.info("Start");
		model.addAttribute("menuItemList", menuItemService.getMenuItemListAdmin());
		LOGGER.info("End");
		return "menu-item-list-admin";

	}

	/**
	 * loads customer menu items list and adds the attribute "menuItemListCustomer"
	 * by invoking menuItemService.getMenuItemListCustomer()
	 * 
	 * @param model
	 * @return menu-item-list-customer jsp reference
	 * @throws SystemException
	 */

	@GetMapping("/show-menu-list-customer")
	public String showMenuItemListCustomer(ModelMap model) throws SystemException {
		LOGGER.info("Start");
		model.addAttribute("menuItemListCustomer", menuItemService.getMenuItemListCustomer());
		LOGGER.info("End");
		return "menu-item-list-customer";

	}

	/**
	 * loads edit-menu-item.jsp when the user clicks on Edit option in admin menu
	 * list adds attribute "menuItem" by invoking menuItemService.getMenuItem(id)
	 * 
	 * @param id
	 * @param map
	 * @return "edit-menu-item" jsp reference
	 */
	@GetMapping("/show-edit-menu-item")
	public String showEditMenuItem(@RequestParam("menuItemId") Long id, ModelMap map) {
		LOGGER.info("Start");
		map.addAttribute("menuItem", menuItemService.getMenuItem(id));
		LOGGER.info("End");
		return "edit-menu-item";

	}

	/**
	 * applies the changes to menuItem checks if the given parameters are valid
	 * return the same page if errors "edit-menu-item" reference, if inputs are
	 * valid this methods edits menuItem by invoking
	 * menuItemService.editMenuItem(menuItem) return the "edit-menu-item-status" jsp
	 * reference
	 * 
	 * @param menuItem
	 * @param result
	 * @return edit-menu-item/edit-menu-item-status jsp reference based on
	 *         validation
	 */

	@PostMapping("/edit-menu-item")
	public String editMenuItem(@ModelAttribute("menuItem") @Valid MenuItem menuItem, BindingResult result) {
		LOGGER.info("Start");
		if (result.hasErrors()) {
			LOGGER.info("End");
			return "edit-menu-item";
		} else {
			menuItemService.editMenuItem(menuItem);
			LOGGER.info("End");
			return "edit-menu-item-status";
		}
	}

}
