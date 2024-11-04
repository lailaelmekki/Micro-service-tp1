package ma.enset.bank_account_service.service;

import ma.enset.bank_account_service.dto.BankAccountRequestDTO;
import ma.enset.bank_account_service.dto.BankAccountResponseDTO;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);


    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
