package com.napptilus.reto.model.dao;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto {
	
	private int brandId;
	private int productId;
	private int priceList;
	private float price;
	private Date startDate;
	private Date endDate;
}
