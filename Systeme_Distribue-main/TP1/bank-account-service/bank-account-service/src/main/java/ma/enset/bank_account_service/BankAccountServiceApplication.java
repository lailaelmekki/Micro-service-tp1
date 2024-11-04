package ma.enset.bank_account_service;

import ma.enset.bank_account_service.entities.BankAccount;
import ma.enset.bank_account_service.entities.Customer;
import ma.enset.bank_account_service.enums.AccountType;
import ma.enset.bank_account_service.repositories.BankAccountRepository;
import ma.enset.bank_account_service.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}
    //Premier test de l'application:
	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository , CustomerRepository customerRepository){
		return args ->{
			Stream.of("Mohamed","khaoula","oumaima").forEach(c->{
				Customer customer=Customer.builder()
						.name(c)
						.build();
				customerRepository.save(customer);
			});
			customerRepository.findAll().forEach(customer-> {
				for (int i = 0; i < 10; i++) {
					BankAccount bankAccount = BankAccount.builder()
							.id(UUID.randomUUID().toString())
							.type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
							.balance(10000 + Math.random() * 90000)
							.createdAt(new Date())
							.currency("MAD")
							.customer(customer)
							.build();
					bankAccountRepository.save(bankAccount);


				}
			});
		};
	}
}
