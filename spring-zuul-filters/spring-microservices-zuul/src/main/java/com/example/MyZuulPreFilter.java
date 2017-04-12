package com.example;

import com.netflix.zuul.ZuulFilter;

public class MyZuulPreFilter extends ZuulFilter {

	@Override
	public Object run() {
		System.out.println("********** The request has passed through MyZuulPreFilter");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// Could use RequestContext here to determine 
		// things in the request and apply some logic first
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
