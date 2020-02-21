package com.junit.learning.unittesting.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.junit.learning.unittesting.model.Item;
import com.junit.learning.unittesting.services.BusinessServiceInterface;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Arrays;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
    @Autowired
	private MockMvc mockMvc;
    
    @MockBean
    private BusinessServiceInterface businessService;
	
	@Test
	public void dummyItemTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
		MvcResult result =  mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\": 1,\"itemName\":\"cell phone\",\"price\":10,\"quantity\":100}"))
				.andReturn();
	}
	
	@Test
	public void dummyItemFromServiceTest() throws Exception {
		when(businessService.retrieveHardCodedItems()).thenReturn(new Item(2,"volley ball",100,10));
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item-from-service").accept(MediaType.APPLICATION_JSON);
		MvcResult result =  mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\": 2,\"itemName\":\"volley ball\",\"price\":100,\"quantity\":10}"))
				.andReturn();
	}
	
	
	@Test
	public void ItemsFromServiceTest() throws Exception {
	   when(businessService.retrieveItems()).thenReturn(
				 Arrays.asList(new Item(1,"Item1",10,100),new Item(2,"Item2",20,200))
	);
		RequestBuilder request = MockMvcRequestBuilders.get("/all-items").accept(MediaType.APPLICATION_JSON);
		MvcResult result =  mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\": 1,\"itemName\":\"Item1\",\"price\":10,\"quantity\":100},{}]"))
				.andReturn();
	}
	
}
