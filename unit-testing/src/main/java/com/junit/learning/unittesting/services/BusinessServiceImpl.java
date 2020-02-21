package com.junit.learning.unittesting.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junit.learning.unittesting.dao.ItemRepository;
import com.junit.learning.unittesting.model.Item;
@Service
public class BusinessServiceImpl implements BusinessServiceInterface {

	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Item retrieveHardCodedItems() {
	   return new Item(1,"cell phone",10,100);
	}

	@Override
	public List<Item> retrieveItems() {
		
		
		List<Item> retrieveItems = itemRepository.findAll();
		
		for(Item item : retrieveItems) {
			 item.setValue(item.getPrice() * item.getQuantity());
		}
		
		return  retrieveItems;
	}

}
