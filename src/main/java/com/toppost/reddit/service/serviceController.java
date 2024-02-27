package com.toppost.reddit.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/top")
public class serviceController {
	
	ScraperServiceImpl sc;
	
	public serviceController(ScraperServiceImpl sc) {
		this.sc = sc;
	}
	
	

	@GetMapping
	public ResponseData getPost() {
		return sc.getTopPost();
		
	}
	
}
