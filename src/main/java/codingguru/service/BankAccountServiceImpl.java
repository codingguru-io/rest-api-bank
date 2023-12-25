package codingguru.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codingguru.adapter.BankAccountAdapter;
import codingguru.dto.BankAccountDTO;
import codingguru.dto.AccountHistoryDTO;
import codingguru.entity.BankAccount;
import codingguru.entity.TransactionType;
import codingguru.exception.NotFoundException;
import codingguru.repository.BankAccountRepository;
import jakarta.transaction.Transactional;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	@Autowired
	private BankAccountRepository bankAccountRepository;
	@Autowired
	private AccountHistoryService transferHistoryService;

	@Override
	public void createBankAccount(BankAccountDTO bankAccount) {
		bankAccount.setAccountNumber(UUID.randomUUID());
		bankAccount.setOpenedDate(LocalDateTime.now());
		bankAccountRepository.save(BankAccountAdapter.dtoToEntity(bankAccount));
	}
	
	@Override
	public List<BankAccount> listBankAccounts() {
		return bankAccountRepository.findAll();
	}

	@Transactional
	@Override
	public void deposit(UUID accountNumber, Double amount) throws NotFoundException {
		Optional<BankAccount> bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
		if(bankAccount.isPresent()) {
			bankAccountRepository.deposit(accountNumber, amount);
			transferHistoryService.saveAccountHistory(new AccountHistoryDTO(bankAccount.get(), TransactionType.DEPOSIT, amount));
			return;
		}
		throw new NotFoundException("Account Number Not Found");
	}

	@Transactional
	@Override
	public void withdraw(UUID accountNumber, Double amount) throws NotFoundException {
		Optional<BankAccount> bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
		if(bankAccount.isPresent()) {
			if(bankAccount.get().getBalance() >= amount) {
				bankAccountRepository.withdraw(accountNumber, amount);
				transferHistoryService.saveAccountHistory(new AccountHistoryDTO(bankAccount.get(), TransactionType.WITHDRAW, amount));
			}
			return;
		}
		throw new NotFoundException("Account Number Not Found");
	}

	@Transactional
	@Override
	public void transfer(UUID fromAccountNumber, UUID toAccountNumber, Double amount) throws NotFoundException {
		Optional<BankAccount> fromBankAccount = bankAccountRepository.findByAccountNumber(fromAccountNumber);
		Optional<BankAccount> toBankAccount = bankAccountRepository.findByAccountNumber(toAccountNumber);
		if(fromBankAccount.isPresent() && toBankAccount.isPresent()) {
			if(fromBankAccount.get().getBalance() >= amount) {
				bankAccountRepository.withdraw(fromAccountNumber, amount);
				bankAccountRepository.deposit(toAccountNumber, amount);
				transferHistoryService.saveAccountHistory(new AccountHistoryDTO(fromBankAccount.get(), TransactionType.TRANSFER_OUT, amount));
				transferHistoryService.saveAccountHistory(new AccountHistoryDTO(toBankAccount.get(), TransactionType.TRANSFER_IN, amount));
			}
			return;
		}
		throw new NotFoundException("Account Number Not Found");
	}

	@Transactional
	@Override
	public void closeBankAccount(UUID accountNumber) throws NotFoundException {
		Optional<BankAccount> bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
		if(bankAccount.isPresent()) {
			if(bankAccount.get().getBalance() == 0) {
				bankAccountRepository.closeAccount(accountNumber);
			}
			return;
		}
		throw new NotFoundException("Account Number Not Found");
	}
}
