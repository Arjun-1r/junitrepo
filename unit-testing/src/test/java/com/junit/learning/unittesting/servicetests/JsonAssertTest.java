package com.junit.learning.unittesting.servicetests;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
     String actualResponse =  "{\"id\": 1,\"itemName\":\"cell phone\",\"price\":10,\"quantity\":100}";
	
	@Test
	public void jsonAssertStrictCheckWithspaces() throws JSONException {
		String expectedResponse = "{\"id\": 1,\"itemName\":\"cell phone\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}
	
	@Test
	public void jsonAssertNoStrictCheckWithspaces() throws JSONException {
		String expectedResponse = "{\"id\": 1,\"itemName\":\"cell phone\",\"price\":10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	
	@Test
	public void jsonAssertWithoutEscape_char() throws JSONException {
		String expectedResponse = "{id: 1,itemName:\"cell phone\",price:10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

}
