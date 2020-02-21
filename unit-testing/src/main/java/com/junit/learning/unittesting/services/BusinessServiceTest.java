package com.junit.learning.unittesting.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import com.junit.learning.unittesting.dao.ItemRepository;
import com.junit.learning.unittesting.model.Item;
@RunWith(MockitoJUnitRunner.class)
public class BusinessServiceTest {

	@InjectMocks
	private BusinessServiceImpl businessService;
	
	@Mock
	private ItemRepository itemRepository;
	
	@Test
	public void testRetrieveAllItems() {
	   when(itemRepository.findAll()).thenReturn(
			 Arrays.asList(
					 new Item(1,"Item1",10,10),new Item(2,"Item2",20,20)  
					  )	
		  );
		List<Item> items = businessService.retrieveItems();
		assertEquals(100,items.get(0).getValue());
		assertEquals(400,items.get(1).getValue());
		
	}

}
