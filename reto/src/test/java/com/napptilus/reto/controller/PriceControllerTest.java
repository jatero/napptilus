package com.napptilus.reto.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.MimeTypeUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.napptilus.reto.model.dao.PriceDto;

@AutoConfigureMockMvc
@SpringBootTest
class PriceControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	void test(String reqParam, int result) {
		PriceDto price = null;
		MvcResult findPrice = null;

		try {
			findPrice = mockMvc.perform(
								MockMvcRequestBuilders.get(reqParam)
								.accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
							.andExpect(status().isOk())
							.andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			price = objectMapper.readValue(findPrice.getResponse().getContentAsString(),PriceDto.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//Si el servicio esta OK devuelve la tarifa esperada 
		assert (price.getPriceList() == result);

	}
	
	/**
	 * Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	 */
	@Test
	void testOne() {
		
		String reqParam = "/price/1/35455/2020-06-14-10.00.00";
		int result = 1;
		
		test(reqParam, result);
		
	}
	
	/**
	 *Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	*/
	@Test
	void testTwo() {
		
		String reqParam = "/price/1/35455/2020-06-14-16.00.00";
		int result = 1;
		
		test(reqParam, result);
		
	}

	/**
	 *Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	*/
	@Test
	void testThree() {
		
		String reqParam = "/price/1/35455/2020-06-14-21.00.00";
		int result = 1;
		
		test(reqParam, result);
		
	}

	/**
	 *Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
	*/
	@Test
	void testFour() {
		
		String reqParam = "/price/1/35455/2020-06-15-10.00.00";
		int result = 4;
		
		test(reqParam, result);
		
	}

	/**
	 *Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
	*/
	@Test
	void testFive() {
		
		String reqParam = "/price/1/35455/2020-06-16-21.00.00";
		int result = 4;
		
		test(reqParam, result);
		
	}

}
