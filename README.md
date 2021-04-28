# Spring Async Thread Issue


Recently, we got major issue in production related to missing Httpheader and HttpRequest parameter after introducing Spring Async. Creating this demo application to make that developer understand how to use Spring Async and why in Async method you would not get HTTP request.

With the below snippet you will find out that DomainUtils.getBannerId() or request.getHeader("banner-id") will return null.
```
	@Async
	@Override
	public void dummyApiAdaptor() throws Exception {
		System.out.println("I am inside DummyAdaptor1Impl::: dummyApiAdaptor ");
		System.out.println("Thread ID :::::::::" + Thread.currentThread().getId());
		Thread.sleep(50000);
		System.out.println("BannerId ::" + DomainUtils.getBannerId());
	}
```

Reason is that when The request is created by the servlet container and the request passes through a dispatcher servlet. In the Dispatcher servlet, it identifies that the controller by request mapping and calls the desired method of the controller. When the request been served by the controller and then the controller or service handover the task to Async thread executor and complete the request. Then servlet container either deletes the request object. That is purely based on implementation of servlet container. Because of this, In Async method we would not receive any value from httpservlet request. 

Correct way would be to pass the information as a value before invoking Async Object
```
// Get the value first , then invoke Async method
dummyAdaptor.dummyApiAdaptor(DomainUtils.getBannerId());

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
```

Without understanding the consequences, One should not add Async annotation at multiple places with the intention to parallelly execute the threads.

Hope, The developer who have added that snipper will understands the concept and will be a great developer one day!
