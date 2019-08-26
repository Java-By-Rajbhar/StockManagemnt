package com.stock.app.service;

import com.stock.app.dto.StocksRequestDTO;
import com.stock.app.dto.StocksResponseDTO;

public interface BuyStockService {

	StocksResponseDTO buyStock(StocksRequestDTO stocksRequestDTO);

}
