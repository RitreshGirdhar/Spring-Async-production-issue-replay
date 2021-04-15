package com.example.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class DomainUtils {

	public static String getBannerId() {
		return getBannerId(getCurrentRequest());
	}

	public static String getBannerId(HttpServletRequest request) {
		return getRequestHeaderValue("banner-id", request);
	}

	public static String getRequestHeaderValue(String key, HttpServletRequest request) {
		String headerValue = null;
		if (request != null && key != null) {
			headerValue = request.getHeader(key);
		}
		return headerValue;
	}

	public static HttpServletRequest getCurrentRequest() {
		HttpServletRequest request = Objects.nonNull(RequestContextHolder
				.getRequestAttributes()) ? ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest() : null;
		return request;
	}
}
