package com.amsidh.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	private String city;
	private String state;
	private Long pincode;

	@ManyToOne
	private Shop shop;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Integer addressId, String city, String state, Long pincode) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public Address(String city, String state, Long pincode) {
		super();
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "Address Id :" + addressId + "     City :" + city + "    State :" + state + "     Pincode:" + pincode;
	}
}
