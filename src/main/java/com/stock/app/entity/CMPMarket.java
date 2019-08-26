package com.stock.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
@Data
@Entity
@Table
public class CMPMarket {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cmpId;
	private double marketPrice;
//	@Temporal(TemporalType.TIMESTAMP)
	private LocalDate dateTime;
	private int stockId;
	}
