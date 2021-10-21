package com.salil.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salil.service.BankUserService;

@RestController
public class BankUserController {
	
	
	@Resource
	BankUserService bankUserService;

	
	
	@RequestMapping(value = "/bankDetails", method = RequestMethod.GET)
	public List getAllBankDetails() {
		
		return bankUserService.getAllBankDetails();
	}
	
	
	@RequestMapping(value = "/bankDetails/{bankId}", method = RequestMethod.GET)
	public List getBankDetails(@PathVariable("bankId") String bankId) {
		
		return bankUserService.getBankDetails(bankId);
	}
	
	@RequestMapping(value = "/userBankDetails", method = RequestMethod.GET)
	public List getAllUserBankDetails() {
		
		return bankUserService.getAllUserBankDetails();
	}
	
	@RequestMapping(value = "/userBankDetails/{userId}", method = RequestMethod.GET)
	public List getUserBankDetails(@PathVariable("userId") String userId) {
		
		return bankUserService.getUserBankDetails(userId);
	}

}