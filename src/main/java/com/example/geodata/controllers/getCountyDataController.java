package com.example.geodata.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.geodata.wikiData;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class getCountyDataController {
    @GetMapping("/getCountyData")
    public String getPopdata(@RequestParam String county,@RequestParam String state){
        String longString = "<html><table>";
        wikiData gtd = new wikiData();
        ArrayList<List<String>> listOfRowLists = new ArrayList<List<String>>();
        listOfRowLists.clear();
        listOfRowLists = gtd.getCountyPops(county, state);
        for (List<String> rowList:listOfRowLists){
            longString = longString + "<tr>";

            for(int i=0;i<rowList.size()-1;i++){
                longString = longString + "<td>" + rowList.get(i) + "</td>";
            }
            longString = longString + "</tr>";
        }
        longString = longString + "</table></html><p><a href=\"/\">Go Back</a></p>";
        return longString;
    }
}
