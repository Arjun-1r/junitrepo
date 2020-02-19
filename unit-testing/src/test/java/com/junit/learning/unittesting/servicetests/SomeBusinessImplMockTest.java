package com.junit.learning.unittesting.servicetests;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.junit.learning.unittesting.dao.SomeDataService;
import com.junit.learning.unittesting.services.SomeBusinessImpl;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockTest {
	   @InjectMocks
	   SomeBusinessImpl sbi;
	   @Mock
	   SomeDataService dataServiceMock;

	@Test
	public void calculateSumUsingDataService_Basic() {
	     when(dataServiceMock.retrieveAllDatas()).thenReturn(new int[] {2,3,5});
	     assertEquals(10,sbi.calculateSumUsingDataService());
	}
	
	
	@Test
	public void calculateSumEmpty() {
	   when(dataServiceMock.retrieveAllDatas()).thenReturn(new int[] {});
	    assertEquals(0,sbi.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumOneValue() {
	     when(dataServiceMock.retrieveAllDatas()).thenReturn(new int[] {5});
	     assertEquals(5,sbi.calculateSumUsingDataService());
	}
	

}
