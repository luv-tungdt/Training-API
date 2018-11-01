package com.example.model;

import com.example.model.Common.SearchByPostCodeResponseFixtures;
import com.example.model.response.SearchByPostCodeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.ObjectContent;
import org.springframework.boot.test.json.JsonContent;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SuppressWarnings("javadoc")
public class SearchByPostCodeResponseTest {
	
	JacksonTester<SearchByPostCodeResponse> json;
	
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
		String searchByPostCodeResponseJson = SearchByPostCodeResponseFixtures.createTblAreaEntryJson();
		SearchByPostCodeResponse searchByPostCodeResponse = SearchByPostCodeResponseFixtures.createTblArea();
		
		//exercise
		ObjectContent<SearchByPostCodeResponse> actual = json.parse(searchByPostCodeResponseJson);
		
		//verify
		actual.assertThat().isEqualTo(searchByPostCodeResponse);
	}
	
	@Test
	public void testValueToJson() throws Exception {
		//setup
		SearchByPostCodeResponse searchByPostCodeResponse = SearchByPostCodeResponseFixtures.createTblArea();
		
		//exercise
		JsonContent<SearchByPostCodeResponse> actual = json.write(searchByPostCodeResponse);
		
		//verify
		assertThat(actual).extractingJsonPathStringValue("@.code")
			.isEqualTo("1234");
		assertThat(actual).extractingJsonPathStringValue("@.city")
			.isEqualTo("city");
		assertThat(actual).extractingJsonPathStringValue("@.area")
			.isEqualTo("area");
		assertThat(actual).extractingJsonPathStringValue("@.old_post_code")
			.isEqualTo("oldPostCode");
		assertThat(actual).extractingJsonPathStringValue("@.post_code")
			.isEqualTo("postCode");
		assertThat(actual).extractingJsonPathStringValue("@.prefecture_kana")
			.isEqualTo("prefectureKana");
		assertThat(actual).extractingJsonPathStringValue("@.city_kana")
			.isEqualTo("cityKana");
		assertThat(actual).extractingJsonPathStringValue("@.area_kana")
			.isEqualTo("areaKana");
		assertThat(actual).extractingJsonPathNumberValue("@.multi_area")
			.isEqualTo(0);
		assertThat(actual).extractingJsonPathNumberValue("@.koaza_area")
			.isEqualTo(0);
		assertThat(actual).extractingJsonPathNumberValue("@.chome_area")
			.isEqualTo(0);
		assertThat(actual).extractingJsonPathNumberValue("@.multi_post_area")
			.isEqualTo(0);
		assertThat(actual).extractingJsonPathNumberValue("@.update_show")
			.isEqualTo(0);
		assertThat(actual).extractingJsonPathNumberValue("@.change_reason")
			.isEqualTo(0);
		assertThat(actual).extractingJsonPathNumberValue("@.prefecture_code")
			.isEqualTo(0);
	}
}
