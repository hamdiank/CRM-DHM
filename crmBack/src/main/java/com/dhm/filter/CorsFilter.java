package com.dhm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String origin = req.getHeader("Origin");
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Methods","GET,POST,DELETE,PUT,HEAD");
		res.setHeader("Access-Control-Allow-Headers",
				"Cache-Control,  Pragma , Origin, X-Requested-With, Content-Type, Accept,Authorization");
		if("OPTIONS".equalsIgnoreCase(req.getMethod())) {
		    res.setStatus(HttpServletResponse.SC_OK);
		} else {
		    chain.doFilter(req, res);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
