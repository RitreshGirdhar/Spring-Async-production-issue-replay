package com.example.service.impl;

import com.example.service.DummyService;
import com.example.service.DummyService2;
import com.example.utils.DomainUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DummyServiceImpl implements DummyService {

	@Resource
	private DummyService2 dummyService2;

	@Override
	public void dummyService() throws Exception{
		System.out.println("I am inside dummyService");
		System.out.println("Thread ID :::::::::" + Thread.currentThread().getId());
		System.out.println("BannerId ::"+ DomainUtils.getBannerId());
		dummyService2.dummyService2();
	}
}
