package codingguru.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codingguru.dto.BankAccountDTO;
import codingguru.dto.DepositDTO;
import codingguru.dto.TransferDTO;
import codingguru.dto.WithdrawDTO;
import codingguru.exception.NotFoundException;
import codingguru.service.BankAccountService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/api/v1")
public class BankAccountController {
	@Autowired
	private BankAccountService bankAccountService;
	
	@PostMapping("/accounts")
	public ResponseEntity<?> createAccount(@RequestBody BankAccountDTO account) {
		bankAccountService.createBankAccount(account);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/accounts/{accountNumber}")
	public ResponseEntity<?> createAccount(@PathVariable("accountNumber") UUID accountNumber) throws NotFoundException {
		bankAccountService.closeBankAccount(accountNumber);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RateLimiter(name = "basic")
	@PostMapping("/accounts/transfer")
	public ResponseEntity<?> transfer(@RequestBody TransferDTO transfer) throws NotFoundException {
		bankAccountService.transfer(transfer.getFromAccountId(), transfer.getToAccountId(), transfer.getAmount());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/accounts/deposit")
	public ResponseEntity<?> deposit(@RequestBody DepositDTO deposit) throws NotFoundException {
		bankAccountService.deposit(deposit.getAccountNumber(), deposit.getAmount());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/accounts/withdraw")
	public ResponseEntity<?> withdraw(@RequestBody WithdrawDTO withdraw) throws NotFoundException {
		bankAccountService.withdraw(withdraw.getAccountNumber(), withdraw.getAmount());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/accounts")
	public ResponseEntity<?> listAccounts() {
		return new ResponseEntity<>(bankAccountService.listBankAccounts(), HttpStatus.OK);
	}
}
