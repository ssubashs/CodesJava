package com.exchange.data.handler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

public class XoomScrapper {
	
	@Test
	public void testScrapper()
	{
		Document doc;
		try {
			doc = Jsoup.connect("https://www.xoom.com/india/fees-fx").get();
			
			Elements sendamount = doc.select("#sendAmount");
			Double sendmoney = Double.valueOf(sendamount.attr("value"));
			Elements receiveamount = doc.select("#receiveAmount");
			Double receivemoney = Double.valueOf(receiveamount.text().);
			System.out.println("send money in $:: "+sendmoney);
			System.out.println("receive money in rupees:: "+receivemoney);
		
			Double exchangeRate = receivemoney/sendmoney;
			System.out.println("exchange rate is "+exchangeRate);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
