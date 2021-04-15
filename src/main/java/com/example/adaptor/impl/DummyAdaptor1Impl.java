package com.example.adaptor.impl;

import com.example.adaptor.DummyAdaptor;
import com.example.utils.DomainUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service(value="DummyAdaptor")
public class DummyAdaptor1Impl implements DummyAdaptor {

	@Async
	@Override
	public void dummyApiAdaptor() {
		System.out.println("I am inside DummyAdaptor1Impl::: ");
		try {
			System.out.println("BannerId ::"+ DomainUtils.getBannerId());
			Thread.sleep(50000);

		} catch (RuntimeException | InterruptedException e) {
			System.err.println(e.getCause());
		}
		System.out.println("Thread ID :::::::::" + Thread.currentThread().getId());
	}
}
