package com.example.service.impl;

import com.example.adaptor.DummyAdaptor;
import com.example.service.DummyService2;
import com.example.utils.DomainUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DummyService2Impl implements DummyService2 {

	@Resource(name = "DummyAdaptor")
	private DummyAdaptor dummyAdaptor;

	@Override
	public void dummyService2() throws Exception {
		System.out.println("I am inside dummyService2");
		System.out.println("Thread ID :::::::::" + Thread.currentThread().getId());
		System.out.println("BannerId ::"+ DomainUtils.getBannerId());

		// Invoking Async method , which will lose httpRequest parameters and header as servlet-container will
		// destroy instance of request.
		dummyAdaptor.dummyApiAdaptor();

		// corrrect way to do this , pass information as parameter or POJO
		dummyAdaptor.dummyApiAdaptor(DomainUtils.getBannerId());
	}




}
