package com.example.demo.controller;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.UrlShortenerModel;
import com.example.demo.service.StoreUrlService;

@Controller
public class GetUrlController {
	@Autowired
	private StoreUrlService storeUrlService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showForm(UrlShortenerModel request) {
		return "UrlShortener";
	}
	
	
	@RequestMapping(value = "/{shortenerId}", method = RequestMethod.GET)
	public void redirectToUrl(@PathVariable String shortenerId, HttpServletResponse resp) throws Exception {
		UrlShortenerModel url = storeUrlService.getUrl(shortenerId);
		if(url != null) {
			String newUrl = url.getUrl();
			resp.addHeader("Location", url.toString());
			resp.sendRedirect(newUrl);
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
