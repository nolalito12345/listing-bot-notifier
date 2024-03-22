package com.example.my_project;
import java.util.HashSet;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


public class App 
{
	
	
	
	public static void menu() {}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		String url = "https://www.kijiji.ca/b-apartments-condos/ville-de-montreal/3+bedrooms__3+bedroom+den/c37l1700281a27949001?sort=dateDesc&radius=2.0&address=Montreal%2C+QC+H2X+2Y4&ll=45.514161%2C-73.57067";
		try {
		
		Elements listings = kijiji_quick_scrape.access_kijiji(url);
		HashSet<Element> listings_set = kijiji_quick_scrape.add_to_hash(listings);
		kijiji_quick_scrape.create_msg(listings_set);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
