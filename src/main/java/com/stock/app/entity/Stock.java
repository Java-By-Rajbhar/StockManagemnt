package com.stock.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Stock {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int stockId;
	
	private String stockName;
	private double price;
	private int quantity;
	private String trending;
	private String stockExchangeName;

}
