package com.napptilus.reto.service;

import java.util.Date;

import com.napptilus.reto.model.entity.Price;

public interface IPriceService {
	
	public Price getPriorityPrice(int brandId, int productId, Date date);

}
