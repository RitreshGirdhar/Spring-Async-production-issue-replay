# Spring Async Thread Issue


Recently, we got major issue in production related to missing Httpheader and HttpRequest parameter after introducing Spring Async. Creating this demo application to make that developer understand how to use Spring Async and why in Async method you would not get HTTP request.


```
```


Without understanding the consequences, One should not add Async annotation at multiple places with the intention to parallelly execute the threads.

Hope, The developer who have added that snipper will understands the concept and will be a great developer one day!
