package com.rsh.crawler;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebScrape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final String url = 
				"http://www.rsh-engineering.com";
				//"https://shares.telegraph.co.uk/indices/summary/index/MCX";
		
		try {
			
			final Document document = Jsoup.connect(url).get();
			//Jsoup.connect(url).get();
			System.out.println(document.outerHtml());
			
			/*for(Element row : document.select("table.tablesorter.full tr")) {
				if(row.select("td.nth-of-type(1)").text().equals("")) {
					continue;
				}else {
					final String ticker = 
							row.select("td:nth-of-type(1)").text();
					final String name = 
							row.select("td:nth-of-type(2)").text();
					final String tempPrice = 
							row.select("td.right:nth-of-type(3)").text();
					final String tempPrice1 = 
							tempPrice.replace(",","");
					final double price = Double.parseDouble(tempPrice1);
					System.out.println(ticker + " "+name + " " +price);
				}
			}*/
			
			org.jsoup.select.Elements links = document.select("a");
			for(Element e: links) {
				System.out.println(e.attr("abs:href"));
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("e="+ex);
			Logger.getLogger(WebScrape.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
