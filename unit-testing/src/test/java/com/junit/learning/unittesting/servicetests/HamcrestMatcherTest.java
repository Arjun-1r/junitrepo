package com.junit.learning.unittesting.servicetests;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatcherTest {

	@Test
	public void learning() {
		
		List<Integer> values = Arrays.asList(12,13,15);
		assertThat(values, hasSize(3));
//		assertThat(values, hasItems(12,13));
//		assertThat(values,everyItem(greaterThan(10)));
		
		//assertThat("",isEmptyString());
		
		
	}
	
}
