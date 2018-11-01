package com.example.model;

import com.example.model.Common.SearchByPrefectureCodeResponseFixtures;
import com.example.model.response.SearchByPrefectureCodeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.json.ObjectContent;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SuppressWarnings("javadoc")
public class SearchByPrefectureCodeResponseTest {
	
	JacksonTester<SearchByPrefectureCodeResponse> json;
	
	private ObjectMapper mapper;
	
	
	@Before
	public void setUp() throws Exception {
		mapper = new ObjectMapper();
		JacksonTester.initFields(this, mapper);
		assert json != null;
	}
	
	@Test
	public void testJsonToValue() throws Exception {
		//setup
		String searchByPrefectureCodeResponseJson = SearchByPrefectureCodeResponseFixtures.createTblCityEntryJson();
		SearchByPrefectureCodeResponse searchByPrefectureCodeResponse = SearchByPrefectureCodeResponseFixtures.createTblCity();
		
		//exercise
		ObjectContent<SearchByPrefectureCodeResponse> actual = json.parse(searchByPrefectureCodeResponseJson);
		
		//verify
		actual.assertThat().isEqualTo(searchByPrefectureCodeResponse);
	}
	
	@Test
	public void testValueToJson() throws Exception {
		//setup
		SearchByPrefectureCodeResponse searchByPrefectureCodeResponse = SearchByPrefectureCodeResponseFixtures.createTblCity();
		
		//exercise
		JsonContent<SearchByPrefectureCodeResponse> actual = json.write(searchByPrefectureCodeResponse);
		
		//verify
		assertThat(actual).extractingJsonPathStringValue("@.code")
			.isEqualTo("1234");
		assertThat(actual).extractingJsonPathStringValue("@.prefecture")
			.isEqualTo("prefecture");
		assertThat(actual).extractingJsonPathStringValue("@.city_kana")
			.isEqualTo("cityKana");
		assertThat(actual).extractingJsonPathStringValue("@.prefecture_code")
			.isEqualTo("prefectureCode");
	}
	
}
