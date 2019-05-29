package com.ing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.dao.TransactionDao;
import com.ing.dao.UserDao;
import com.ing.entity.Account;
import com.ing.entity.Transaction;
import com.ing.request.SaveAccountRequest;
import com.ing.response.SaveAccountResponse;
import com.ing.service.FundTransferServiceImpl;
import com.ing.service.UserServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest
//@ContextConfiguration(classes = UserTransactionHistoryApplication.class)
public class UserTransactionHistoryApplicationTests {
	
	@InjectMocks
	UserServiceImp service;
	
	@Mock
	UserDao repo;
	
	@Mock
	TransactionDao transRepo;
	@InjectMocks
	FundTransferServiceImpl fundService;
	
	
	
	//private WebMvc
	@Test
	public void testSaveAccounts() {
		SaveAccountRequest request = new SaveAccountRequest();
		Account acc = new Account();
		acc.setId(1);
		Mockito.when(repo.save(acc)).thenReturn(acc);
		 SaveAccountResponse response = service.saveAccount(request);
		//assertEquals(response.getStatus(), "Sucess");
		// asser
		 assertNotNull(response);
		
	}
	
	@Test
	 public void getFetchAccount() {
	  List<Account> accountList = new ArrayList<Account>();
	  //Account accOne = new Account();
	  Account accOne = new Account(1,"logesh","sekar","logesh","passwd","debited",10000.0,"logesh@xyz.com");
	  accountList.add(accOne);
	  Mockito.when(repo.findAll()).thenReturn(accountList);
	  List<Account> list = service.findAll();
	//  assertThat(list).isEqualTo(accountList);
	 }
	
	@Test
	public void whenGettingTheUser() {
		Account account =new Account(1,"karthik","raja",1234565,"Raja","DPJk12","passwd","savings",10000.0,"nill","logesh","kk@gmail");
		
		Mockito.when(repo.findAccountById(1)).thenReturn(account);
		Account acc= service.getAccountById(account.getId());
		
		assertThat(account).isEqualTo(acc);
	}
	
	@Test
	public void whenGettingTransactions() {
		List<Transaction> transaction =new ArrayList<Transaction>();
		transaction.add(new Transaction(1,"logesh",2,1000.0,"debit","hdfc",1));
		Mockito.when(transRepo.findTransactionsById(1)).thenReturn(transaction);
		
		List<Transaction> list =fundService.getTransactions(1);
		
		assertThat(transaction.size()).isEqualTo(list.size());
		
	}
	
	
	

	 

}
