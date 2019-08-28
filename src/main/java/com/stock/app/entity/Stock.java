package com.stock.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int stockId;
	
	private String stockName;
	private double price;
	private int quantity;
	private int trending;
	private String stockExchangeName;
	private double stockPercentage;

}
