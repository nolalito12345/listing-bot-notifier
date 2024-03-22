package com.example.my_project;

import java.util.HashSet;
import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class kijiji_quick_scrape {
	private static HashSet<String> listing_set = new HashSet<>();
	
	
	public static Elements access_kijiji(String url) throws IOException{ 
		Document doc = Jsoup.connect(url).get();
		Elements listings = doc.select("section[data-testid=listing-card]");
		return listings;	
	}
	
	public static HashSet<Element> add_to_hash(Elements listings) { // Adds new listings url to all listings url, returns new listings 
		
		HashSet<Element> tempset = new HashSet<>();
		for(Element listing : listings) { // For each listing loop
			 Element url_element = listing.select("a[href]").first();
			 String url = "https://www.kijiji.ca" + (url_element.attr("href")); // This is the link to the listing
			 
			if(!listing_set.contains(url)) { // New listing!
				listing_set.add(url); // Adds url to the set of all elements
				tempset.add(listing); // Adds url to tempset
					
			}
			break; // FOR TESTING ---------> So it only runs once!
		}
		return tempset; // Returns all the new listing elements as a HashSet

	}
	
	public static void create_msg(HashSet<Element> new_listings) { // Iterates through new listings, sends formatted messages
		
		for(Element listing: new_listings) {
			
			 Element url_element = listing.select("a[href]").first();
			 String url = "https://www.kijiji.ca" + (url_element.attr("href")); 				// This is the link to the listing
			// System.out.println(listing.select("div.(sc-8104538b-1 eMzkXk)"));

			 String message = url;
			 sms_message.sms_message(message);		 // Sends notification

		}
	}
	
	

}
