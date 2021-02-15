package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "UrlList")
public class UrlShortenerModel {
	@Id
	private String urlId;
	
	@NotNull
	@Size(min = 5, max = 1024)
	private String url;
	

	
	@Lob
	private byte[] urlData;
	 
	public UrlShortenerModel() {
		
	}
	
	public UrlShortenerModel(String urlId, String url, byte[] urlData) {
		this.urlId = urlId;
		this.url = url;
		this.urlData = urlData;
	}
	
	public String getshortenerId() {
		return urlId;
	}
	
	public String getUrl() {
		return url;
	}
	
	
	public byte[] getUrlData() {
		return urlData;
	}
	
	public void setShortenerId(String urlId) {
		this.urlId= urlId;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public void setUrlData(byte[] urlData) {
		this.urlData = urlData;
	}
}
