package com.napptilus.reto.service;

import java.util.Date;
import java.util.List;

import com.napptilus.reto.model.entity.Price;

public interface IPriceService {
	
	public List<Price> getPrices(int brandId, int productId, Date date);
	public Price getPriorityPriceTop(int brandId, int productId, Date date);
	
}
