package com.shopping.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entity.Stock;
import com.shopping.exception.StockNotFoundException;
import com.shopping.repository.StockRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Optional<Stock> getStockById(Long id) {
        return (stockRepository.findById(id));
        
    }

    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

    public Stock updateStock(Long id, Stock updatedStock) {
        return stockRepository.findById(id)
                .map(existingStock -> {
                    existingStock.setsQuantity(updatedStock.getsQuantity());
                    existingStock.setsLocation(updatedStock.getsLocation());
                    existingStock.setsSupplier(updatedStock.getsSupplier());
                    return stockRepository.save(existingStock);
                })
                .orElse(null);
    }
}
