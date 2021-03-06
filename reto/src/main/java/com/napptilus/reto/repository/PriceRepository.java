package com.napptilus.reto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.napptilus.reto.model.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {
	
	public List<Price> findAllByBrandIdAndProductId(int brandId, int productId);
	
	public Price findTopByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(int brandId, int productId, Date dateFrom, Date dateTo);

}
