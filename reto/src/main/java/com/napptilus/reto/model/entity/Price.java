package com.napptilus.reto.model.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Prices")
public class Price{
	
    static final long serialVersionUID = 1511598038487230103L;
	
	@Id
	@Setter(AccessLevel.NONE)
	@Column(name = "PRICE_LIST")
	private int priceList;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Brand brand;
	
	@Column(name = "START_DATE")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd-HH:mm:ss")
	private Date startDate;
	
	@Column(name = "END_DATE")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd-HH:mm:ss")
	private Date endDate;
	
	@Column(name = "PRODUCT_ID", nullable = false)
	private int productId;
	
	@Column(name = "PRIORITY")
	private int priority;
	
	@Column(name = "PRICE")
	private float price;
	
	@Column(name = "CURR")
	private String curr;
	
	@Column(name = "LAST_UPDATE")
	@Temporal(TemporalType.DATE)
	private Date lastUpdate;
	
	@Column(name = "LAST_UPDATE_BY")
	private String lastUpdateBy;
	
	@PrePersist
	public void prePersist() {
		lastUpdate = new Date();	
	}
	
}
