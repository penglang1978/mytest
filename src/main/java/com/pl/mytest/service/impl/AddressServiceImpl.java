package com.pl.mytest.service.impl;

import com.pl.mytest.dao.AddressDao;
import com.pl.mytest.entity.Address;
import com.pl.mytest.service.AddressService;

public class AddressServiceImpl implements AddressService{
	private AddressDao addressDao;
	
	public void insertAddress(Address addr) {
		Integer aid = addressDao.insertAddress(addr);
	}

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

}
