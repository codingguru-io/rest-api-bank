package codingguru.service;

import java.util.List;
import java.util.UUID;

import codingguru.dto.BankAccountDTO;
import codingguru.entity.BankAccount;
import codingguru.exception.NotFoundException;

public interface BankAccountService {
	public void createBankAccount(BankAccountDTO bankAccount);
	public void closeBankAccount(UUID accountNumber) throws NotFoundException;
	public List<BankAccount> listBankAccounts();
	public void deposit(UUID accountNumber, Double amount) throws NotFoundException;
	public void withdraw(UUID accountNumber, Double amount) throws NotFoundException;
	public void transfer(UUID fromAccountNumber, UUID toAccountNumber, Double amount) throws NotFoundException;
}
