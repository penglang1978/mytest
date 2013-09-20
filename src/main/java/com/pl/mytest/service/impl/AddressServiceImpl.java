package com.pl.mytest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pl.mytest.dao.AddressDao;
import com.pl.mytest.entity.Address;
import com.pl.mytest.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	private AddressDao addressDao;
	
	public void insertAddress(Address addr) {
		Integer aid = addressDao.insertAddress(addr);
	}

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

}
