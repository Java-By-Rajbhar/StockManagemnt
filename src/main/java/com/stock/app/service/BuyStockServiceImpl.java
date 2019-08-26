package com.stock.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.stock.app.dto.StocksRequestDTO;
import com.stock.app.dto.StocksResponseDTO;
import com.stock.app.entity.CMPMarket;
import com.stock.app.entity.MyStock;
import com.stock.app.entity.Stock;
import com.stock.app.exception.StockNotFoundException;
import com.stock.app.repository.CMPMarketRepository;
import com.stock.app.repository.MyStockRepository;
import com.stock.app.repository.StocksRepository;

@Service
@Transactional

public class BuyStockServiceImpl implements BuyStockService {

	@Autowired
	CMPMarketRepository cPMarketRepository;

	@Autowired
	StocksRepository stocksRepository;

	@Autowired
	MyStockRepository myStockRepository;

	public StocksResponseDTO buyStock(StocksRequestDTO stocksRequestDTO) {

	
		Stock stock = stocksRepository.findByStockId(stocksRequestDTO.getStockId());
		StocksResponseDTO stocksResponseDTO = new StocksResponseDTO();
		Optional<CMPMarket> cmpMarket = cPMarketRepository.findByStockId(stocksRequestDTO.getStockId());
		if (stocksRequestDTO.getQuantity() <= 5) {

			BeanUtils.copyProperties(stocksRequestDTO, stocksResponseDTO);

			Double totalprice = (stocksRequestDTO.getPrice() * stocksRequestDTO.getQuantity());
			Double totalWithBrokage = totalprice + (totalprice * (0.1));
			Double totalmarketprice = (cmpMarket.get().getMarketPrice() * stocksRequestDTO.getQuantity());
			Double totalmarketpriceWithBrokage = totalmarketprice + (totalmarketprice * (0.1));

			stocksResponseDTO.setTotalPrice(totalWithBrokage);
			stocksResponseDTO.setCurrentPrice(cmpMarket.get().getMarketPrice());
			stocksResponseDTO.setTotalCurrentPrice(totalmarketpriceWithBrokage);
			stocksResponseDTO.setStatusCode(HttpStatus.OK.value());

			MyStock mystock = new MyStock();
			mystock.setPrice(totalmarketpriceWithBrokage);
			mystock.setTotalPrice(totalWithBrokage);
			mystock.setQuantity(stocksRequestDTO.getQuantity());
			mystock.setStatus("Pending");
		
			mystock.setStockId(stocksRequestDTO.getStockId());
			myStockRepository.save(mystock);
			stocksResponseDTO.setMyStockId(mystock.getId());

			stock.setTrending(stock.getTrending() + 1);
			stocksRepository.save(stock);

		} else {
			throw new StockNotFoundException("Maximum order Quantity is 5");
		}

		return stocksResponseDTO;

	}

}
