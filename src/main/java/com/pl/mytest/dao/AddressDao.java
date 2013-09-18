package com.pl.mytest.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.pl.mytest.entity.Address;
import com.pl.mytest.entity.Pagination;

@MapperScan("addressDao")
public interface AddressDao {
	public Integer insertAddress(Address addr);
	public void updateAddress(Address addr);
	public void deleteAddress(Long aid);
	public List<Address> allAddress(Pagination page);
	public Address getAddress(Long aid);
}
