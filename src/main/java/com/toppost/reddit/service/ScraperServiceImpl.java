package com.toppost.reddit.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScraperServiceImpl implements ScraperService{
	@Autowired
	DataRepository dataRepository;

	private String url = "https://www.reddit.com/r/popular/top/?t=day";
	private String className = "block relative cursor-pointer group bg-neutral-background focus-within:bg-neutral-background-hover hover:bg-neutral-background-hover xs:rounded-[16px] px-md py-2xs my-2xs nd:visible";

	private String title, postUrl, subReddit, author;
	@Override
	public ResponseData getTopPost() {
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			Element topPostElement = doc.getElementsByClass(className).first();
			
			if(topPostElement == null) {
				return null;
				
			}
				
			title = topPostElement.attr("post-title");
			postUrl = topPostElement.attr("permalink");
			subReddit = topPostElement.attr("subreddit-prefixed-name");
			author = topPostElement.attr("author");
			
			
			ResponseData rd = new ResponseData(title,postUrl,subReddit, author);
			
			dataRepository.save(rd);
			return rd;
					
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
		

	
	}


	@Override
	public ResponseData showTopPost() {	
		
		
		return null;
	}
	
	
	
	

}
