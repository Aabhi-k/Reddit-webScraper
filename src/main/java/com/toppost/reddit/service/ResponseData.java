package com.toppost.reddit.service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reddit")
public class ResponseData {
	@Id @Column(name = "url_Id") 
	String url;
	String title;
	String subReddit;
	String author;
	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubReddit() {
		return subReddit;
	}
	public void setSubReddit(String subReddit) {
		this.subReddit = subReddit;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ResponseData(String title,String url, String subReddit, String author) {

		this.title = title;
		this.url = url;
		this.subReddit = subReddit;
		this.author = author;
	}
	
	public ResponseData() {}
	
	
	
}
