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

/**
 * 
 * @author Shashank
 *
 */

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyStock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int stockId;
	private int quantity;
	private double price;
	private String status;
	private double totalPrice;
	private int userId;

}
