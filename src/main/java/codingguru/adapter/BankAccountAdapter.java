package codingguru.adapter;

import codingguru.dto.BankAccountDTO;
import codingguru.entity.BankAccount;

public class BankAccountAdapter {
	public static BankAccount dtoToEntity(BankAccountDTO bankAccount) {
		return new BankAccount(bankAccount.getAccountNumber(), bankAccount.getAccountHolder(), 
				bankAccount.getOpenedDate(), bankAccount.getClosedDate(), bankAccount.getBalance());
	}
	
	public static BankAccountDTO entityToDTO(BankAccount bankAccount) {
		return new BankAccountDTO(bankAccount.getId(), bankAccount.getAccountNumber(), bankAccount.getAccountHolder(), 
				bankAccount.getOpenedDate(), bankAccount.getClosedDate(), bankAccount.getBalance());
	}
}
