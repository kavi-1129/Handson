package com.cognizant.ormlearn.stockrepository;

import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.stock.Stock;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
	
	@Query(value = "SELECT s FROM Stock s  WHERE s.date BETWEEN ?1 AND ?2")
	public List<Stock> getStockBasedOnDate(Date startDate, Date endDate); 
	
	@Query(value = "SELECT s FROM Stock s WHERE s.open > ?1 AND s.close > ?1 ")
	public List<Stock> getStockBasedOnPrice(long price);
	
	@Query(value = "SELECT * FROM Stock s ORDER BY s.st_volume DESC LIMIT ?1", nativeQuery = true)
	public List<Stock> getTopStockVolume(long limit);
	
	@Query(value = "SELECT * FROM Stock s ORDER BY s.st_volume LIMIT ?1", nativeQuery = true)
	public List<Stock> getLowestStockVolume(long limit);

}
