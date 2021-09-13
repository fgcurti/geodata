package com.example.geodata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class wikiData {
      public ArrayList<List<String>> getCountyPops( String county, String state) {
         
         ArrayList<List<String>> listOfTRows = new ArrayList<List<String>>();
         listOfTRows.clear();
         String html = "https://en.wikipedia.org/wiki/" + county + "_County,_" + state;
         try {
            Document doc = Jsoup.connect(html).get();
            Elements tableElements = doc.select("table:contains(Historical population)");
            Elements rowElements = tableElements.select("tr");
            for (int i = 0; i < rowElements.size(); i++) {
               Element rowElement = rowElements.get(i);
               String tempString = rowElement.text();
               tempString = tempString.replaceAll(",","");
               tempString = tempString.replaceAll("%","");
               List<String> items = Arrays.asList(tempString.split(" "));
               listOfTRows.add(items);
            }   
      } catch (IOException e) {
         e.printStackTrace();
      }
      return listOfTRows;    
   } 
}
