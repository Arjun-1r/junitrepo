package com.junit.learning.unittesting.servicetests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	
	@Test 
	public void learning() {
		
		String response  = "[\r\n" + 
				"  {\"Id\" : 10000, \"name\" : pencil, \"quantity\" : 5 }," + 
				"  {\"Id\" : 10001, \"name\" : rubber, \"quantity\" : 25 }," + 
				"  {\"Id\" : 10002, \"name\" : pen, \"quantity\" : 15 }" + 
				"]";
		
		DocumentContext docContext = JsonPath.parse(response);
		int length = docContext.read("$.length()");
		assertThat(length).isEqualTo(3);
		
		List<Integer> ids = docContext.read("$..Id");
		//System.out.println(string);
		
	    assertThat(ids).containsExactly(10000,10001,10002);
	    
	    System.out.println(docContext.read("$.[0:2]").toString());
	    System.out.println(docContext.read("$.[?(@.name == 'rubber')]").toString());
	    System.out.println(docContext.read("$.[?(@.quantity == '15')]").toString());
		
		
		
		
	}
	
}
