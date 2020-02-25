package com.junit.learning.unittesting.servicetests;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.junit.learning.unittesting.dao.ItemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
//	@MockBean
//	private ItemRepository itemRepository;
	
	@Test
	public void contextLoads() throws JSONException {
		String response = this.testRestTemplate.getForObject("/all-items", String.class);
		JSONAssert.assertEquals("[{id : 1001,itemName : \"dummy item\"},{id : 1002},{id : 1003}]", response, false);
	}
}
