package com.egis.background.service.impl;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.egis.background.domain.Credentials;
import com.egis.background.domain.Request;
import com.egis.background.domain.Results;
import com.egis.background.domain.Response;
import com.egis.background.service.BackgroundService;
import com.egis.config.Settings;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class BackgroundServiceImpl implements BackgroundService {

	
	@Resource
	Settings settings;
	public Response getBackGroundData(Request req) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Request> request = new HttpEntity<>(req,headers);
		
		ObjectMapper mapperObj = new ObjectMapper();
        
        try {
            // get Employee object as a json string
            String jsonStr = mapperObj.writeValueAsString(req);
            System.out.println(jsonStr);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Response response = restTemplate.postForObject("https://api.imsasllc.com/v3/", request, Response.class);
        
        try {
            // get Employee object as a json string
            String jsonStrRes = mapperObj.writeValueAsString(response);
            System.out.println(jsonStrRes);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	
		return (Response)response;
	}
	
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
	    int timeout = 5000;
	    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
	      = new HttpComponentsClientHttpRequestFactory();
	    clientHttpRequestFactory.setConnectTimeout(timeout);
	    return clientHttpRequestFactory;
	}
}
