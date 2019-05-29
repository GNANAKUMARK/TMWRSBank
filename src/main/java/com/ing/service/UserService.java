package com.ing.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.ing.request.SaveAccountRequest;
import com.ing.response.SaveAccountResponse;
import com.ing.response.UpdateAccountRequest;

public interface UserService {
	public SaveAccountResponse saveAccount(SaveAccountRequest request);
	public SaveAccountResponse updateAccount(@RequestBody UpdateAccountRequest request);
}
