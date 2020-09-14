package com.rsh.bal;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.rsh.crawler.WebScrape;

public class WebPage {

	private Anchor anchor;
	private String webPageHash;
	private int anchorParseStatus;
	private int emailParseStatus;
	
	//private String html;
	private Document document;
	
	//General constructor for crawling
	public WebPage(Anchor anchor) {
		super();
		this.anchor = anchor;
	}

	public void loadDocumentFromWeb() {
		final String url = 
				"http://www.rsh-engineering.com";
				//"https://shares.telegraph.co.uk/indices/summary/index/MCX";
		
		try {
			
			final Document document = Jsoup.connect(anchor.getAnchorUrl()).get();
			//Jsoup.connect(url).get();
			System.out.println(document.outerHtml());
			
			
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("e="+ex);
			Logger.getLogger(WebScrape.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


	
	
	
	
}
