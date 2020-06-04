package com.johnebri.taskone.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.johnebri.taskone.service.HomeService;
import com.johnebri.taskone.service.Quote;

public class HomeController {

	// consume webservice endpoint and get all the users
	public List<Data> getAllDataFromService() {
		
		List<Data> data = new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate();
		
		// get first page data
		Response response = restTemplate.getForObject(
				"https://jsonmock.hackerrank.com/api/article_users/search?page=1",
				Response.class);
		data.addAll(response.getData());
		
		// get second page data
		Response response2 = restTemplate.getForObject(
				"https://jsonmock.hackerrank.com/api/article_users/search?page=2",
				Response.class);
		data.addAll(response2.getData());
		
		return data;	
	}
	
	// list of most active authors
	public List<String> getUsernames(int threshold) {
		
		// get all data from service
		List<Data> data = getAllDataFromService();
		
		List<String> qualifiedUsers = new ArrayList<>();
		for(int x=0; x<data.size(); x++) {
			if(data.get(x).getSubmission_count() >= threshold) {
				qualifiedUsers.add(data.get(x).getUsername());
			}	
		}
		
		return qualifiedUsers;
	}
	
	public Data getUsernameWithHighestCommentCount() {
		
		// get all data from service
		List<Data> data = getAllDataFromService();		
		
		// sort the array
		for (int i = 0; i < data.size(); i++) 
        {
            for (int j = i + 1; j < data.size(); j++) { 
                if (data.get(i).getComment_count() < data.get(j).getComment_count()) 
                {
                    Data temp1 = data.get(i);  
                    data.set(i, data.get(j));
                    data.set(j, temp1);
                }
            }
        }
		
		// return the user with highest comment
		return data.get(0);
	}
	
	public List<String> getUsernamesSortedByRecordDate(int threshold) {
		
		// get all data from service
		List<Data> data = getAllDataFromService();	
		
		// sort by date
		for (int i = 0; i < data.size(); i++) 
        {
            for (int j = i + 1; j < data.size(); j++) { 
                if (data.get(i).getCreated_at() < data.get(j).getCreated_at()) {
                    Data temp1 = data.get(i);  
                    data.set(i, data.get(j));
                    data.set(j, temp1);
                }
            }
        }
		
		//set by threshold, using submission count as criteria
		List<String> qualifiedUsers = new ArrayList<>();
		for(int x=0; x<data.size(); x++) {
			if(data.get(x).getSubmission_count() >= threshold) {
				qualifiedUsers.add(data.get(x).getUsername());
			}	
		}
		return qualifiedUsers;
	}
	
}
