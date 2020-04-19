package com.amsidh.mvc.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer shopId;
	private String shopName;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "shop", fetch = FetchType.LAZY)
	private List<Address> address = new ArrayList<>();

	public Shop() {
		super();
	}

	public Shop(String shopName) {
		super();
		this.shopName = shopName;
	}

	public Shop(Integer shopId, String shopName) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
	}

	public Shop(Integer shopId, String shopName, List<Address> address) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.address = address;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address.addAll(address);
	}

	@Override
	public String toString() {
		return "ShopId :" + shopId + "    ShopName :" + shopName;
	}

}
