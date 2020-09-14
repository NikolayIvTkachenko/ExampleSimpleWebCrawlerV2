package com.rsh.webspider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebSpider {

	private final Set<URL> links;
	private final long startTime;
	
	private WebSpider(final URL startURL) {
		this.links = new HashSet<>();
		this.startTime = System.currentTimeMillis();
		crawl(initURLS(startURL));
	}
	
	private void crawl(final Set<URL> urls) {
		
		urls.removeAll(this.links);
		
		
		if(!urls.isEmpty()) {
			final Set<URL> newURLS = new HashSet<>();
			try {
				this.links.addAll(urls);
				for(final URL url: urls) {
					
					System.out.println("time = "+ (System.currentTimeMillis() - this.startTime) + " connected to " + url);
					
					final Document document = Jsoup.connect(url.toString()).get();
					final Elements linksOnPage = document.select("a[href]");
					
					for(final Element element : linksOnPage) {
						final String urlText = element.attr("abs:href");
						final URL discoveredURL = new URL(urlText);
						newURLS.add(discoveredURL);
						
					}
					
				}
			}catch(final Exception | Error ignored) {
				
			}
			crawl(newURLS);
		}
	}
	
	private Set<URL> initURLS(final URL startUrl){
		return Collections.singleton(startUrl);
	}
	
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		final WebSpider spider = new WebSpider(new URL("http://www.rsh-engineering.com"));

	}

}
