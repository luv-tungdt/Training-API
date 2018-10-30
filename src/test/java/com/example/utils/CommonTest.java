package com.example.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommonTest {
	
	@Test
	public void testReplaceData1() {
		String input = "-";
		String output = Common.replaceData(input);
		Assert.assertEquals("", output);
	}
	
	@Test
	public void testReplaceData2() {
		String expected = "abc";
		String actual = Common.replaceData(expected);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testReplaceData3() {
		String expected = null;
		String actual = Common.replaceData(expected);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
    public void testCheckNumber1(){
        String expected = "1234";
        boolean actual = Common.checkNumber(expected);
        Assert.assertEquals(true,actual);

    }
    @Test
    public void testCheckNumber2(){
        String expected = "12ad34";
        boolean actual = Common.checkNumber(expected);
        Assert.assertEquals(false,actual);

    }
    @Test
    public void testCheckNumber3(){
        String expected = "２";
        boolean actual = Common.checkNumber(expected);
        Assert.assertEquals(false,actual);
    }
	
}
