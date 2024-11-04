package ma.enset.bank_account_service.mappers;

import ma.enset.bank_account_service.dto.BankAccountResponseDTO;
import ma.enset.bank_account_service.dto.BankAccountRequestDTO;
import ma.enset.bank_account_service.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        //Copy properties from the bankAccount entity to the DTO
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
    //Converts a bankAccountRequestDTO to a BankAccount entity
    public BankAccount toBankAccount(BankAccountRequestDTO bankAccountRequestDTO){
        BankAccount bankAccount=new BankAccount();
        BeanUtils.copyProperties(bankAccountRequestDTO,bankAccount);
        return bankAccount;
    }
}
