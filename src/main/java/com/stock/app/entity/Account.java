package com.stock.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author Sushil
 *
 */
@Data
@Entity
@Table
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accountId;
	private int accountNumber;
	private double balance;
	private String accountHoldername;
	
}
