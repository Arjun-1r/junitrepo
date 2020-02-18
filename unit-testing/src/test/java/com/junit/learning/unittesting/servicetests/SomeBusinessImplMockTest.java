package com.junit.learning.unittesting.servicetests;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import com.junit.learning.unittesting.dao.SomeDataService;
import com.junit.learning.unittesting.services.SomeBusinessImpl;
@ExtendWith(MockitoExtension.class)

public class SomeBusinessImplMockTest {
	   @InjectMocks
	   SomeBusinessImpl sbi;
	   @Mock
	   SomeDataService dataServiceMock;
	
	//  @Before public void setup() {     MockitoAnnotations.initMocks(this); }
	   
	   @BeforeEach
	   void setMockOnService() {
		   MockitoAnnotations.initMocks(this);
	   }
	
	@Test
	void calculateSumUsingDataService_Basic() {
	     when(dataServiceMock.retrieveAllDatas()).thenReturn(new int[] {2,3,5});
	     assertEquals(10,sbi.calculateSumUsingDataService());
	}
	
	
	@Test
	void calculateSumEmpty() {
	   when(dataServiceMock.retrieveAllDatas()).thenReturn(new int[] {});
	    assertEquals(0,sbi.calculateSumUsingDataService());
	}
	
	@Test
	void calculateSumOneValue() {
	     when(dataServiceMock.retrieveAllDatas()).thenReturn(new int[] {5});
	     assertEquals(5,sbi.calculateSumUsingDataService());
	}
	

}
