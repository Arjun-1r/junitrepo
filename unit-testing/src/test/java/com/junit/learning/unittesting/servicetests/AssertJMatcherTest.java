package com.junit.learning.unittesting.servicetests;





import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AssertJMatcherTest {

	@Test
	public void learning() {
		
		List<Integer> values = Arrays.asList(12,13,15);
		//assertThat(values, hasSize(3));
		
		assertThat(values).hasSize(3).
		contains(12,13).allMatch(x -> x > 10).allMatch(x -> x < 100).noneMatch(x -> x < 0);
		
		
		assertThat("ABCDE").contains("BCD").startsWith("ABC").endsWith("DE");
     
		
		
	}
	
}
