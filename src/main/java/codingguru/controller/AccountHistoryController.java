package codingguru.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codingguru.repository.AccountHistoryRepository;

@RestController
@RequestMapping("/api/v1")
public class AccountHistoryController {
	@Autowired
	private AccountHistoryRepository accountHistoryRepository;

	@GetMapping("/account-history")
	public ResponseEntity<?> getAccountHistory() {
		return new ResponseEntity<>(accountHistoryRepository.getAllAccountHistory(), HttpStatus.OK);
	}
	
	@GetMapping("/account-history/{referenceNumber}")
	public ResponseEntity<?> getAccountHistoryByReferenceNumber(@PathVariable("referenceNumber") UUID referenceNumber) {
		return new ResponseEntity<>(accountHistoryRepository.getAccountHistoryByReferenceNumber(referenceNumber), HttpStatus.OK);
	}
	
	@GetMapping("/account-history/{accountNumber}/account")
	public ResponseEntity<?> getAccountHistoryByAccountNumber(@PathVariable("accountNumber") UUID accountNumber) {
		return new ResponseEntity<>(accountHistoryRepository.getAccountHistoryByAccountNumber(accountNumber), HttpStatus.OK);
	}
}
