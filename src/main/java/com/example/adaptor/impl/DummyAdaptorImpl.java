package com.example.adaptor.impl;

import com.example.adaptor.DummyAdaptor;
import com.example.utils.DomainUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service(value = "DummyAdaptor")
public class DummyAdaptorImpl implements DummyAdaptor {

	@Async
	@Override
	public void dummyApiAdaptor() throws Exception {
		System.out.println("I am inside DummyAdaptor1Impl::: dummyApiAdaptor ");
		System.out.println("Thread ID :::::::::" + Thread.currentThread().getId());
		Thread.sleep(50000);
		System.out.println("BannerId ::" + DomainUtils.getBannerId());
	}

	@Async
	@Override
	public void dummyApiAdaptor(String bannerId) throws Exception {
		System.out.println("I am inside DummyAdaptor1Impl::: dummyApiAdaptor with bannerId ::: " + bannerId);
		System.out.println("Thread ID :::::::::" + Thread.currentThread().getId());
		Thread.sleep(50000);
		// Here HttpRequest instance will be destroyed by servlet container and below method will return null
		// So while using Async, pass information as parameter don't rely on Http component.
		System.out.println("Httprequest BannerId ::" + DomainUtils.getBannerId());

	}
}
