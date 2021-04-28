package com.example.service;

import org.springframework.scheduling.annotation.Async;

public interface DummyService2 {
	@Async
	void dummyService2() throws Exception;
}
