package com.ing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ing.request.SaveAccountRequest;
import com.ing.response.SaveAccountResponse;
import com.ing.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping(value = "/addaccount")
	public SaveAccountResponse saveAccount(@RequestBody SaveAccountRequest request) {
		SaveAccountResponse response = new SaveAccountResponse();
		String msg = "Success";
		try {
			service.saveAccount(request);
			//System.out.println("IN Controller saveIncidents:"+request);
			//service.saveIncident(request);
		} catch(Exception e) {
			e.printStackTrace();
			msg = "Failure";
		}
		response.setStatus(msg);
		return response;
		
	}

}
