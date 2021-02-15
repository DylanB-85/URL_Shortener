package com.example.demo.service;


import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.model.UrlShortenerModel;
import com.example.demo.repository.DBRepo;

@Service
public class StoreUrlService {
	@Autowired
	private DBRepo dbRepo;
	
	public UrlShortenerModel store(String shortenerId, String url) {
		String urlName = StringUtils.cleanPath(url);
		UrlShortenerModel shortenerModel = new UrlShortenerModel(shortenerId, urlName, url.getBytes());
		return dbRepo.save(shortenerModel);
	}
	
	public UrlShortenerModel getUrl(String shortenerId) {
		
		return dbRepo.findById(shortenerId).get();
	}
	
	public Stream<UrlShortenerModel> getAllUrls(){
		return dbRepo.findAll().stream();
	}
	
}
