package com.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import com.bean.Digit;
import com.bean.DigitWord;
import com.bean.TwoDigit;
import com.service.DigitToWordConvert;

public class DigitControllerTest extends AbstractControllerTest {

	@Mock
	private DigitToWordConvert digitService;

	@InjectMocks
	private DigitToWordController controller;

	@Before
	public void setUp() {
		// Initialize Mockito annotated components
		MockitoAnnotations.initMocks(this);
		// Prepare the Spring MVC Mock components for standalone testing
		setUp(controller);
	}

	@Test
	public void testCreateDigitToWord() throws Exception {

		// Create some test data
		DigitWord digitWordBean = new DigitWord(12, "twelve ");

		// Stub the digitService.digitToWordConvert method return bean
		when(digitService.digitToWordConvert(anyInt())).thenReturn(digitWordBean);

		// Perform the behavior being tested
		String uri = "/digits/";
		String inputJson = super.mapToJson(new Digit(12));

		MvcResult result = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();

		// Extract the response status and body
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		// Verify the digitService.digitToWordConvert method was invoked once
		verify(digitService, times(1)).digitToWordConvert(anyInt());

		// Perform standard JUnit assertions on the test results
		Assert.assertEquals("failure - expected HTTP status 201", 201, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() > 0);

		DigitWord createdDigitWord = super.mapFromJson(content, DigitWord.class);

		Assert.assertNotNull("failure - expected entity not null", createdDigitWord);
		Assert.assertNotNull("failure - expected id attribute not null", createdDigitWord.getDigit());
		Assert.assertEquals("failure - expected text attribute match", digitWordBean.getWord(),
				createdDigitWord.getWord());
	}

	@Test
	public void testNullCreateDigitToWord() throws Exception {
		// Create some test data
		DigitWord digitWordBean = new DigitWord(12, "twelve ");

		// Stub the digitService.digitToWordConvert method return bean
		when(digitService.digitToWordConvert(anyInt())).thenReturn(digitWordBean);

		// Perform the behavior being tested
		String uri = "/digits/";
		String inputJson = super.mapToJson("test");

		MvcResult result = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();

		// Extract the response status and body
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		// Verify the digitService.digitToWordConvert method was invoked zero times
		verify(digitService, times(0)).digitToWordConvert(anyInt());

		// Perform standard JUnit assertions on the test results
		Assert.assertEquals("failure - expected HTTP status 400", 400, status);
		// System.out.println(content);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() == 0);

	}

	@Test
	public void getAllWord() throws Exception {
		// Create some test data
		Map<Integer, String> map = Map.of(1, "one ");

		// Stub the digitService.getMap method return map
		when(digitService.getMap()).thenReturn(map);

		// Perform the behavior being tested
		String uri = "/digits";
		// String inputJson = super.mapToJson(new Digit(12));

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

		// Extract the response status and body
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		// Verify the digitService.getMap method was invoked once
		verify(digitService, times(1)).getMap();

		// Perform standard JUnit assertions on the test results
		Assert.assertEquals("failure - expected HTTP status 200", 200, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() > 0);

		Map<Integer, String> resultMap = super.mapFromJson(content, HashMap.class);

		Assert.assertNotNull("failure - expected entity not null", resultMap);
		
		Assert.assertEquals("failure -expected digit is equal", 1, map.containsKey(1) ? 1 : 0);
		Assert.assertEquals("failure - expected word attribute match", "one ", map.get(1));
	}

	@Test
	public void getOnDigit() throws Exception {
		// Create some test data
		DigitWord digitWordBean = new DigitWord(12, "twelve ");

		// Stub the digitService.getDigit method return bean
		when(digitService.getDigit(anyInt())).thenReturn(digitWordBean);

		// Perform the behavior being tested
		int digit = 12;
		String uri = "/digits/{digit}";

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, digit).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		// Extract the response status and body
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		// Verify the digitService.getDigit method was invoked once
		verify(digitService, times(1)).getDigit(anyInt());

		// Perform standard JUnit assertions on the test results
		Assert.assertEquals("failure - expected HTTP status 200", 200, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() > 0);

		DigitWord resultDigitWordBean = super.mapFromJson(content, DigitWord.class);

		Assert.assertNotNull("failure - expected entity not null", resultDigitWordBean);
		Assert.assertEquals("failure -expected digit is equal", digitWordBean.getDigit(),
				resultDigitWordBean.getDigit());
		Assert.assertEquals("failure - expected word attribute match", digitWordBean.getWord(),
				resultDigitWordBean.getWord());
	}

	@Test
	public void getNullOnDigit() throws Exception {
		// Create some test data

		// Stub the digitService.getDigit method return null for badrequest
		when(digitService.getDigit(anyInt())).thenReturn(null);

		// Perform the behavior being tested
		int digit = 12;
		String uri = "/digits/{digit}";
		// String inputJson = super.mapToJson(new Digit(12));

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, digit).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		// Extract the response status and body
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		// Verify the digitService.getDigit method was invoked once
		verify(digitService, times(1)).getDigit(anyInt());

		// Perform standard JUnit assertions on the test results
		Assert.assertEquals("failure - expected HTTP status 400", 400, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() > 0);

	}

	@Test
	public void updateDigitToWord() throws Exception {
		// Create some test data
		when(digitService.updateDigit(anyInt(),anyInt())).thenReturn(true);

		// Perform the behavior being tested
		String uri = "/digits";
		String inputJson = super.mapToJson(new TwoDigit(1,11));

		MvcResult result = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputJson)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();

		// Extract the response status and body
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		// Verify the GreetingService.create method was invoked once
		verify(digitService, times(1)).updateDigit(anyInt(),anyInt());

		// Perform standard JUnit assertions on the test results
		Assert.assertEquals("failure - expected HTTP status 200", 200, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() > 0);

	}
	
	@Test
	public void deleteDigitToWord() throws Exception{
		
		// Stub the digitService.deleteDigit method return value
		when(digitService.deleteDigit(anyInt())).thenReturn(true);

		// Perform the behavior being tested
		int digit=14;
		String uri = "/digits/{digit}";
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.delete(uri,digit))
				.andReturn();

		// Extract the response status and body
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		// Verify the digitService..deleteDigit method was invoked once
		verify(digitService, times(1)).deleteDigit(anyInt());

		// Perform standard JUnit assertions on the test results
		Assert.assertEquals("failure - expected HTTP status 200",200 , status);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length()==0);

	}
	
	@Test
	public void deleteDigitNotFound() throws Exception{
		
		// Stub the digitService.deleteDigit method return value
		when(digitService.deleteDigit(anyInt())).thenReturn(false);

		// Perform the behavior being tested
		int digit=17;
		String uri = "/digits/{digit}";
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.delete(uri,digit))
				.andReturn();

		// Extract the response status and body
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		// Verify the digitService..deleteDigit method was invoked once
		verify(digitService, times(1)).deleteDigit(anyInt());

		// Perform standard JUnit assertions on the test results
		Assert.assertEquals("failure - expected HTTP status 400",400 , status);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length()==0);

	}
}
