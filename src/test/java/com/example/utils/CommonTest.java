package com.example.utils;

import com.example.model.TblArea;
import com.example.model.TblCity;
import com.example.model.TblOldPost;
import com.example.model.TblPost;
import com.example.model.TblPrefecture;
import com.example.model.response.SearchByPostCodeResponse;
import com.example.model.response.SearchByPrefectureCodeResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CommonTest {
	
	@InjectMocks
	Common sut;
	
	
	/**
	 * Test Replace Data
	 * Case: Replace "-" to ""
	 * Input:
	 *    "-"
	 * Output:
	 *    ""
	 */
	@Test
	public void testReplaceData1() {
		String input = "-";
		String output = sut.replaceData(input);
		Assert.assertEquals("", output);
	}
	
	/**
	 * Test Replace Data
	 * Case: Replace " " to ""
	 * Input:
	 *    "a b ---c "
	 * Output:
	 *    "abc"
	 */
	@Test
	public void testReplaceData2() {
		String expected = "a b ---c ";
		String actual = sut.replaceData(expected);
		System.out.println(actual);
		Assert.assertEquals("abc", actual);
	}
	
	/**
	 * Test Number
	 * Case: check number
	 * Input:
	 *    "1234"
	 * Output:
	 *    true
	 */
	@Test
	public void testCheckNumber1() {
		String expected = "1234";
		boolean actual = sut.checkNumber(expected);
		Assert.assertTrue(actual == true);
		
	}
	
	/**
	 * Test Number
	 * Case: check number
	 * Input:
	 *    "12ad34"
	 * Output:
	 *    false
	 */
	@Test
	public void testCheckNumber2() {
		String expected = "12ad34";
		boolean actual = sut.checkNumber(expected);
		Assert.assertTrue(actual == false);
		
	}
	
	/**
	 * Test Number
	 * Case: check number
	 * Input:
	 *    " ２"
	 * Output:
	 *    false
	 */
	
	@Test
	public void testCheckNumber3() {
		String expected = "２";
		boolean actual = sut.checkNumber(expected);
		Assert.assertTrue(actual == false);
	}
	
	/**
	 * Test Get List Response From City
	 * Input:
	 *    tblCityList.size() = 2
	 * Output:
	 *    searchByPrefectureCodeResponseList.size() = 2
	 */
	
	@Test
	public void testFindListResponseFromCity() {
		TblCity tblCity1 = new TblCity();
		TblCity tblCity2 = new TblCity();
		
		TblPrefecture tblPrefecture = new TblPrefecture();
		tblCity1.setTblPrefecture(tblPrefecture);
		tblCity2.setTblPrefecture(tblPrefecture);
		
		List<TblCity> tblCityList = new ArrayList<>();
		tblCityList.add(tblCity1);
		tblCityList.add(tblCity2);
		
		List<SearchByPrefectureCodeResponse> searchByPrefectureCodeResponseList =
				sut.findListResponseFromCity(tblCityList);
		
		Assert.assertTrue(searchByPrefectureCodeResponseList.size() == 2);
	}
	
	/**
	 * Test Get List Response From Area
	 * Input:
	 *    tblArea.size() = 2
	 * Output:
	 *    searchByPostCodeResponseList.size() = 2
	 */
	
	@Test
	public void testFindListResponseFromArea() {
		TblArea tblArea1 = new TblArea();
		TblArea tblArea2 = new TblArea();
		
		TblCity tblCity1 = new TblCity();
		TblCity tblCity2 = new TblCity();
		
		TblPrefecture tblPrefecture = new TblPrefecture();
		tblCity1.setTblPrefecture(tblPrefecture);
		tblCity2.setTblPrefecture(tblPrefecture);
		
		TblPost tblPost1 = new TblPost();
		TblPost tblPost2 = new TblPost();
		
		TblOldPost tblOldPost1 = new TblOldPost();
		TblOldPost tblOldPost2 = new TblOldPost();
		
		tblArea1.setTblCity(tblCity1);
		tblArea2.setTblCity(tblCity2);
		tblArea1.setTblPost(tblPost1);
		tblArea2.setTblPost(tblPost2);
		tblArea1.setTblOldPost(tblOldPost1);
		tblArea2.setTblOldPost(tblOldPost2);
		
		List<TblArea> tblAreaList = new ArrayList<>();
		tblAreaList.add(tblArea1);
		tblAreaList.add(tblArea2);
		
		List<SearchByPostCodeResponse> searchByPostCodeResponseList =
				sut.findListResponseFromArea(tblAreaList);
		
		Assert.assertTrue(searchByPostCodeResponseList.size() == 2);
		
	}
	
}
