package com.ing.service;

import com.ing.request.SaveAccountRequest;
import com.ing.response.SaveAccountResponse;

public interface UserService {
	public SaveAccountResponse saveAccount(SaveAccountRequest request);
}
