package com.napptilus.reto.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.napptilus.reto.model.dao.PriceDto;
import com.napptilus.reto.model.entity.Price;
import com.napptilus.reto.service.PriceService;

@RestController
@RequestMapping("/price")
public class PrieceController {
	
	@Autowired
	private PriceService servicePrices;
	
	@GetMapping("/{brandId}/{productId}/{date}")
	public @ResponseBody PriceDto retrivePrice(@PathVariable @NonNull int brandId, 
											   @PathVariable @NonNull int productId,
											   @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") Date date) {
		
		Price price = servicePrices.getPriorityPrice(brandId, productId, date);
		
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
