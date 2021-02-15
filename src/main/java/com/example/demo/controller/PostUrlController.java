package com.example.demo.controller;

import com.google.common.hash.Hashing;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.UrlShortenerModel;
import com.example.demo.service.StoreUrlService;

@Controller
public class PostUrlController {
	@Autowired
	private StoreUrlService storeUrlService;
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ModelAndView urlShortener(HttpServletRequest httpRequest, @Valid UrlShortenerModel request, BindingResult bindingResult) {
		String url = request.getUrl();
		if(!isUrlValid(url)) {
			bindingResult.addError(new ObjectError("url", "Invalid url format: " + url));
		}
		
		ModelAndView modelAndView = new ModelAndView("UrlShortener");
		if(!bindingResult.hasErrors()) {
			final String shortenedId = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
			storeUrlService.store(shortenedId, url);
			String requestUrl = httpRequest.getRequestURL().toString();
			String prefix = requestUrl.substring(0, requestUrl.indexOf(httpRequest.getRequestURI(), "http://".length()));
			modelAndView.addObject("shortenedUrl", prefix + "/" + shortenedId);
		}
		return modelAndView;
	}

	private boolean isUrlValid(String url) {
		boolean isValid = true;
		try {
			new URL(url);
		} catch (MalformedURLException e) {
			isValid = false;
		}
		return isValid;
	}

}
