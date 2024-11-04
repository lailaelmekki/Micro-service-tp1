package ma.enset.bank_account_service.web;

import ma.enset.bank_account_service.dto.BankAccountRequestDTO;
import ma.enset.bank_account_service.dto.BankAccountResponseDTO;
import ma.enset.bank_account_service.entities.BankAccount;
import ma.enset.bank_account_service.mappers.AccountMapper;
import ma.enset.bank_account_service.repositories.BankAccountRepository;
import ma.enset.bank_account_service.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;
    public AccountRestController(BankAccountRepository bankAccountRepository,AccountService accountService,AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;

    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();

    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));

    }
    //Ajout d'un compte
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO) {
        return accountService.addAccount(requestDTO);
    }
    //Updating an account
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount) {
        BankAccount account= bankAccountRepository.findById(id).orElseThrow();
        if(bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if(bankAccount.getCreatedAt()!=null) account.setCreatedAt(new Date());
        if(bankAccount.getType()!=null) account.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }
    //Delete an account
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount (@PathVariable String id) {
        bankAccountRepository.deleteById(id);

    }

}
