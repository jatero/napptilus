package com.napptilus.reto.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.napptilus.reto.model.dao.PriceDto;
import com.napptilus.reto.model.entity.Price;
import com.napptilus.reto.service.PriceService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1")
public class PrieceController {
	
	@Autowired
	private PriceService servicePrices;
	
	/**
	 * @param brandId
	 * @param productId
	 * @param date
	 * @return
	 */
	@Tag(name="Recuperar Tarifa", description = "Recupera la tarifa disponible de mayor prioridad por marca y producto en una fecha dada")
	@GetMapping("/price/{brandId}")
	public @ResponseBody PriceDto retrivePrice(@PathVariable @NonNull int brandId, 
											   @RequestParam("productId") @NonNull int productId,
											   @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH.mm.ss") Date date) {
		
		Price price = servicePrices.getPriorityPriceTop(brandId, productId, date);
		
		PriceDto priceDto = new PriceDto();
		priceDto.setBrandId(price.getBrand().getId());
		priceDto.setProductId(price.getProductId());
		priceDto.setPrice(price.getPrice());
		priceDto.setPriceList(price.getPriceList());
		priceDto.setStartDate(price.getStartDate());
		priceDto.setEndDate(price.getEndDate());
		
		return priceDto;
	}

}
