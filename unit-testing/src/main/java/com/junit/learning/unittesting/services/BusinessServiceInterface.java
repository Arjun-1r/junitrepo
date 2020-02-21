package com.junit.learning.unittesting.services;

import java.util.List;

import com.junit.learning.unittesting.model.Item;

public interface BusinessServiceInterface {
    Item retrieveHardCodedItems();
    List<Item> retrieveItems();
	
}
