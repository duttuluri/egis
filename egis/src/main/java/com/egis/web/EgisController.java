package com.egis.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.egis.background.domain.Credentials;
import com.egis.background.domain.Data;
import com.egis.background.domain.Request;
import com.egis.background.domain.Response;
import com.egis.background.service.BackgroundService;
import com.egis.config.Settings;

@RestController
@RequestMapping("/v1")
public class EgisController {
	
	
	@Resource
	Settings settings;
	@Resource
	BackgroundService backgroundService;

	@PostMapping(value="/backgrounddata",consumes="application/json",produces="application/json")
	@ResponseBody
	public Response applicationVersion(@RequestBody Data data) {
		
		Request req= new Request();
		req.credentials = new Credentials();
		req.credentials.account_id=settings.getBackgroundAccountId();
		req.credentials.api_key=settings.getBackgroundAPIKey();
		req.product="federal_criminal";
		req.data=data;
		Response res = backgroundService.getBackGroundData(req);
		return res;
	}
}

