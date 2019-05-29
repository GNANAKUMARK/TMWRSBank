package com.ing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.dao.UserDao;
import com.ing.entity.Account;
import com.ing.request.SaveAccountRequest;
import com.ing.response.SaveAccountResponse;
import com.ing.utils.UtilConstants;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	UserDao repo;

	@Override
	public SaveAccountResponse saveAccount(SaveAccountRequest request) {
		SaveAccountResponse response = new  SaveAccountResponse();
		Account account = new Account();
		account.setAccountType(request.getAccType());
		account.setBalance(UtilConstants.DEFAULT_ACC_BALANCE);
		account.setEmailId(request.getEmail_id());
		account.setFirstName(request.getfName());
		account.setLastName(request.getlName());
		account.setMobile(request.getMobile());
		account.setPan(request.getPanCard_no());
		account.setPassword(request.getPassword());
		account.setStatus(UtilConstants.DEFAULT_STATUS);
		account.setUserName(request.getUserName());
		repo.save(account);
		return response;
	}

}
