package com.stock.app.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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
	
	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public StocksResponseDTO buyStock(StocksRequestDTO stocksRequestDTO) {

	
		Stock stock = stocksRepository.findByStockId(stocksRequestDTO.getStockId());
		StocksResponseDTO stocksResponseDTO = new StocksResponseDTO();
		Optional<CMPMarket> CMPMarket = cPMarketRepository.findByStockId(stocksRequestDTO.getStockId());
		
		CMPMarket cMPMarketStore=new CMPMarket();
		if(CMPMarket.isPresent())
		{
			cMPMarketStore=CMPMarket.get();
		}
		
		
		if (stocksRequestDTO.getQuantity() <= 5) {

			BeanUtils.copyProperties(stocksRequestDTO, stocksResponseDTO);

			Double totalprice = (stocksRequestDTO.getPrice() * stocksRequestDTO.getQuantity());
			Double totalWithBrokage = totalprice + (totalprice * (0.1));
			
			Double totalmarketprice = (cMPMarketStore.getMarketPrice() * stocksRequestDTO.getQuantity());
			Double totalmarketpriceWithBrokage = totalmarketprice + (totalmarketprice * (0.1));
			stocksResponseDTO.setStockExchangeName(stocksRequestDTO.getStockExchangeName());
			stocksResponseDTO.setTotalPrice(new BigDecimal(totalWithBrokage).setScale(2, RoundingMode.HALF_UP).doubleValue());
			stocksResponseDTO.setCurrentPrice(cMPMarketStore.getMarketPrice());
			stocksResponseDTO.setTotalCurrentPrice(new BigDecimal(totalmarketpriceWithBrokage).setScale(2, RoundingMode.HALF_UP).doubleValue());
			stocksResponseDTO.setStatusCode(HttpStatus.OK.value());
			stocksResponseDTO.setStockName(stocksRequestDTO.getStockName());
			
			MyStock mystock = new MyStock();
			mystock.setPrice(cMPMarketStore.getMarketPrice());
			mystock.setTotalPrice(totalmarketpriceWithBrokage);
			mystock.setQuantity(stocksRequestDTO.getQuantity());
			mystock.setStatus("Pending");
			mystock.setUserId(stocksRequestDTO.getUserId());
		
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
