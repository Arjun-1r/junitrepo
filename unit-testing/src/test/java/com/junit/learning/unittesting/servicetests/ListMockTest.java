package com.junit.learning.unittesting.servicetests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.mockito.ArgumentCaptor;


public class ListMockTest {
	 List<String> listMock = mock(List.class);
	@Test
	public void size_basic() {
		
		 when(listMock.size()).thenReturn(5);
		 assertEquals(5,listMock.size());
	}
	
	@Test
	public void returnDifferentValues() {
		 when(listMock.size()).thenReturn(5).thenReturn(10);
		 assertEquals(5,listMock.size());
		 assertEquals(10,listMock.size());
	}
	
	@Test
	public void returnWithParams() {
		when(listMock.get(0)).thenReturn("junit testing");
		assertEquals("junit testing",listMock.get(0));
	}
	
	@Test
	public void returnWithGenericParams() {
		when(listMock.get(anyInt())).thenReturn("junit testing");
		assertEquals("junit testing",listMock.get(0));
		assertEquals("junit testing",listMock.get(1));
	}
	
	
	@Test
	public void verificationBasics() {
		 String value = listMock.get(0);
		 String value2 = listMock.get(1);
		 verify(listMock).get(0);
		 //verify(listMock).get(anyInt());
		 verify(listMock,times(2)).get(anyInt());
		 verify(listMock,atLeast(1)).get(anyInt());
		 verify(listMock,atLeastOnce()).get(anyInt());
		 verify(listMock,atMost(2)).get(anyInt());
		 verify(listMock,never()).get(2);
	}
	
	@Test
	public void argumentCapturing() {
		listMock.add("some string");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(listMock).add(captor.capture());
		assertEquals("some string",captor.getValue());
	}
	
	@Test
	public void multipleArgumentCapturing() {
		listMock.add("some string");
		listMock.add("some string1");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(listMock,times(2)).add(captor.capture());
		List<String> allValues = captor.getAllValues();
		assertEquals("some string",allValues.get(0));
		assertEquals("some string1",allValues.get(1));
	}
	
	@Test
	public void mocking() {
		listMock.add("some string");
		listMock.add("some string1");
        System.out.println(listMock.size()); //0
        when(listMock.size()).thenReturn(5);	
        System.out.println(listMock.size()); //5
        }
	
	@Test
	public void spying() {
		
		ArrayList arrayListMock = spy(ArrayList.class);
		arrayListMock.add("test0");
		
		
		arrayListMock.add("some string");
		arrayListMock.add("some string1");
        System.out.println(arrayListMock.size()); //0
       // when(listMock.size()).thenReturn(5);	
        System.out.println(arrayListMock.size()); //5
        when(arrayListMock.size()).thenReturn(5);	
        arrayListMock.add("some string100");
        System.out.println(listMock.size()); //5
        }

}
