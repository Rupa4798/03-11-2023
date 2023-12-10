package com.shopping.controller;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shopping.entity.Stock;
import com.shopping.exception.StockNotFoundException;
import com.shopping.service.StockService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
	Logger logger = LogManager.getLogger(StockController.class);
    @Autowired
    private StockService stockService;

    @GetMapping// To Get all stocks  //http://localhost:9091/api/stocks
    public List<Stock> getAllStocks() {
    	logger.info("All Stocks Viewed");
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")//http://localhost:9091/api/stocks/102
    public Optional<Stock> getStockById(@PathVariable Long id) throws StockNotFoundException{
    	logger.info("Displaying the Stock Id Details");
    	Optional<Stock> optionalStock =stockService.getStockById(id);
		optionalStock.orElseThrow(()-> new StockNotFoundException("Stock not found "+id));
        return optionalStock;
        
    }

    @PostMapping//http://localhost:9091/api/stocks in body add new  data 
    public Stock saveStock(@RequestBody Stock stock) {
    	logger.info("Saved Stock");
        return stockService.saveStock(stock);
    }

    @PutMapping("/{id}")// to edit data http://localhost:9091/api/stocks/302
    public Stock updateStock(@PathVariable Long id, @RequestBody Stock updatedStock){
    	logger.info("Update Stock");
        return stockService.updateStock(id, updatedStock);
    }

    @DeleteMapping("/{id}")// delete stock by id
    public void deleteStock(@PathVariable Long id) {
    	logger.info("Delete Stock");
        stockService.deleteStock(id);
    }
}
