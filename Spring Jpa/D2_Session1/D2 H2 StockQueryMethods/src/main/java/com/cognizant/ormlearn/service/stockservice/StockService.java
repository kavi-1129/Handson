package com.cognizant.ormlearn.service.stockservice;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.stock.Stock;
import com.cognizant.ormlearn.stockrepository.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository stockRepository;
	
	public List<Stock> stockDateSearch() {
		return stockRepository.getStockBasedOnDate(Date.valueOf("2019-09-01"), Date.valueOf("2019-09-30"));
	}
	
	public List<Stock> stockPriceSearch() {
		return stockRepository.getStockBasedOnPrice(1200);
	}
	
	public List<Stock> stockTopVolumeSearch() {
		return stockRepository.getTopStockVolume(3);
	}
	
	public List<Stock> stockLowestVolumeSearch() {
		return stockRepository.getLowestStockVolume(3);
	}
}
