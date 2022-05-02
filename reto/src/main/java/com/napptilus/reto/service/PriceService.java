package com.napptilus.reto.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.napptilus.reto.model.entity.Price;
import com.napptilus.reto.repository.PriceRepository;

@Service
public class PriceService implements IPriceService{

	@Autowired
	private PriceRepository priceRepo;
	
	@Override
	public List<Price> getPrices(int brandId, int productId, Date date) {
		List<Price> prices = priceRepo.findAllByBrandIdAndProductId(brandId, productId)
								.stream()
								.filter(p->(p.getStartDate().equals(date) || p.getStartDate().before(date)))
								.filter(p->(p.getEndDate().equals(date) || p.getEndDate().after(date)))
								.collect(Collectors.toList());

		return prices;
	}

	@Override
	public Price getPriorityPriceTop(int brandId, int productId, Date date) {
		return priceRepo.findTopByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, date, date);
	}

}
