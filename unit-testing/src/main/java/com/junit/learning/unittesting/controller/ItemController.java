package com.junit.learning.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junit.learning.unittesting.model.Item;
import com.junit.learning.unittesting.services.BusinessServiceInterface;

@RestController
public class ItemController {
	
	@Autowired
	private BusinessServiceInterface businessService;
	
	@GetMapping("/dummy-item")
	public Item getItem() {
		return new Item(1,"cell phone",10,100);
	}
	
	@GetMapping("/dummy-item-from-service")
	public Item getItemFromService() {
		return businessService.retrieveHardCodedItems();
	}
	
	@GetMapping("/all-items")
	public List<Item> allItems() {
		return businessService.retrieveItems();
	}

}
