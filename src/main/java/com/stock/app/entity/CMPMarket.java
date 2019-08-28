package com.stock.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class CMPMarket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cmpId;
	private double marketPrice;

	@Temporal(TemporalType.TIMESTAMP)

	private Date dateTime;
	private int stockId;
}
