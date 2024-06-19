package br.com.rappi.sp.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class AuthInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		template.header("API_KEY", "565de077-105a-4fa1-b759-8c14a6a0ab58");

	}

}