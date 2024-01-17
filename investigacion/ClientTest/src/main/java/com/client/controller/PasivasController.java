package com.client.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.model.custumer.CustomerInfo;
import com.client.model.movementHistory.MovementHistory;
import com.client.model.personalAccount.PersonalAccount;
import com.client.service.PasivasServices;

@RestController
@RequestMapping("/pasivas")
public class PasivasController {

	@Autowired
	PasivasServices pasivasServices;

	@PostMapping("/customerInfo")
	Optional<CustomerInfo> getUserInfo() {

		Optional<CustomerInfo> addInvoice = pasivasServices.userInfo("25346789","CED","ES","12345687");		
		
		if (addInvoice.isPresent()) {
			System.out.println(addInvoice.get().getAddress().getCity());
			return addInvoice;
		}

		return null;

	}

	@PostMapping("/accountList")
	Optional<PersonalAccount> getUserAccounts() {

		Optional<PersonalAccount> addInvoice = pasivasServices.userAccounts("25346789","CED","12345687");

		if (addInvoice.isPresent()) {
			
			
			if(addInvoice.get().getStatusCode().equalsIgnoreCase("200")) {
				
				System.out.println(addInvoice.get().getStatusCode());
				
			}
			
			
			
			return addInvoice;
		}

		return null;

	}

	@PostMapping("/history")
	Optional<MovementHistory> getUserHistory() {
		Optional<MovementHistory> userHistoryMovements = pasivasServices.userHistoryMovements("44060000848", "01-01-2000", "24-02-2022","4l4nn42909");
	
	
		if (userHistoryMovements.isPresent()) {
			System.out.println(userHistoryMovements.get().getStatusCode());
			return userHistoryMovements;
		}

		return null;

	}

}
